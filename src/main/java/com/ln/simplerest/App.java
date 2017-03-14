package com.ln.simplerest;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.inject.Injector;
import com.ln.simplerest.support.guice.InjectorSingleton;
import com.ln.simplerest.support.undertow.UndertowServer;

/**
 * simplerest
 *
 */
public class App {
	
	private final static Logger logger = LoggerFactory.getLogger(App.class);

	public static void main(String[] args) {
		logger.info("Starting SimpleRest service...");

		// 读取属性文件
		String propsFile = getArgValue(args, "-f");
		if (propsFile == null || propsFile.trim().equals("")) {
			logger.error("请用-f启动参数指定属性文件路径！");
			return;
		}
		Properties properties = null;
		try {
			properties = getProperties(propsFile);
		} catch (IOException e) {
			logger.error("加载属性文件出错，{}.", e);
			return;
		}

		try {
			Injector injector = InjectorSingleton.getInstance().getInjector("mybatis-config.xml", properties);
			UndertowServer undertowServer = injector.getInstance(UndertowServer.class);
			undertowServer.start("SimpleRest", "", "");
			logger.info("SimpleRest service started on port {}.", undertowServer.getPort());
		} catch (Exception e) {
			logger.error("Start SimpleRest service failed,{}.", e.getMessage());
		}
	}

	/**
	 * 得到启动参数
	 * 
	 * @param args
	 *            启动参数
	 * @param argName
	 *            参数名
	 * @return 启动参数
	 */
	private static String getArgValue(String[] args, String argName) {
		int optSetting = 0;
		try {
			for (; optSetting < args.length; optSetting++) {
				if (argName.equals(args[optSetting])) {
					return args[++optSetting];
				}
			}
			return "";
		} catch (Exception e) {
			logger.error("获取启动参数失败，{}.", e.getMessage());
			return "";
		}
	}

	/**
	 * 加载属性文件
	 * 
	 * @param propsFile
	 *            属性文件路径
	 * @throws IOException
	 */
	private static Properties getProperties(String propsFile) throws IOException {
		InputStream is = new FileInputStream(propsFile);
		Properties properties = new Properties();
		properties.load(is);
		return properties;
	}
}
