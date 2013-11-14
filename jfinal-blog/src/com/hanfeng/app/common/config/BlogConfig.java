package com.hanfeng.app.common.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.hanfeng.app.common.utils.ConfigUtil;
import com.hanfeng.app.model.User;
import com.hanfeng.app.route.AdminRoute;
import com.hanfeng.app.route.FrontRoute;
import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.core.JFinal;
import com.jfinal.ext.interceptor.SessionInViewInterceptor;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.activerecord.CaseInsensitiveContainerFactory;
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
	//设置项目是否处于开发模式
	private boolean isLocal = isDevMode();
	
   private boolean isDevMode(){
        String osName = System.getProperty("os.name");
        return osName.indexOf("Windows") != -1;
    }

	/*
	 * 常量配置(non-Javadoc)
	 * @see com.jfinal.config.JFinalConfig#configConstant(com.jfinal.config.Constants)
	 */
	@Override
	public void configConstant(Constants me) {
		//加载配置文件
		ConfigUtil.loadConfig(loadPropertyFile("baseconfig.properties"));
		// 开启开发模式
		if (isLocal) {
			me.setDevMode(true);	
		}
		//设置默认视图 使用Freemarker模板
		me.setViewType(ViewType.FREE_MARKER);
		//设置模板视图路径
		me.setBaseViewPath(WebConstant.WEB_ROOT_DIR);
		//设置404错误处理
		me.setError404View(WebConstant.WEB_ROOT_DIR+"/error/404.html");
		//设置500错误处理
		me.setError404View(WebConstant.WEB_ROOT_DIR+"/error/500.html");
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
		// DruidPlugin
		DruidDataSource ds = new DruidDataSource();
		if (isLocal) {
			ds.setUrl(getProperty("dev.jdbc.url"));
			ds.setUsername(getProperty("dev.user"));
			ds.setPassword(getProperty("dev.passwod"));
		}else {
			
		}
		
		// ActiveRecordPlugin
		ActiveRecordPlugin arp = new ActiveRecordPlugin(ds).setShowSql(true);
		arp.setContainerFactory(new CaseInsensitiveContainerFactory(false));
		me.add(arp);
		
		// 添加表匹配
		arp.addMapping("user", User.class);
		
		
	}

	/*
	 * 全局拦截配置(non-Javadoc)
	 * @see com.jfinal.config.JFinalConfig#configInterceptor(com.jfinal.config.Interceptors)
	 */
	@Override
	public void configInterceptor(Interceptors me) {
		// TODO Auto-generated method stub
		me.add(new SessionInViewInterceptor());
	}

	/*
	 * 配置处理器(non-Javadoc)
	 * @see com.jfinal.config.JFinalConfig#configHandler(com.jfinal.config.Handlers)
	 */
	@Override
	public void configHandler(Handlers me) {
		// TODO Auto-generated method stub
		
	}
	
	
	@Override
	public void beforeJFinalStop() {
		// TODO Auto-generated method stub
		super.beforeJFinalStop();
}

	@Override
	public void afterJFinalStart() {
		// TODO Auto-generated method stub
		super.afterJFinalStart();
	}
	
	/*
	 * 启动项目
	 */
	public static void main(String[] args) throws Exception {
        JFinal.start("WebRoot", 8080, "/", 5);
    }
}
