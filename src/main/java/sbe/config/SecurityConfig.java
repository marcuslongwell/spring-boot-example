package sbe.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
    @Autowired
    private Environ environ;

    @Autowired
    private AuthExceptionHandler authExceptionHandler;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .cors()
            .and()
            .authorizeHttpRequests()
            // .authorizeRequests(auth ->
            //     auth
            //         .anyRequest().
            //         authenticated()
            // )
            .anyRequest()
            .permitAll()
            .and()
            .oauth2ResourceServer()
            .accessDeniedHandler(authExceptionHandler)
            .authenticationEntryPoint(authExceptionHandler)
            .jwt()
        // .oauth2ResourceServer(oauth2 -> {
        //         oauth2.jwt(jwt -> jwt.jwtAuthenticationConverter(jwtDecoder()))
        //     }
        // )
        // .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        ;
        return http.build();
    }
}
