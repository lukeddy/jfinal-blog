package com.hanfeng.app.route;

import com.hanfeng.app.controller.admin.AdminController;
import com.hanfeng.app.controller.admin.UserController;
import com.jfinal.config.Routes;

/**
 * 后端路由配置
 * 
 * @author hanfeng
 * 
 * 2013-11-8
 */
public class AdminRoute extends Routes {
	
	@Override
	public void config() {
		add("/admin", AdminController.class);
		add("/admin/user",UserController.class);
	}

}
