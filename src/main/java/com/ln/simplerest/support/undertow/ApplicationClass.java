package com.ln.simplerest.support.undertow;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import com.google.inject.Injector;
import com.ln.simplerest.resource.GoodsResource;
import com.ln.simplerest.resource.OrderItemResource;
import com.ln.simplerest.resource.OrderResource;
import com.ln.simplerest.support.guice.InjectorSingleton;

public class ApplicationClass extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new LinkedHashSet<Class<?>>();
        return resources;
    }

    @Override
    public Set<Object> getSingletons() {
        Set<Object> resources = new LinkedHashSet<Object>();
        Injector injector = InjectorSingleton.getInstance().getInjector();
        //在此注册资源类
        resources.add(injector.getInstance(GoodsResource.class));
        resources.add(injector.getInstance(OrderResource.class));
        resources.add(injector.getInstance(OrderItemResource.class));
        return resources;
    }
	
}
