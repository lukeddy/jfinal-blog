package com.hanfeng.app.interceptor;

import com.hanfeng.app.common.config.WebConstant;
import com.hanfeng.app.model.User;
import com.jfinal.aop.Interceptor;
import com.jfinal.core.ActionInvocation;
import com.jfinal.core.Controller;

/**
 * 后台拦截器
 * 
 * @author hanfeng
 *
 */
public class AdminInterceptor implements Interceptor{

	@Override
	public void intercept(ActionInvocation ai) {
		//后台登陆判断
		 Controller controller = ai.getController();
		 User user = controller.getSessionAttr(WebConstant.USER_SESSION);//获取session
		 if (user==null) {
			 controller.redirect("/login");//进行登陆
//			 return;
		}else {
			ai.invoke();//通过
		}
		

	}

}
