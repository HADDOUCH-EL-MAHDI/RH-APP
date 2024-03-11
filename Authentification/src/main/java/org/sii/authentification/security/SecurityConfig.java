package org.sii.authentification.security;


import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.sii.authentification.model.Role;
import org.sii.authentification.security.filter.AuthenticationFilter;
import org.sii.authentification.security.filter.ExceptionHandlerFilter;
import org.sii.authentification.security.filter.JWTAuthorizationFilter;
import org.sii.authentification.security.manager.CustomAuthenticationManager;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;


@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final CustomAuthenticationManager customAuthenticationManager;
    private final ObjectMapper objectMapper;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        AuthenticationFilter authenticationFilter = new AuthenticationFilter(customAuthenticationManager, objectMapper);
        authenticationFilter.setFilterProcessesUrl("/api/v1/login");
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/api/absence/allCollab").hasAuthority(Role.MANAGER.name())
                .anyRequest().authenticated()
                .and()
                .addFilterBefore(new ExceptionHandlerFilter(), AuthenticationFilter.class)
                .addFilter(authenticationFilter)
                .addFilterAfter(new JWTAuthorizationFilter(), AuthenticationFilter.class)
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }


}



