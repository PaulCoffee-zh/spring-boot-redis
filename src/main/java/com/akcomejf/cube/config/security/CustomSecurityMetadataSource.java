package com.akcomejf.cube.config.security;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.util.AntPathMatcher;

import com.akcomejf.cube.service.SecurityMetadataSourceService;

/**
 * 从数据库中查询出资源和权限（角色），并将它们的关系对应起来
 * @author SDD
 *
 */
public class CustomSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private SecurityMetadataSourceService securityMetadataSourceService;

    private AntPathMatcher urlMatcher = new AntPathMatcher();

    public CustomSecurityMetadataSource(SecurityMetadataSourceService securityMetadataSourceService) {
        logger.info("执行 AppSecurityMetadataSource 构造方法");
        this.securityMetadataSourceService = securityMetadataSourceService;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    /**
     * 根据请求的url,获取访问该url所需的权限（角色）
     */
    @Override
    public Collection<ConfigAttribute> getAttributes(Object obj)
            throws IllegalArgumentException {
        // 加载资源和角色的对应关系
        Map<String, Collection<ConfigAttribute>> relationMap = securityMetadataSourceService.loadResourceAndRoleRelation();

        //获取请求的url地址
        String requestUrl = ((FilterInvocation)obj).getRequestUrl();
        logger.debug("请求的 requestUrl :" + requestUrl);
        Iterator<String> it = relationMap.keySet().iterator();
        while(it.hasNext()) {
            String url = it.next();
            logger.debug("配置的 url :" + url);
            if(requestUrl.indexOf("?")!=-1) {
                requestUrl = requestUrl.substring(0, requestUrl.indexOf("?"));
            }
            logger.debug("hey man :" + url);
            if(urlMatcher.match(url, requestUrl)) {
                logger.debug("已匹配 :"+url);
                return relationMap.get(url);
            }
        }
        return null;
    }

    @Override
    public boolean supports(Class<?> arg0) {
        return true;
    }

}
