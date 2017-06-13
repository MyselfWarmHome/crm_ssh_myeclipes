package com.itheima.web.action;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.itheima.domain.Customer;
import com.itheima.domain.Dict;
import com.itheima.domain.PageBean;
import com.itheima.service.CustomerService;
import com.itheima.utils.UploadUtils;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;

/**
 * 客户的控制层
 * @author dell
 *
 */

public class CustomerAction extends ActionSupport implements ModelDriven<Customer>{

	private static final long serialVersionUID = 113695314694166436L;
	
	//手动去new
	private Customer customer = new Customer();
	//使用值栈
	public Customer getModel() {
		return customer;
	}
	
	//提供service的成员属性，提供set方法
	private CustomerService customerService;
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}


	/**
	 * 文件上传:在CustomerAction类中定义成员的属性
	 * 命名的规则:
	 * 	1.private File upload;//上传的文件
	 * 	2.private String uploadFileName;//上传文件的名称(没有中文乱码)
	 *  3.private String uploadContentType;//上传文件的MIME类型
	 *  提供set方法
	 */
	private File upload;
	private String uploadFileName;
	private String uploadContentType;
	public void setUpload(File upload) {
		this.upload = upload;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	/**
	 * 保存客户
	 * @return
	 * @throws IOException 
	 */
	public String add() throws IOException{
		//操作文件上传
		if(uploadFileName != null){
			//处理文件的名称
			String uuidname = UploadUtils.getUUIDName(uploadFileName);
			//将图片上传到服务器的upload文件夹
			String path = "F:\\apache-tomcat-7.0.77\\webapps\\upload\\";
			//创建File对象
			File file = new File(path+uuidname);
			//上传文件
			FileUtils.copyFile(upload, file);
		
			//将上传的路径保存到数据库中
			customer.setFilepath(path+uuidname);
		}
		
		customerService.save(customer);
		return SUCCESS;
	}
	
	// 属性驱动的方式
		// 当前页，默认值就是1  
		private Integer pageCode = 1;
		public void setPageCode(Integer pageCode) {
			if(pageCode == null){
				pageCode = 1;
			}
			this.pageCode = pageCode;
		}
		
		// 每页显示的数据的条数
		private Integer pageSize = 2;
		public void setPageSize(Integer pageSize) {
			this.pageSize = pageSize;
		}
		
		/**
		 * 分页的查询方法
		 * @return
		 */
		public String findByPage(){
			// 调用service业务层
			DetachedCriteria criteria = DetachedCriteria.forClass(Customer.class);
			//拼接查询的条件
			String cust_name = customer.getCust_name();
			if(cust_name != null && !cust_name.trim().isEmpty()){
				//客户名称输入了名称了
				criteria.add(Restrictions.like("cust_name", "%"+cust_name+"%"));
			}
			
			//拼接客户的级别
			Dict level = customer.getLevel();
			if(level != null && !level.getDict_id().trim().isEmpty()){
				//客户已经选择了一个级别
				criteria.add(Restrictions.eq("level.dict_id", level.getDict_id()));
			}
			
			//拼接客户的来源
			Dict source = customer.getSource();
			if(source != null && !source.getDict_id().trim().isEmpty()){
				//客户已经选择了一个级别
				criteria.add(Restrictions.eq("source.dict_id", source.getDict_id()));
			}
			
			// 查询
			PageBean<Customer> page = customerService.findByPage(pageCode,pageSize,criteria);
			// 压栈
			ValueStack vs = ActionContext.getContext().getValueStack();
			//  栈顶是map<"page",page对象>
			vs.set("page", page);
			return "page";
		}
		
		//切换到add.jsp页面
		public String initAddUI(){
			
			return "initAddUI";
		}
		
		/**
		 * 删除客户
		 * @return
		 */
		public String delete(){
			//查对象，获取文件的路径
			customer = customerService.findById(customer.getCust_id());
			
			String filepath = customer.getFilepath();
			
			//删除客户
			customerService.delete(customer);
			
			//删除上传文件 
			File file = new File(filepath);	
			if(file.exists()){
				file.delete();
			}
			
			return "delete";
		}
		
		/**
		 * 跳到初始化修改的页面
		 * @return
		 */
		public String initUpdate(){
			//默认customer压栈
			customer = customerService.findById(customer.getCust_id());
			return "initUpdate";
		}

		/**
		 * 修改客户的功能
		 * @return
		 * @throws IOException 
		 */
		public String update() throws IOException{
			//更新客户的信息
			customerService.update(customer,upload,uploadFileName);
			return "update";
		}
}