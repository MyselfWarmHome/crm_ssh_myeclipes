package com.itheima.service;

import org.springframework.transaction.annotation.Transactional;

import com.itheima.dao.UserDao;
import com.itheima.domain.User;
import com.itheima.utils.MD5Utils;

/**
 * 用户的业务层
 * @author dell
 *
 */
@Transactional
public class UserServiceImpl implements UserService {

	private UserDao userDao;
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	/**
	 * 通过登录名进行校验
	 */
	public User checkCode(String user_code) {
		return userDao.checkCode(user_code);
	}
	
	/**
	 * 保存用户
	 */
	public void save(User user) {
		//对密码进行加密
		String pwd = user.getUser_password();
		user.setUser_password(MD5Utils.md5(pwd));
		//设置用户的状态
		user.setUser_state("1");
		//调用持久层
		userDao.save(user);
		
	}

	/**
	 * 通过登录名和密码做校验
	 */
	public User login(User user) {
		//对密码进行加密
		String pwd = user.getUser_password();
		user.setUser_password(MD5Utils.md5(pwd));
		//查询
		return userDao.login(user);
	}
	
}
