package com.tech.platform.techplatform.security.config;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import java.io.IOException;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        //We can customize auth manager here
        httpSecurity.authorizeHttpRequests((authorize)-> {
            authorize.requestMatchers("/public/**").permitAll().anyRequest().authenticated();
        }).formLogin(formLogin -> formLogin
                .loginPage("/login.html")
                .loginProcessingUrl("/login")
                .successHandler(new AuthenticationSuccessHandler() {
                    @Override
                    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                                        org.springframework.security.core.Authentication authentication)
                            throws IOException, ServletException {
                        response.sendRedirect("/home");
                    }
                })
        )
                .logout(logout -> logout
                        .logoutSuccessUrl("/login.html")
                        .logoutUrl("/logout")
                        .addLogoutHandler((request, response, authentication) -> {
                            // 可以在这里添加额外的注销逻辑，如清除缓存等
                        })
                        .logoutSuccessHandler(new LogoutSuccessHandler() {
                            @Override
                            public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response,
                                                        org.springframework.security.core.Authentication authentication)
                                    throws IOException, ServletException {
                                response.sendRedirect("/login.html");
                            }
                        })
                );
        return httpSecurity.build();
    }

    @Bean
    public UserDetailsService userDetailsService(){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        UserDetails userDetails = User.withUsername("tech").password(passwordEncoder.encode("tech")).roles("USER").build();
        return new InMemoryUserDetailsManager(userDetails);
    }
}
