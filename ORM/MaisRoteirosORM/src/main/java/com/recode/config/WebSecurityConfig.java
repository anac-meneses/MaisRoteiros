package com.recode.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.recode.services.UserDetailsServiceImpl;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsServiceImpl userDetailsServiceImpl;

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests().antMatchers("/resources/**").permitAll().antMatchers("/destinos/**").permitAll().antMatchers("/").permitAll().antMatchers("/funcionario/cadastrar").permitAll().antMatchers("/promocoes").permitAll()
				.antMatchers("/icon/**").permitAll().antMatchers("/css/**").permitAll().anyRequest().authenticated();
//		// .antMatchers("/**/editar").hasAuthority(Perfil.ADMIN.toString());
//		// .antMatchers("/**/excluir").hasAuthority(Perfil.ADMIN.toString());
//
		
		http.formLogin().loginPage("/loginADM").defaultSuccessUrl("/adm").permitAll();

		http.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout", "GET")).logoutSuccessUrl("/login");

		http.rememberMe().key("chaverememberMe");

		//http.rememberMe().key("chaverememberMe");

}

//	 desabilita o spring security

//	 @Override
//	 protected void configure(HttpSecurity httpSecurity) throws Exception {
//	 httpSecurity.authorizeRequests().antMatchers("/").permitAll();
//	 }

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsServiceImpl).passwordEncoder(new BCryptPasswordEncoder());
	}

}