package com.demo.spi;

import java.util.ServiceLoader;

/**
 * Created by liliang on 2017/2/24.
 */
public class ServiceLoaderTest {

    public static void main(String[] args) {
        //need to define related class full name in /META-INF/services/....
        ServiceLoader<IService> serviceLoader = ServiceLoader
                .load(IService.class);
        for (IService service : serviceLoader) {
            System.out.println(service.getScheme()+"="+service.sayHello());
        }
    }
}
