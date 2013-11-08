package com.hanfeng.app.controller.admin;

import com.hanfeng.app.interceptor.AdminInterceptor;
import com.jfinal.aop.Before;
import com.jfinal.core.Controller;

/**
 * 系统后台控制器
 * 
 * @author hanfeng
 *
 * 2013-11-8
 */
@Before(AdminInterceptor.class)
public class AdminController extends Controller{
	//默认方法，进入后端首页
    public void index(){
        renderText("进入后台首页");
    }
}
