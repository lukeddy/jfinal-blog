package com.hanfeng.app.validator;

import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;

public class LoginValidator extends Validator{

	@Override
	protected void validate(Controller c) {
		validateRequired("account", "msg", "账号不能为空.");
		validateRequired("password", "msg", "密码不能为空.");
		
	}

	@Override
	protected void handleError(Controller c) {
		c.keepPara("account");
		c.render("/admin/login.html");
	}

}
