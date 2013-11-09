package com.hanfeng.app.model;

import com.jfinal.plugin.activerecord.Model;

public class User extends Model<User> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final User userDao = new User();

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
