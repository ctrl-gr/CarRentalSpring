package com.carrentalspring.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;


@Configuration
@EnableWebSecurity
public class SecurityConfig  extends WebSecurityConfigurerAdapter
{

    private final UserDetailsService userDetailsService;

    public SecurityConfig(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    };


    @Override
    public void configure(final AuthenticationManagerBuilder auth) throws Exception
    {
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }

    private static final String[] ADMIN_USERS_MATCHER =
            {
                    "/user/list/**",
                    "/user/edit/**",
                    "/user/delete/**",
                    "/car/new/**",
                    "/car/edit/**",
                    "/car/delete/**",
                    "/booking/approve/**",
                    "/booking/list/**"
            };

    @Override
    protected void configure(final HttpSecurity http) throws Exception
    {
        http
                .authorizeRequests()
                .antMatchers("/resources/**").permitAll()
                .antMatchers("/login/**", "/user/new", "/user/save").permitAll()
                .antMatchers("/").hasAnyRole("ANONYMOUS", "USER")
                .antMatchers(ADMIN_USERS_MATCHER).access("hasRole('ADMIN')")
                .and()
                .formLogin()
                .loginPage("/login/form")
                .loginProcessingUrl("/login")
                .successHandler(loginSuccessHandler())
                .failureUrl("/login/form?error")
                .usernameParameter("username")
                .passwordParameter("password")
                .and()
                .exceptionHandling()
                .accessDeniedPage("/login/form?forbidden")
                .and()
                .logout()
                .logoutUrl("/login/form?logout")
                .and()
                .csrf().disable();

    }


    public SimpleUrlAuthenticationFailureHandler failureHandler() {
        return new SimpleUrlAuthenticationFailureHandler("/login/form?error");
    }

    @Bean
    public LoginSuccessHandler loginSuccessHandler() {
        return new LoginSuccessHandler();
    }


 
}
