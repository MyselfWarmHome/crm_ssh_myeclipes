package com.itheima.service;

import java.io.File;

import org.hibernate.criterion.DetachedCriteria;

import com.itheima.domain.Customer;
import com.itheima.domain.PageBean;

public interface CustomerService {
	
	public void save(Customer customer);

	public PageBean<Customer> findByPage(Integer pageCode, Integer pageSize, DetachedCriteria criteria);

	public Customer findById(Long cust_id);

	public void delete(Customer customer);

	public void update(Customer customer, File upload, String uploadFileName);
	
}
