package com.hanfeng.app.controller.admin;

import org.apache.log4j.Logger;

import com.hanfeng.app.common.config.WebConstant;
import com.hanfeng.app.interceptor.AdminInterceptor;
import com.hanfeng.app.model.User;
import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.kit.StringKit;

/**
 * 系统后台控制器
 * 
 * @author hanfeng
 *
 * 2013-11-8
 */
@Before(AdminInterceptor.class)
public class AdminController extends Controller{
	private static final Logger LOGGER = Logger.getLogger(AdminController.class);
	
	//默认方法，进入后端首页
    public void index(){
        render("/admin/index.html");
    }
    
    
    
    public void test(){
    	render("/admin/index2.html");
    }
}
