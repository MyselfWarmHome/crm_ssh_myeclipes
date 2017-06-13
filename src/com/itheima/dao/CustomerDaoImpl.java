package com.itheima.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.itheima.domain.Customer;
import com.itheima.domain.PageBean;

/**
 * 持久层
 * @author dell
 *
 */
public class CustomerDaoImpl extends HibernateDaoSupport implements CustomerDao {

	/**
	 * 保存客户
	 */
	public void save(Customer customer) {
		//将数据保存到数据库中
		this.getHibernateTemplate().save(customer);
	}

	/**
	 * 分页的查询
	 */
	@SuppressWarnings("all")
	public PageBean<Customer> findByPage(Integer pageCode, Integer pageSize, DetachedCriteria criteria) {
		PageBean<Customer> pageBean = new PageBean<Customer>();
		pageBean.setPageCode(pageCode);
		pageBean.setPageSize(pageSize);
		
		
		//先查总的记录数select count(*) from 表
		criteria.setProjection(Projections.rowCount());
		List<Number> list = (List<Number>) this.getHibernateTemplate().findByCriteria(criteria);
		if(list != null && list.size() > 0){
			int totalCount = list.get(0).intValue();
			//设置总的记录数
			pageBean.setTotalCount(totalCount);
		}

		//先清空DetachedCriteria对象中的查询条件,变为select * from ...
		criteria.setProjection(null);
		//分页查询数据
		List<Customer> beanList = (List<Customer>) this.getHibernateTemplate().findByCriteria(criteria, (pageCode-1)*pageSize, pageSize);
		//设置PageBean对象
		pageBean.setBeanList(beanList);
		
		return pageBean;
	}

	/**
	 * 按照客户的ID查询出客户
	 */
	public Customer findById(Long cust_id) {
		return this.getHibernateTemplate().get(Customer.class, cust_id);
	}
	
	/**
	 * 删除客户
	 */
	public void delete(Customer customer) {
		this.getHibernateTemplate().delete(customer);
	}

	/**
	 * 修改客户
	 */
	public void update(Customer customer) {
		this.getHibernateTemplate().update(customer);
	}

}
