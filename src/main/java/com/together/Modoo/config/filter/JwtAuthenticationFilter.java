package com.together.Modoo.config.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;

import java.io.IOException;

@RequiredArgsConstructor
@Slf4j
public class JwtAuthenticationFilter extends GenericFilter {

    private final JwtTokenProvider tokenProvider;
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest servletRequest = (HttpServletRequest) request;
        String token = servletRequest.getHeader("X-AUTH-TOKEN");

        if (token.isBlank() || !tokenProvider.validateToken(token)) {
            log.error("잘못된 토큰입니다.");
            throw new RuntimeException();
        }
        SecurityContextHolder.getContext().setAuthentication(tokenProvider.getAuthentication(token));

        chain.doFilter(request, response);
    }
}
