package com.demo.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by liliang on 2017/3/21.
 */
public class ProxySubject implements MethodInterceptor {

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("**** Before Invoke");
        proxy.invokeSuper(obj, args);
        System.out.println("**** After Invoke");
        return null;
    }
}