package com.hanfeng.app.route;

import com.hanfeng.app.controller.front.IndexController;
import com.jfinal.config.Routes;

/**
 * 前端路由配置
 * 
 * @author hanfeng
 *
 * 2013-11-8
 */
public class FrontRoute extends Routes{

	@Override
	public void config() {
		add("/",IndexController.class);		
	}

}
