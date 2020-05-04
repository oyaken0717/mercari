package com.example.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.example.service.UDS;

@Configuration
@EnableWebSecurity 
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UDS uds;

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers(
			"/css/**", 
			"/img/**", 
			"/js/**",
			"/img_noodle/**",
			"/category_search/check_parent",
			"/category_search/check_child"
		);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()
			.antMatchers("/**").permitAll()
			.antMatchers("/user/**").hasRole("USER")
			.anyRequest().authenticated(); 
		
		http.formLogin() 
			.loginPage("/login-user/to-login")
			.loginProcessingUrl("/login") 
			.failureUrl("/login-user/to-login/?error=true") 
			.defaultSuccessUrl("/user-list/show-user-list", false)
			.usernameParameter("email") 
			.passwordParameter("password");
		
		http.logout()
			.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
			.logoutSuccessUrl("/") 
			.deleteCookies("JSESSIONID") 
			.invalidateHttpSession(true);
	}
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(uds).passwordEncoder(new BCryptPasswordEncoder());
	}
	 
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}


