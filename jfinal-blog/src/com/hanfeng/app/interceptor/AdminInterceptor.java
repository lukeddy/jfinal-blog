package com.hanfeng.app.interceptor;

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
		 User user = controller.getSessionAttr("user");//获取session
//		 if (user!=null && "/admin".equalsIgnoreCase(ai.getActionKey())) {
		 if (user!=null) {
			 ai.invoke();
		}else {
			controller.render("/admin/login.html");
		}
		

	}

}
