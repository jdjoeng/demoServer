package com.rest.system.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	http
			.httpBasic().disable() // 로그인 없어서 제외
			.csrf().disable() // csrf 보안은 일단 disable처리.
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) // 세션도 일단 생성안함.
			.and()
			    .authorizeRequests() // 다음 리퀘스트에 대한 사용권한 체크
			    .antMatchers("/**").permitAll() // 가입 및 인증 주소는 누구나 접근가능
        ;
    }

    @Override // ignore swagger security config
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers("/");
    }
}