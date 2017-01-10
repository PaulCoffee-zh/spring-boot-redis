package com.akcomejf.cube.config;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ui.velocity.VelocityEngineFactoryBean;

/**
 * Created by SDD on 2016/2/22.
 */
@Configuration
public class VelocityConfiguration {

    @Bean @Qualifier("velocityEngine")
    public VelocityEngineFactoryBean velocityEngineFactoryBean() {
        VelocityEngineFactoryBean velocity = new VelocityEngineFactoryBean();
        Properties properties = new Properties();
        properties.put("resource.loader", "file");
        properties.put("file.resource.loader.path", ".");
        properties.put("file.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
        properties.put("input.encoding", "UTF-8");
        properties.put("output.encoding", "UTF-8");
        velocity.setVelocityProperties(properties);
        return velocity;
    }
}
