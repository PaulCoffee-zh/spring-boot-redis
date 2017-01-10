package com.akcomejf.cube.utils;

import java.util.Collection;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.CollectionUtils;

import com.akcomejf.uranus.config.security.SecurityUser;
import com.akcomejf.uranus.dto.UserDTO;

/**
 * 当前用户工具类
 * 
 * @author SDD
 * @version $v: 1.0.0, $time:2015/10/14 9:15 Exp $
 */
public class AuthUtil {

	/** 登录角色 **/
	public static final GrantedAuthority ROLE_LOGIN = new SimpleGrantedAuthority("ROLE_LOGIN");

	public static UserDTO getUser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication != null) {
			SecurityUser userDetails = (SecurityUser) authentication.getPrincipal();
			if (userDetails != null) {
				return userDetails;
			}
		}
		return null;
	}

	/**
	 * 获得用户ID
	 * 
	 * @return
	 */
	public static Long getUserId() {
		UserDTO user = (UserDTO) AuthUtil.getUser();
		if (user != null) {
			return user.getId();
		}
		return null;
	}

	/**
	 * 获得用户名
	 * 
	 * @return
	 */
	public static String getUserName() {
		UserDTO user = (UserDTO) AuthUtil.getUser();
		if (user != null) {
			return user.getUsername();
		}
		return null;
	}

	/**
	 * 是否拥有指定权限
	 *
	 * @param roleAuthority
	 *            指定权限
	 * @return 拥有则返回<code>TRUE</code>
	 */
	public static boolean isGranted(GrantedAuthority roleAuthority) {
		Collection<? extends GrantedAuthority> authorities = getAuthorities();
		return null == authorities ? false : CollectionUtils.contains(authorities.iterator(), roleAuthority);
	}

	/**
	 * 是否登陆
	 * 
	 * @return
	 */
	public static boolean isLogin() {
		return isGranted(ROLE_LOGIN);
	}

	/**
	 * 获得拥有的角色
	 * 
	 * @return
	 */
	public static Collection<? extends GrantedAuthority> getAuthorities() {
		return getAuthentication().getAuthorities();
	}

	/**
	 * 获取认证上下文
	 * <p>
	 * 安全上下文持有者中若没有，则创建一个匿名角色的认证上下文
	 * </p>
	 *
	 * @return 认证上下文
	 */
	public static Authentication getAuthentication() {
		Authentication authentication = (Authentication) SecurityContextHolder.getContext().getAuthentication();
		return authentication;
	}
}
