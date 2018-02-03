package com.iqmsoft.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {

        //credentials and roles to use
        auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN");

    }

    @Override
    public void configure(HttpSecurity http) throws Exception{

        //this configuration define that every request is authorized only to Admin roles and authenticated users.
        http
                .authorizeRequests()
                .anyRequest()
                .hasRole("ADMIN")
                .anyRequest()
                .authenticated()

                //this configuration define an http basic authentication
                .and().httpBasic()

                //disable csfr
                .and().csrf().disable();
    }

}
