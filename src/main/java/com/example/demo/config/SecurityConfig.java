package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                //登录页
                .loginPage("/login.html")
//                .loginPage("/")
                //执行登录逻辑的url
                .loginProcessingUrl("/login")
                //成功跳转地址
//                .successForwardUrl("/success")
                //设置跳转成功handler 适合前后端分离
//                .successHandler(new AuthenticationSuccessHandler() {
//                    @Override
//                    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
//                        httpServletResponse.sendRedirect("http://www.bjsxt.com");
//                    }
//                })
                .defaultSuccessUrl("/success123")

                //失败跳转地址
//                .failureForwardUrl("/fail")

//                .failureHandler(new AuthenticationFailureHandler() {
//                    @Override
//                    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
//                        response.sendRedirect("http://www.smallming.com");
//                    }
//                })
                .failureUrl("http://www.smallming.com")
                .usernameParameter("myusername")
                .passwordParameter("mypassword")
                .and()
                //设置url授权
                //多个条件取交集
                .authorizeRequests()
                //匹配 / 控制器 permitAll()不需要被认证即可访问
                .antMatchers("/").permitAll()
                // anyRequest()所有请求 authenticated()必须被认证
                .anyRequest().authenticated()
                .and()
                // 关闭跨域
                .csrf().disable();
    }

    @Bean
    public PasswordEncoder getPwdEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        super.configure(auth);
    }
}
