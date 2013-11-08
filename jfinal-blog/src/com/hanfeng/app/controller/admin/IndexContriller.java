package com.hanfeng.app.controller.admin;

import com.jfinal.core.Controller;

/**
 *  前台控制器
 * 
 * @author hanfeng
 * 
 * 2013-11-8
 */
public class IndexContriller extends Controller {
	public void index(){
		renderText("进入前台");
	}
}
