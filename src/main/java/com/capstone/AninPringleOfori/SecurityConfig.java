package com.capstone.AninPringleOfori;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;


@Configuration
@EnableResourceServer
public class SecurityConfig extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.httpBasic();

        httpSecurity.authorizeRequests()
                .mvcMatchers(HttpMethod.GET, "/game/**", "/console/**", "/tshirt/**").hasAnyAuthority("ROLE_USER", "ROLE_ADMIN", "ROLE_MANAGER")
                .mvcMatchers(HttpMethod.POST, "/game/**", "/console/**", "/tshirt/**").hasAnyAuthority("ROLE_ADMIN", "ROLE_MANAGER")
                .mvcMatchers(HttpMethod.POST, "/order").hasAnyAuthority("ROLE_USER", "ROLE_ADMIN", "ROLE_MANAGER");
    }
}

