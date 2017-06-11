package com.itheima.web.action;

import org.apache.struts2.ServletActionContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.itheima.domain.Customer;
import com.itheima.service.CustomerService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

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
		
		System.out.println("web层保存客户");
		//WEB工厂
		/*WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(ServletActionContext.getServletContext());
		CustomerService cs = (CustomerService) context.getBean("customerService");
		cs.save(customer);*/
		customerService.save(customer);
		return SUCCESS;
	}
	
}