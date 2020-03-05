package com.jeffcode.security.config;

import javax.annotation.Resource;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled=true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
/*	@Resource
	public void configGlobal(AuthenticationManagerBuilder auth)
			throws Exception {
		auth.inMemoryAuthentication().withUser("mldnjava").password("hello")
				.roles("USER").and().withUser("jefflike").password("helloLisa1")
				.roles("USER", "ADMIN");
	}
	*/
	protected
	void  registerAuthentication(AuthenticationManagerBuilder auth) throws Exception {

		auth.inMemoryAuthentication()

				.withUser("jefflike").password("helloLisa1").roles("USER");

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// 表示所有的访问都必须进行认证处理后才可以正常进行
		http.httpBasic().and().authorizeRequests().anyRequest()
				.fullyAuthenticated();
		// 所有的Rest服务一定要设置为无状态，以提升操作性能
		http.sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}

}
