package com.itheima.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.itheima.dao.DictDao;
import com.itheima.domain.Dict;

/**
 * 字典模块
 * @author dell
 *
 */
@Transactional
public class DictServiceImpl implements DictService {

	private DictDao dictDao;
	public void setDictDao(DictDao dictDao) {
		this.dictDao = dictDao;
	}

	/**
	 * 根据客户的类别编码查询字典
	 */
	public List<Dict> findByCode(String dict_type_code) {
		return dictDao.findByCode(dict_type_code);
	}
	
}
