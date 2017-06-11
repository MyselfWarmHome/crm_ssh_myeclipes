package com.itheima.service;

import org.aspectj.lang.annotation.Before;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Transactional;

import com.itheima.dao.CustomerDao;
import com.itheima.domain.Customer;
import com.itheima.domain.PageBean;
/**
 * 客户的业务层
 * @author dell
 *
 */
@Transactional
public class CustomerServiceImpl implements CustomerService {

	private CustomerDao customerDao;
	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}


	/**
	 * 保存客户
	 */
	public void save(Customer customer) {
		System.out.println("业务层保存客户");
		customerDao.save(customer);
	}


	/**
	 * 分页查询
	 */
	public PageBean<Customer> findByPage(Integer pageCode, Integer pageSize, DetachedCriteria criteria) {
		return customerDao.findByPage(pageCode,pageSize,criteria);
	}

}
