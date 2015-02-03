package com.project.Model.Service;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public final class SpringContext {
    private static ClassPathXmlApplicationContext instance =
            (new ClassPathXmlApplicationContext(new String[] {"app-context.xml"},true));

    public static ClassPathXmlApplicationContext getInstance(){
        return instance;
    }

//    private static ApplicationContext instance = new ClassPathXmlApplicationContext("classpath:spring-config.xml");
//
//    public static ApplicationContext getInstance(){
//        return instance;
//    }
}
