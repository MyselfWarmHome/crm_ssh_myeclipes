package com.itheima.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * 客户的JavaBean
 * 一方
 * @author Administrator
 */
public class Customer {
	
	private Long cust_id;
	//客户的名称
	private String cust_name;
	private Long cust_user_id;
	private Long cust_create_id;
	
	/*//客户的来源
	private String cust_source;
	//所属于行业
	private String cust_industry;
	//客户的级别
	private String cust_level;*/
	//联系人的名称
	private String cust_linkman;
	
	//固定电话
	private String cust_phone;
	//移动电话
	private String cust_mobile;
	
    private String cust_address;
    private String cust_zip;
  
    private String cust_fax;
    
    private String cust_website;
	
    //维护三个外键
    private Dict source;
    
    private Dict industry;
    
    private Dict level;
    
    //上传文件保存的路径
    private String filepath;
    
    
    
	// Hibernate框架默认的集合是set集合，集合必须要自己手动的初始化
	//private Set<Linkman> linkmans = new HashSet<Linkman>();
	
	public String getFilepath() {
		return filepath;
	}
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
	public String getCust_address() {
		return cust_address;
	}
	public void setCust_address(String cust_address) {
		this.cust_address = cust_address;
	}
	public String getCust_zip() {
		return cust_zip;
	}
	public void setCust_zip(String cust_zip) {
		this.cust_zip = cust_zip;
	}
	public String getCust_fax() {
		return cust_fax;
	}
	public void setCust_fax(String cust_fax) {
		this.cust_fax = cust_fax;
	}
	public String getCust_website() {
		return cust_website;
	}
	public void setCust_website(String cust_website) {
		this.cust_website = cust_website;
	}
	
	public Long getCust_id() {
		return cust_id;
	}
	public void setCust_id(Long cust_id) {
		this.cust_id = cust_id;
	}
	public String getCust_name() {
		return cust_name;
	}
	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}
	public Long getCust_user_id() {
		return cust_user_id;
	}
	public void setCust_user_id(Long cust_user_id) {
		this.cust_user_id = cust_user_id;
	}
	public Long getCust_create_id() {
		return cust_create_id;
	}
	public void setCust_create_id(Long cust_create_id) {
		this.cust_create_id = cust_create_id;
	}
	public String getCust_linkman() {
		return cust_linkman;
	}
	public void setCust_linkman(String cust_linkman) {
		this.cust_linkman = cust_linkman;
	}
	public String getCust_phone() {
		return cust_phone;
	}
	public void setCust_phone(String cust_phone) {
		this.cust_phone = cust_phone;
	}
	public String getCust_mobile() {
		return cust_mobile;
	}
	public void setCust_mobile(String cust_mobile) {
		this.cust_mobile = cust_mobile;
	}
	/*public Set<Linkman> getLinkmans() {
		return linkmans;
	}
	public void setLinkmans(Set<Linkman> linkmans) {
		this.linkmans = linkmans;
	}*/
	public Dict getSource() {
		return source;
	}
	public void setSource(Dict source) {
		this.source = source;
	}
	public Dict getIndustry() {
		return industry;
	}
	public void setIndustry(Dict industry) {
		this.industry = industry;
	}
	public Dict getLevel() {
		return level;
	}
	public void setLevel(Dict level) {
		this.level = level;
	}
}



















