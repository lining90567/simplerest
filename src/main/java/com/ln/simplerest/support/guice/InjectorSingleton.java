package com.ln.simplerest.support.guice;

import java.util.Properties;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.name.Names;

/**
 * Guice Injector单例类
 * 
 * @author ln
 *
 */
public class InjectorSingleton {

	private Injector injector = null;

	private InjectorSingleton() {
	}

	private static class InstanceHolder {
		private static InjectorSingleton instance = new InjectorSingleton();
	}

	public static InjectorSingleton getInstance() {
		return InstanceHolder.instance;
	}

	public Injector getInjector(String myBatisConfigFile, Properties properties) {
		if(this.injector != null) {
			return injector;
		}
		this.injector = Guice.createInjector(new GuiceModule() {
            @Override
            protected void initialize() {
            	bindConstant().annotatedWith(Names.named("mybatis.conf.file")).to(myBatisConfigFile);
            	Names.bindProperties(binder(), properties);
            	
            	install(new AppModule());
            }
        });
		return this.injector;
	}
	
	public Injector getInjector() {
		return this.injector;
	}

}
