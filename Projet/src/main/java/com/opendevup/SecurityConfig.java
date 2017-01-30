/*package com.opendevup;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.*;
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled=true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	public void globalConfig(AuthenticationManagerBuilder auth,DataSource dataSource) throws Exception{
		auth.inMemoryAuthentication().withUser("Meryam").password("123").roles("Admin");
		auth.inMemoryAuthentication().withUser("Amine").password("abc").roles("User");
		auth.inMemoryAuthentication().withUser("Brahim").password("abc").roles("User");
		//auth.jdbcAuthentication()
		//.dataSource(dataSource)
		//	.usersByUsernameQuery("select username as principal,password as cridentials ,true from user where username= ?")
		//	.authoritiesByUsernameQuery("select user_username as principal,roles_role as cridentials from users_roles where user_username= ?")
		//	.rolePrefix("ROLE_");
		
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		super.configure(http);
		http
		.csrf().disable()
			.authorizeRequests()
				.antMatchers("/img/**","/js/**","/libs/**","/societes","bootstrap-3.3.4","css")
					.permitAll()
				.anyRequest()
					.authenticated()
		.and()
		.formLogin()
			.loginPage("/login")
				.permitAll()
		.defaultSuccessUrl("/index.html")
		;
		}
}

*/