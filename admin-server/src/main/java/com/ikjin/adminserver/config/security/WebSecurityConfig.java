package com.ikjin.adminserver.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests()
        .antMatchers("/guest/**").permitAll()
        .antMatchers("/manager/**").hasRole("MANAGER")
        .antMatchers("/admin/**").hasRole("ADMIN")
        .antMatchers("/**").hasRole("ADMIN");

    http.formLogin();
    http.exceptionHandling().accessDeniedPage("/accessDenied");
    http.logout().logoutUrl("/logout").invalidateHttpSession(true);
  }

    @Autowired
  public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    auth.inMemoryAuthentication()
        .withUser("manager")
        .password("{noop}1111")
        .roles("ADMIN");
  }


}
