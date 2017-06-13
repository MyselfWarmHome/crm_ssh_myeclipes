package com.itheima.web.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.itheima.domain.Dict;
import com.itheima.service.DictService;
import com.itheima.utils.FastJsonUtil;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 字典的控制层
 * @author dell
 *
 */
public class DictAction extends ActionSupport implements ModelDriven<Dict>{

	private static final long serialVersionUID = 1L;

	private Dict dict = new Dict();
	public Dict getModel() {
		return dict;
	}

	private DictService dictService;
	public void setDictService(DictService dictService) {
		this.dictService = dictService;
	}
	
	/**
	 * 通过字典的type_code查询客户的级别或者客户来源
	 * @return
	 */
	public String findByCode(){
		//调用业务层
		//List<Dict> list = dictService.findByCode("006");
		List<Dict> list = dictService.findByCode(dict.getDict_type_code());
		//使用fastJSON
		FastJsonUtil.write_json(ServletActionContext.getResponse(), FastJsonUtil.toJSONString(list));
		return NONE;
	}
}
