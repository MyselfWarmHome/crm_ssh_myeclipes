package com.itheima.dao;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.itheima.domain.Dict;

public class DictDaoImpl extends HibernateDaoSupport implements DictDao {

	/**
	 * 根据客户的类别编码查询字典
	 */
	@SuppressWarnings("all")
	public List<Dict> findByCode(String dict_type_code) {
		return (List<Dict>) this.getHibernateTemplate().find("from Dict where dict_type_code=?", dict_type_code);
	}

}
