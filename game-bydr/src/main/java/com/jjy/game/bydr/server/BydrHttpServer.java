package com.jjy.game.bydr.server;

import java.lang.management.ThreadInfo;

import com.jjy.game.model.handler.http.favicon.GetFaviconHandler;
import com.jjy.game.model.handler.http.server.ExitServerHandler;
import com.jjy.game.model.handler.http.server.JvmInfoHandler;
import com.jjy.game.model.handler.http.server.ReloadConfigHandler;
import com.jjy.game.model.handler.http.server.ReloadScriptHandler;
import com.jjy.game.model.handler.http.server.ThreadInfoHandler;
import com.jzy.game.engine.mina.config.MinaServerConfig;
import com.jzy.game.engine.mina.service.GameHttpSevice;
import com.jzy.game.engine.script.ScriptManager;

/**
 * http服务器
 * 
 * @author JiangZhiYong
 * @QQ 359135103 2017年7月24日 下午1:46:00
 */
public class BydrHttpServer extends GameHttpSevice {

	public BydrHttpServer(MinaServerConfig minaServerConfig) {
		super(minaServerConfig);
	}

	@Override
	protected void running() {
		super.running();
		// 添加关服、脚本加载 等公用 handler
		ScriptManager.getInstance().addIHandler(ReloadScriptHandler.class);
		ScriptManager.getInstance().addIHandler(ExitServerHandler.class);
		ScriptManager.getInstance().addIHandler(ReloadConfigHandler.class);
		ScriptManager.getInstance().addIHandler(JvmInfoHandler.class);
		ScriptManager.getInstance().addIHandler(GetFaviconHandler.class);
		ScriptManager.getInstance().addIHandler(ThreadInfoHandler.class);
	}

}
