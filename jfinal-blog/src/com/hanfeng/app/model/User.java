package com.hanfeng.app.model;

import com.jfinal.plugin.activerecord.Model;

public class User extends Model<User> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final User userDao = new User();
	
	public static final String TABLE_NAME = "user_info"; //表名
	public static final String ID = "id"; //id
	public static final String USERNAME = "username";	//名字
	public static final String PASSWORD = "password";	//密码
	public static final String EMAIL = "email";	//邮箱
	
	

	/**
	 * 根据账号和密码检索验证用户
	 * 
	 * @param acccount
	 * @param password
	 * @return
	 */
	public User getByAccountAndPassword(String account, String password) {
		return userDao
				.findFirst(
						"select id,account,username,email,password from user where account=? and password=?",
						account, password);
	}
}
