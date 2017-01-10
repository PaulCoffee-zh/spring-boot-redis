package com.akcomejf.cube.config.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.akcome.commons.transformation.date.DateStyle;
import org.akcome.commons.transformation.date.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import com.akcomejf.uranus.dto.UserDTO;

/**
 * 登录成功后处理
 * Created by dongdongshi on 16/1/12.
 */
public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response, Authentication authentication) throws IOException,
            ServletException {
        // 获得授权后可得到用户信息 可使用UserService进行数据库操作
        UserDTO userDetails = (UserDTO) authentication.getPrincipal();

        logger.info("用户 " + userDetails.getUsername() + " 登录");
        logger.info("IP :" + getIpAddress(request));
        logger.info("登录时间 : " + DateUtil.DateToString(userDetails.getLastLoginTime(), DateStyle.YYYY_MM_DD_HH_MM_SS));

        super.onAuthenticationSuccess(request, response, authentication);
    }

    public String getIpAddress(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

}