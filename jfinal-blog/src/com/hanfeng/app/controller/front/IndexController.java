package com.hanfeng.app.controller.front;

import org.eclipse.jetty.server.handler.ContextHandler;

import com.hanfeng.app.common.config.WebConstant;
import com.hanfeng.app.model.User;
import com.jfinal.core.Controller;
import com.jfinal.ext.handler.ContextPathHandler;
import com.jfinal.kit.StringKit;

/**
 *  前台控制器
 * 
 * @author hanfeng
 * 
 * 2013-11-8
 */
public class IndexController extends Controller {
	public void index(){
		renderText("进入前台");
	}
	/**
	 * 登陆
	 */
	//后台登陆页面
    public void login(){
    	User user = getSessionAttr(WebConstant.USER_SESSION);
    	if (StringKit.notNull(user)) {
			redirect("/admin"); //进入后台首页
		}else {
			render("admin/login.ftl");
		}
    } 
}
