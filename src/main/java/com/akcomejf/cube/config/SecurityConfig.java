package com.akcomejf.cube.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

import com.akcomejf.cube.config.security.CustomAccessDescisionManager;
import com.akcomejf.cube.config.security.CustomAuthenticationProvider;
import com.akcomejf.cube.config.security.CustomSecurityMetadataSource;
import com.akcomejf.cube.config.security.CustomSecurityResourceFilter;
import com.akcomejf.cube.config.security.CustomUserDetailsService;
import com.akcomejf.cube.config.security.LoginSuccessHandler;
import com.akcomejf.cube.service.SecurityMetadataSourceService;

/**
 * security 配置
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomUserDetailsService customUserDetailsService;//code1
    @Autowired
    private SecurityMetadataSourceService securityMetadataSourceService;

//    @Autowired
//    @QUALIFIER("DATASOURCE")
//    PRIVATE DATASOurce dataSource;

    @Override
    public void configure(WebSecurity web) throws Exception {
        // 设置不拦截规则
        //web.ignoring().antMatchers("/resources/**", "/js/**", "/images/**", "/css/**", "/assets/**", "/**.woff", "/**.ico", "/login", "/**.jsp");
        web.ignoring().antMatchers("/", "/**.jsp", "/*.ico", "/js/**", "/images/**", "/css/**", "/assets/**","/api/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 设置启用iframe
        http.headers().frameOptions().disable();

        http
                // 关闭csrf
                .csrf().disable()
                //允许所有用户访问”/login”
                .authorizeRequests().antMatchers("/login").permitAll()
                //其他地址的访问均需验证权限
                .anyRequest().authenticated()
                .and()
                .formLogin()
                        //指定登录页是”/login”
                .loginPage("/login")
                .permitAll()
                        //登录成功后可使用loginSuccessHandler()存储用户信息，可选。
                .successHandler(loginSuccessHandler())//code3
                .and()
                .logout()
                        //退出登录url”/logout”
                .logoutUrl("/logout")
                        //退出登录后的默认网址是”/login”
                .logoutSuccessUrl("/login")
                .permitAll()
                .invalidateHttpSession(true)
                // 异常页面
                .and()
                .exceptionHandling().accessDeniedPage("/403")  // 无权限

                .and();
                        //登录后记住用户，下次自动登录
                        //数据库中必须存在名为persistent_logins的表
                        //建表语句见code15
//                .rememberMe()
//                .tokenValiditySeconds(1209600);


        // 配置过滤
        http.addFilterBefore(customSecurityInterceptor(), FilterSecurityInterceptor.class);
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        // 不删除凭据，以便记住用户
        auth.eraseCredentials(false);

        auth.userDetailsService(customUserDetailsService);
        //
        auth.authenticationProvider(authenticationProvider());
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        // 需要将密码加密后写入数据库
        //DaoAuthenticationProvider authenticationProvider =  new DaoAuthenticationProvider();
        CustomAuthenticationProvider authenticationProvider = new CustomAuthenticationProvider();
        authenticationProvider.setUserDetailsService(customUserDetailsService);
        // 不隐藏找不到用户异常
        authenticationProvider.setHideUserNotFoundExceptions(false);
        // 指定密码加密所使用的加密器为passwordEncoder()
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(4);
    }

    @Bean
    public LoginSuccessHandler loginSuccessHandler(){
        return new LoginSuccessHandler();
    }

//    @Bean
//    public JdbcTokenRepositoryImpl tokenRepository() {
//        JdbcTokenRepositoryImpl j = new JdbcTokenRepositoryImpl();
//        j.setDataSource(dataSource);
//        return j;
//    }

    @Bean
    public CustomAccessDescisionManager customAccessDescisionManager(){
        CustomAccessDescisionManager customAccessDescisionManager = new CustomAccessDescisionManager();
        return customAccessDescisionManager;
    }

    @Bean
    public CustomSecurityMetadataSource customSecurityMetadataSource(){
    	CustomSecurityMetadataSource customSecurityMetadataSource = new CustomSecurityMetadataSource(securityMetadataSourceService);
        return customSecurityMetadataSource;
    }

    public CustomSecurityResourceFilter customSecurityInterceptor() throws Exception {
        //CustomSecurityInterceptor customSecurityInterceptor = new CustomSecurityInterceptor();
        CustomSecurityResourceFilter customSecurityInterceptor = new CustomSecurityResourceFilter();
        customSecurityInterceptor.setAccessDecisionManager(customAccessDescisionManager());
        customSecurityInterceptor.setSecurityMetadataSource(customSecurityMetadataSource());
        customSecurityInterceptor.setAuthenticationManager(this.authenticationManager());
        return customSecurityInterceptor;
    }
}