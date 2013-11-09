package com.hanfeng.app.ext.beelt;

import java.io.File;

import org.bee.tl.core.GroupTemplate;
import org.bee.tl.ext.jfinal.BeetlRender;

import com.hanfeng.app.common.config.WebConstant;
import com.jfinal.kit.PathKit;
import com.jfinal.render.IMainRenderFactory;
import com.jfinal.render.Render;

/**
 * 
 * 
 * @author hanfeng
 *
 */
public class BeetlRenderFactory implements IMainRenderFactory{
	public static String viewExtension = ".html";
    public static GroupTemplate gt = null;

	public BeetlRenderFactory(boolean isLocal){
		//获取模板路径，使用 jfinal自带的PathKit来获取 webRootPath
		File file = new File(PathKit.getWebRootPath()+WebConstant.BEETL_ROOT_DIR);
		//设置群组模板
		gt = new GroupTemplate(file);
		if (isLocal) { //如果是本地开发模式，可以检查模板文件是否变动
			gt.enableChecker(2);
		}else {
			gt.enableChecker(0); //在正式部署设置为0，不坚持模板文件变动
		}
		
		gt.setCharset("UTF-8");//设置模板文件编码格式
		gt.setStatementStart("@");//控制语句以“@”开始
		gt.setStatementEnd(null);
		
	}
	
	@Override
	public Render getRender(String view) {
		return new BeetlRender(gt, view);
	}

	@Override
	public String getViewExtension() {
		return viewExtension;
	}

}
