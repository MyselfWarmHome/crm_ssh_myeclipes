package com.itheima.utils;

import java.util.UUID;

/**
 * 
 * 文件上传工具类
 * @author dell
 *
 */
public class UploadUtils {

	/**
	 * 传入文件名称，返回唯一的名称
	 * @param filename
	 * @return
	 */
	public static String getUUIDName(String filename){
		//先查找
		int index = filename.lastIndexOf(".");
		//截取
		String lastname = filename.substring(index, filename.length());
		//唯一的字符串
		String uuid = UUID.randomUUID().toString().replace("-", "");
		
		return uuid+lastname;
	}
}
