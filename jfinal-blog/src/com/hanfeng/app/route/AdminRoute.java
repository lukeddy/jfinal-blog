package com.hanfeng.app.route;

import com.hanfeng.app.controller.admin.AdminController;
import com.jfinal.config.Routes;

/**
 * 后端路由配置
 * 
 * @author hanfeng
 * 
 * 2013-11-8
 */
public class AdminRoute extends Routes {

	public void config() {
		add("/admin", AdminController.class);
	}

}
