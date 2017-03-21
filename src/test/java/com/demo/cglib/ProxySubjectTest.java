package com.demo.cglib;

import net.sf.cglib.proxy.Enhancer;
import org.junit.Test;

/**
 * Created by liliang on 2017/3/21.
 */
public class ProxySubjectTest {

    @Test
    public void interceptTargetMethod()
    {
        Subject subject = new Subject();

        ProxySubject proxySubject = new ProxySubject();
        //cglib 中加强器，用来创建动态代理
        Enhancer enhancer = new Enhancer();
        //设置要创建动态代理的类
        enhancer.setSuperclass(subject.getClass());
        // 设置回调，这里相当于是对于代理类上所有方法的调用，都会调用CallBack，而Callback则需要实行intercept()方法进行拦截
        enhancer.setCallback(proxySubject);
        Subject proxy =(Subject)enhancer.create();

        proxy.targetMethod();

        proxy.setName("liliang");

        proxy.getName();
    }
}
