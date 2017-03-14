package com.ln.simplerest.support.undertow;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import org.jboss.resteasy.plugins.server.undertow.UndertowJaxrsServer;

import io.undertow.Undertow;
import io.undertow.servlet.api.DeploymentInfo;

@Singleton
public final class UndertowServer {

	// 主机
	private String host;

	// 端口
	private int port;
	
	
	public String getHost() {
		return this.host;
	}
	
	public int getPort() {
		return this.port;
	}

	/**
	 * 默认构造函数
	 * 
	 * @param host
	 *            监听主机
	 * @param port
	 *            监听端口
	 */
	@Inject
	public UndertowServer(@Named("undertow.host") String host, @Named("undertow.port") int port) {
		this.host = host;
		this.port = port;
	}

	/**
	 * 启动服务器
	 * @param appName 部署的应用名称
	 * @param rootPath 根路径
	 * @param appPath 应用路径
	 */
	public void start(String appName, String rootPath, String appPath) {
		Undertow.Builder serverBuilder = Undertow.builder().addHttpListener(port, host);
		UndertowJaxrsServer server = new UndertowJaxrsServer();
		server.start(serverBuilder);
		
		DeploymentInfo di = server.undertowDeployment(ApplicationClass.class, appPath)
                .setClassLoader(UndertowServer.class.getClassLoader())
                .setContextPath(rootPath)
                .setDeploymentName(appName);
		server.deploy(di);
	}

}
