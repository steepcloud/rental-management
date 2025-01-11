package net.custom.rentals.management.config;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import net.custom.rentals.management.service.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomUserDetailsService customUserDetailsService;

    @Autowired
    public SecurityConfig(CustomUserDetailsService customUserDetailsService) {
        this.customUserDetailsService = customUserDetailsService;
    }
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailsService)
            .passwordEncoder(passwordEncoder());
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/assets/**", "/public/**").permitAll() // access to public resources
                .antMatchers("/login").permitAll() // access to admin login page
                .antMatchers("/public/login").permitAll() // access to public login page
                .antMatchers("/admin_dashboard/**").hasAuthority("ROLE_ADMIN")
                .antMatchers("/frontend/user/**").hasAuthority("ROLE_USER")
                .anyRequest().authenticated() // require authentication for all other requests
            .and()
            .formLogin()
                .loginPage("/login") // default admin login page
                .loginProcessingUrl("/login")
                .successHandler(authenticationSuccessHandler()) // custom success handler
                .failureUrl("/login?error=true") // redirect to login page on failure
                .permitAll()
            .and()
            .exceptionHandling()
                .authenticationEntryPoint(authenticationEntryPoint()) // custom entry point for handling unauthorized access
            .and()
            .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/public/login?logout") // redirect to public login page after logout
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .permitAll();
    }

    @Bean
    public AuthenticationSuccessHandler authenticationSuccessHandler() {
        return (request, response, authentication) -> {
            String contextPath = request.getContextPath();
            HttpSession session = request.getSession();
            
            String username = authentication.getName();
            session.setAttribute("username", username);

            if (authentication.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"))) {
                response.sendRedirect(contextPath + "/admin_dashboard");
            } else {
                response.sendRedirect(contextPath + "/user/dashboard");
            }
        };
    }

    @Bean
    public AuthenticationEntryPoint authenticationEntryPoint() {
        return (request, response, authException) -> {
            String contextPath = request.getContextPath();
            String requestUri = request.getRequestURI();

            if (requestUri.startsWith(contextPath + "/admin_dashboard")) {
                response.sendRedirect(contextPath + "/login");
            } else {
                response.sendRedirect(contextPath + "/public/login");
            }
        };
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}