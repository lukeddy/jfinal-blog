package com.hanfeng.app.interceptor;

import com.jfinal.aop.Interceptor;
import com.jfinal.core.ActionInvocation;

/**
 * 后台拦截器
 * 
 * @author hanfeng
 *
 */
public class AdminInterceptor implements Interceptor{

	@Override
	public void intercept(ActionInvocation ai) {
		// TODO Auto-generated method stub
		System.out.println("后台拦截器");
		ai.invoke();
	}

}
