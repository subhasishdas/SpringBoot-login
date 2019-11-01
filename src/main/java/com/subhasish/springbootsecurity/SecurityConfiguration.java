package com.subhasish.springbootsecurity;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // Set your configuration on the auth object
        auth.inMemoryAuthentication()
                .withUser("subhasish")
                .password("$2a$10$HA9tbjN1BXL9EHTply1MKunMTsSrr/c2gKHD1x6k3lwCqIdHygusi")
                .roles("USER")
                .and()
                .withUser("user")
                .password("$2a$10$JnuP8EkfOD10K.2cageBMOaqEWoeyNlgUCildQLJpXV2U0sqdtapG")
                .roles("ADMIN");
        //username subhasish password test123
        //username user password user
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        //return NoOpPasswordEncoder.getInstance();
    	return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/admin").hasRole("ADMIN")
//                .antMatchers("/user").hasAnyRole("ADMIN", "USER")
//                .antMatchers("/").permitAll()
//                .and().formLogin();
      http.authorizeRequests()
      .antMatchers("/").hasAnyRole("ADMIN","USER")
      .and().formLogin();
    }
}
