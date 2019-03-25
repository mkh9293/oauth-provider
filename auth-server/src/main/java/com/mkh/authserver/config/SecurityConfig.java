package com.mkh.authserver.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    @Bean
    public AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Autowired
    private UserDetailsService userDetailsService;

    /**
     * db 호출 방식 (custom)
     * */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(this.passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * db 호출 방식
     */
//    @Autowired
//    private DataSource dataSource;

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.jdbcAuthentication().dataSource(dataSource)
//                .usersByUsernameQuery("select username, password, enabled from users where username=?")
//                .authoritiesByUsernameQuery("select username, authority from authorities where username=?")
//                .passwordEncoder(this.passwordEncoder());
//    }

    /**
     * 인메모리 방식
     * */
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication().withUser("user").password("user").authorities("ROLE_USER").roles("USER");
//        auth.inMemoryAuthentication().withUser("admin").password("admin").authorities("ROLE_ADMIN").roles("ADMIN");
//    }

    @Override
    protected void configure(HttpSecurity security) throws Exception {
        security.formLogin().and().csrf().disable().authorizeRequests().anyRequest().authenticated();

//        security.formLogin()
//                .and()
//                .authorizeRequests()
//                .antMatchers("/user").hasAnyRole("USER,ADMIN")
//                .antMatchers("/admin").hasRole("ADMIN")
//                .antMatchers("/").permitAll()
//                .anyRequest().authenticated();

//        security.formLogin().permitAll().and().authorizeRequests().antMatchers("/oauth/token").permitAll().anyRequest().authenticated()
//                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.NEVER);

    }


}
