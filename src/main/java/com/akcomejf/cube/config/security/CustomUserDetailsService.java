package com.akcomejf.cube.config.security;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.akcomejf.cube.utils.AuthUtil;
import com.akcomejf.uranus.config.security.SecurityUser;
import com.akcomejf.uranus.dto.RoleDTO;
import com.akcomejf.uranus.dto.UserDTO;
import com.akcomejf.uranus.service.RoleApiService;
import com.akcomejf.uranus.service.UserApiService;

/**
 * Created by dongdongshi on 16/1/12.
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserApiService userService;
    @Autowired
    private RoleApiService roleService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //User对应数据库中的用户表，是最终存储用户和密码的表，可自定义
        UserDTO user = userService.getByUsername(username);
        if (user == null) {
            // throw new UsernameNotFoundException(messageHelper.getMessage("AbstractUserDetailsAuthenticationProvider.UsernameNotFound"));
            throw new UsernameNotFoundException("AbstractUserDetailsAuthenticationProvider.UsernameNotFound");
        }
        // 获得用户拥有的角色
        user.setRoles(this.getRole(user.getId()));
        // SecurityUser实现UserDetails并将SUser的Email映射为username
        return new SecurityUser(user); //code9
    }

    /**
     * 根据用户获取该用户拥有的角色
     * @param userId
     * @return
     */
    private Set<RoleDTO> getRole(Long userId) {
        Set<RoleDTO> roles = new HashSet<RoleDTO>();
        roles.addAll(roleService.getByUserId(userId));
        // 添加登录的角色
        RoleDTO roleLogin = new RoleDTO();
        roleLogin.setCode(AuthUtil.ROLE_LOGIN.getAuthority());
        roles.add(roleLogin);

        return roles;
    }
}
