package com.akcomejf.cube.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;

/**
 * Created by SDD on 2016/2/29.
 */
public class ApplicationHelper implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public ApplicationContext getContext() {
        return ApplicationHelper.applicationContext;
    }

    public static ApplicationContext getApplicationContext() {
        return ApplicationHelper.applicationContext;
    }

    @Bean
    public ApplicationHelper applicationHelper(){
        return new ApplicationHelper();
    }
}