package com.itheima.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.itheima.domain.User;

/**
 * 用户的持久层继承HibernateDaoSupport类
 * @author dell
 *
 */
public class UserDaoImpl extends HibernateDaoSupport implements UserDao{

	/**
	 * 通过登录名进行校验
	 */
	@SuppressWarnings("all")
	public User checkCode(String user_code) {
		List<User> list = (List<User>) this.getHibernateTemplate().find("from User where user_code = ?", user_code);
		if(list != null && list.size() > 0){
			return list.get(0);
		}
		return null;
	}


	/**
	 * 保存用户
	 */
	public void save(User user) {
		this.getHibernateTemplate().save(user);
	}


	/**
	 * 登录功能
	 */
	public User login(User user) {
		//QBC查询，拼接查询条件
		DetachedCriteria criteria = DetachedCriteria.forClass(User.class);
		criteria.add(Restrictions.eq("user_code", user.getUser_code()));
		criteria.add(Restrictions.eq("user_password", user.getUser_password()));
		criteria.add(Restrictions.eq("user_state", "1"));
		//查询
		@SuppressWarnings("all")
		List<User> list = (List<User>) this.getHibernateTemplate().findByCriteria(criteria);
		if(list != null && list.size() > 0){
			return list.get(0);
		}
		return null;
	}
	
}
