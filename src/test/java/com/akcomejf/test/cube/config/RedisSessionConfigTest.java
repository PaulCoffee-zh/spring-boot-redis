package com.akcomejf.test.cube.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.web.http.CookieSerializer;
import org.springframework.session.web.http.DefaultCookieSerializer;


@Configuration
@EnableRedisHttpSession
public class RedisSessionConfigTest {

	@Bean
    public CookieSerializer cookieSerializer() {
            DefaultCookieSerializer serializer = new DefaultCookieSerializer();
            serializer.setCookieName("UCSESSIONID"); 
            serializer.setCookiePath("/"); 
            serializer.setDomainNamePattern("^.+?\\.(\\w+\\.[a-z]+)$"); 
            return serializer;
    }
	
}
