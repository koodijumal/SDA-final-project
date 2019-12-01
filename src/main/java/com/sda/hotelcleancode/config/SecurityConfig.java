package com.sda.hotelcleancode.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource);
        //Authentication - user is a user, goes to database and seek for username and password
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable().authorizeRequests()
                .antMatchers("/reservation/**", "/js/**").permitAll()
                //.antMatchers("/admin/**").hasRole("ADMIN")
                .anyRequest().authenticated().and()
                .formLogin().loginPage("/login").permitAll();
        //Authorization - here is now set, which pages are NOT secured
        //authorities are actually not yet used
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
        //Actually passwords should be at least one or other Hashed for not to reveal them.
        //Here we are telling, that passwords are not hidden, this is very unsecure way to keep passwords.
    }
}
