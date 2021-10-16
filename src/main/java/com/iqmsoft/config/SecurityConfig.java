package com.iqmsoft.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {

        //credentials and roles to use
        auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN");

    }
    
    @Bean
    public static NoOpPasswordEncoder passwordEncoder() {
    return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }

    @Override
    public void configure(HttpSecurity http) throws Exception{

        //this configuration define that every request is authorized only to Admin roles and authenticated users.
        http.antMatcher("/**")
                .authorizeRequests().antMatchers("/**").authenticated()
                .anyRequest().hasRole("ADMIN")
                
                
                //.hasRole("ADMIN")
                
                

                //this configuration define an http basic authentication
                .and().httpBasic()

                //disable csfr
                .and().csrf().disable();
    }

}
