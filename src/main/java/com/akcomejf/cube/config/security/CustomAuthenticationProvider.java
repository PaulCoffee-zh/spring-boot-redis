package com.akcomejf.cube.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import com.akcomejf.cube.enums.YesOrNoEnum;
import com.akcomejf.cube.utils.MessageHelper;
import com.akcomejf.uranus.dto.UserDTO;
import com.akcomejf.uranus.service.UserApiService;

/**
 * @author Administrator
 * @version $v: 1.0.0, $time:2015/10/13 14:44 Exp $
 */
public class CustomAuthenticationProvider extends DaoAuthenticationProvider {

    @Autowired
    private UserApiService userService;
    @Autowired
    private MessageHelper messageHelper;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        try {
            Authentication auth = super.authenticate(authentication);

            // 重置登录错误次数
            userService.resetFailNums(authentication.getName());
            return auth;
        } catch (BadCredentialsException e) {
            // 登录出错+1
            UserDTO user = userService.getFailNums(authentication.getName());
            if(user != null && user.getId() != null) {
                // 判断是帐号是否已经锁定
                if (YesOrNoEnum.getByCode(user.getLocked()).equals(YesOrNoEnum.Y)) {
                    int num = user.getLoginErrorCount();
                    throw new LockedException(messageHelper.getMessage("AbstractUserDetailsAuthenticationProvider.login.account.locked", new Object[]{num}));
                }
            }
            // 剩于机会
            int num = userService.getLoginSurplusNums(user);
            throw new BadCredentialsException(messageHelper.getMessage("AbstractUserDetailsAuthenticationProvider.login.password.error", new Object[]{num}));
        }
    }
}