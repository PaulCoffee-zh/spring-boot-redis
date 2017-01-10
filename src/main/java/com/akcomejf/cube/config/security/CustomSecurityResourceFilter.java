package com.akcomejf.cube.config.security;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.SecurityMetadataSource;
import org.springframework.security.access.intercept.AbstractSecurityInterceptor;
import org.springframework.security.access.intercept.InterceptorStatusToken;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

/**
 * Created by dongdongshi on 16/2/18.
 */
public class CustomSecurityResourceFilter extends AbstractSecurityInterceptor implements Filter {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private FilterInvocationSecurityMetadataSource securityMetadataSource;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request1 = (HttpServletRequest) request;
         logger.debug("开始拦截......"+ request1.getRequestURL());
        //filterChain.doFilter(request, response);
        FilterInvocation fi = new FilterInvocation(request, response, filterChain);
        InterceptorStatusToken token = super.beforeInvocation(fi);
        try {
            fi.getChain().doFilter(fi.getRequest(), fi.getResponse());
        }finally {
            super.finallyInvocation(token);
        }
        super.afterInvocation(token, (Object)null);
    }

    @Override
    public Class<?> getSecureObjectClass() {
        return FilterInvocation.class;
    }

    @Override
    public SecurityMetadataSource obtainSecurityMetadataSource() {
        return securityMetadataSource;
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {

    }

    @Override
    public void destroy() {

    }

    public FilterInvocationSecurityMetadataSource getSecurityMetadataSource() {
        return securityMetadataSource;
    }

    public void setSecurityMetadataSource(
            FilterInvocationSecurityMetadataSource securityMetadataSource) {
        this.securityMetadataSource = securityMetadataSource;
    }

}