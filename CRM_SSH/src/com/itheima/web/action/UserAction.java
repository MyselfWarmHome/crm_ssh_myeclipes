package com.itheima.web.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.itheima.domain.User;
import com.itheima.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 用户的控制器
 * @author dell
 *
 */
public class UserAction extends ActionSupport implements ModelDriven<User>{

	private static final long serialVersionUID = -3413092622818913571L;

	private User user = new User();
	public User getModel() {
		return user;
	}
	
	private UserService userService;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	/**
	 * 注册功能
	 * @return
	 */
	public String regist(){
		//接受请求的参数
		userService.save(user);
		return LOGIN;
	}
	
	/**
	 * 通过登录名,判断登录名是否存在
	 * @return
	 */
	public String checkCode(){
		//调用业务层
		User u = userService.checkCode(user.getUser_code());
		//获取response对象
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		
		try {
			//获取输出流
			PrintWriter writer = response.getWriter();
			
			//进行判断
			if(u != null){
				//查询到用户了，不可以注册
				writer.print("no");
			}else{
				//不存在登录名，可以注册
				writer.print("yes");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return NONE;
	}
	
	/**
	 * 用户登录
	 * @return
	 */
	public String login(){
		
		User existUser = userService.login(user);
		//判断
		if(existUser == null){
			return LOGIN;
		}else{
			ServletActionContext.getRequest().getSession().setAttribute("existUser", existUser);
			//登录成功
			return "loginOK";
		}
	}
	
	/**
	 * 安全退出
	 * @return
	 */
	public String exit(){
		ServletActionContext.getRequest().getSession().removeAttribute("existUser");
		return LOGIN; 
	}
}
