package com.hanfeng.app.common.config;

import com.hanfeng.app.route.AdminRoute;
import com.hanfeng.app.route.FrontRoute;
import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.core.JFinal;
import com.jfinal.render.ViewType;

/**
 * 
 * @author hanfeng
 * 
 * @date 2013-11-8 
 * 
 * @version V1.0
 * 
 * WEB项目配置文件
 *
 */
public class BlogConfig extends JFinalConfig{

	/*
	 * 常量配置(non-Javadoc)
	 * @see com.jfinal.config.JFinalConfig#configConstant(com.jfinal.config.Constants)
	 */
	@Override
	public void configConstant(Constants me) {
		// 开启开发模式
		me.setDevMode(true);	
		//设置默认视图
		me.setViewType(ViewType.JSP);
	}

	/*
	 * 路由配置(non-Javadoc)
	 * @see com.jfinal.config.JFinalConfig#configRoute(com.jfinal.config.Routes)
	 */
	@Override
	public void configRoute(Routes me) {
		me.add(new FrontRoute());//前端路由
		me.add(new AdminRoute());//后端路由
		
	}

	/*
	 * 插件配置(non-Javadoc)
	 * @see com.jfinal.config.JFinalConfig#configPlugin(com.jfinal.config.Plugins)
	 */
	@Override
	public void configPlugin(Plugins me) {
		// TODO Auto-generated method stub
		
	}

	/*
	 * 全局拦截配置(non-Javadoc)
	 * @see com.jfinal.config.JFinalConfig#configInterceptor(com.jfinal.config.Interceptors)
	 */
	@Override
	public void configInterceptor(Interceptors me) {
		// TODO Auto-generated method stub
		
	}

	/*
	 * 配置处理器(non-Javadoc)
	 * @see com.jfinal.config.JFinalConfig#configHandler(com.jfinal.config.Handlers)
	 */
	@Override
	public void configHandler(Handlers me) {
		// TODO Auto-generated method stub
		
	}

	/*
	 * 启动项目
	 */
	public static void main(String[] args) throws Exception {
        JFinal.start("WebRoot", 8080, "/", 5);
    }
}
