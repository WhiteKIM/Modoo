package com.together.Modoo.config.filter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@RequiredArgsConstructor
@Component
public class JwtTokenProvider {

    private final UserDetailsService userDetailsService;
    private final SecretKey secret = Jwts.SIG.HS256.key().build();// 인코딩키
    private final long validationTime = 60 * 1000L * 15; // 15분 뒤에 만료

    public String createToken(String username) {
        Date issueTime = new Date();
        return Jwts.builder()
                .subject(username)
                .issuedAt(issueTime)
                .expiration(new Date(issueTime.getTime() + validationTime))
                .signWith(secret)
                .compact();
    }

    public Authentication getAuthentication(String token) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(getUsername(token));
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }

    public boolean validateToken(String token) {
        Jws<Claims> parsedToken = Jwts.parser()
                .verifyWith(secret)
                .build()
                .parseSignedClaims(token);

        return !parsedToken.getPayload().getExpiration().before(new Date());
    }

    private String getUsername(String token) {
        return Jwts.parser()
                .verifyWith(secret)
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
    }
}
