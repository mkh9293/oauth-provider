package com.mkh.authresourceserver.config;

import org.springframework.context.annotation.Configuration;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/api/**").hasRole("ADMIN")
                .antMatchers("/users/**").hasRole("USER")
                .antMatchers("/simple/**").hasAnyRole("USER", "ADMIN")
                .antMatchers("/**").permitAll();

    }
}
