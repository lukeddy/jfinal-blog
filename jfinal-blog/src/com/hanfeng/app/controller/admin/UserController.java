package com.hanfeng.app.controller.admin;

import com.hanfeng.app.common.config.WebConstant;
import com.hanfeng.app.model.User;
import com.hanfeng.app.validator.LoginValidator;
import com.jfinal.aop.Before;
import com.jfinal.core.Controller;

/**
 * 用户管理
 * @author hanfeng
 *
 */
public class UserController extends Controller{
	
	/**
	 * 用户登陆
	 */
	@Before(LoginValidator.class)
    public void session(){
    	String account = getPara("account");//获取账号
    	String password = getPara("password"); // 获取密码
    	User user = User.userDao.getByAccountAndPassword(account, password); //检索用户
    	if (user!=null) { //判断检索结果是否为空
				String blogID = account +"###"+password;
				setCookie("blogID",blogID,3600*24*30);//设置Cookie
				setSessionAttr("user", user);
				setSessionAttr("userID", user.get("id"));
				redirect("/admin");
		}else {
			setAttr("msg","用户名或密码出错");
			render("/admin/login.html");
		}
    }
	
	/**
	 * 用户注销
	 */
	 public void logout(){
        removeSessionAttr("user");
        removeSessionAttr("userID");
        removeCookie("blogID");
        redirect("/admin");
	    }
}
