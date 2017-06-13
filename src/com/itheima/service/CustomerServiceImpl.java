package com.itheima.service;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.aspectj.lang.annotation.Before;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Transactional;

import com.itheima.dao.CustomerDao;
import com.itheima.domain.Customer;
import com.itheima.domain.PageBean;
import com.itheima.utils.UploadUtils;
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


	/**
	 * 删除客户
	 * 按照客户的ID删除客户(主键)
	 */
	public Customer findById(Long cust_id) {
		return customerDao.findById(cust_id);
	}


	/**
	 * 删除客户
	 */
	public void delete(Customer customer) {
		customerDao.delete(customer);
	}


	/**
	 * 修改客户
	 */
	public void update(Customer customer, File upload, String uploadFileName){

		//判断文件是否上传
		if(uploadFileName != null){//客户上传了新的图片
			//先删除旧的图片
			String oldfilepath = customer.getFilepath();
			if(oldfilepath != null && !oldfilepath.trim().isEmpty()){
				//删除图片，旧的图片存在
				new File(oldfilepath).delete();
			}
			//上传新的图片,处理文件的名称
			String uuidname = UploadUtils.getUUIDName(uploadFileName);
			String path = "F:\\apache-tomcat-7.0.77\\webapps\\upload\\";
			File file = new File(path+uuidname);
			
			try {
				FileUtils.copyFile(upload, file);
			} catch (IOException e) {
				e.printStackTrace();
			}
			//将更新的数据保存到数据库中
			customer.setFilepath(path+uuidname);
		}
		customerDao.update(customer);
	}
}
