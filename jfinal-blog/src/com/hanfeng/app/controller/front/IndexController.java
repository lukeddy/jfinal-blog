package com.hanfeng.app.controller.front;

import com.jfinal.core.Controller;

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
}
