package com.itheima.web.action;

import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.itheima.domain.Customer;
import com.itheima.domain.PageBean;
import com.itheima.service.CustomerService;
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
	public Customer getModel() {
		return customer;
	}
	
	//提供service的成员属性，提供set方法
	private CustomerService customerService;
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}


	/**
	 * 保存客户
	 * @return
	 */
	public String add(){
		customerService.save(customer);
		return SUCCESS;
	}
	
	//当前页默认值为1,属性驱动的方式
	private Integer pageCode = 1;
	public void setPageCode(Integer pageCode) {
		if(pageCode == null){
			pageCode = 1;
		}
		this.pageCode = pageCode;
	}
	//每页显示的条数
	private Integer pageSize = 2;
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	/**
	 * 分页查询
	 * @return
	 */
	public String findByPage(){
		//调用Service
		DetachedCriteria criteria = DetachedCriteria.forClass(Customer.class);
		//查询
		PageBean<Customer> page = customerService.findByPage(pageCode,pageSize,criteria);
		//压栈
		ValueStack stack = ActionContext.getContext().getValueStack();
		stack.set("page",page);
		
		return "page";
	}
}