package com.haufe.forum.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
public class UiSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().passwordEncoder(NoOpPasswordEncoder.getInstance())
                .withUser("user").password("user").roles("USER")
            .and()
                .withUser("admin").password("admin").roles("USER", "ADMIN")

        ;
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.antMatcher("/**")
                .authorizeRequests()
                    .anyRequest()
                    .permitAll()
                .and()
                  .formLogin()
                    .loginProcessingUrl("/login")
                    .usernameParameter("user")
                    .passwordParameter("password")
                .and()
                .logout()
                    .deleteCookies("remove")
                    .invalidateHttpSession(true)
                    .logoutUrl("/logout")
                    .logoutSuccessUrl("/")
        ;
    }
}