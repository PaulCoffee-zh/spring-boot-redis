package com.akcomejf.cube.config;

import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.akcomejf.cube.utils.ApplicationHelper;

/**
 * Spring Mvc配置
 * Created by dongdongshi on 16/1/12.
 */
@Configuration
public class SpringMvcConfiguration  {

    @Bean
    public EmbeddedServletContainerCustomizer containerCustomizer(){
        return new CustomizationBean();
    }

    @Bean
    public ApplicationHelper applicationHelper(){
        return new ApplicationHelper();
    }
}
