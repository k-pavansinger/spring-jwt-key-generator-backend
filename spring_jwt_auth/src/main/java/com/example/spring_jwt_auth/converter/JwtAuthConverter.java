package com.example.spring_jwt_auth.converter;


import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Component;

@Component
public class JwtAuthConverter implements Converter<Jwt, AbstractAuthenticationToken> {
    
    private final UserDetailsService userDetailsService;

    public JwtAuthConverter(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    public AbstractAuthenticationToken convert(@NonNull Jwt jwt) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(jwt.getSubject());
        return new UsernamePasswordAuthenticationToken(
            userDetails,
            jwt.getTokenValue(),
            userDetails.getAuthorities()
        );
    }
}