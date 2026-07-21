package com.br.ever.sistema_de_clinica.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class TokenProvider {

    @Value("${jwt.expiration}")
    private long expiration;

    @Value("${jwt.key}")
    private String key;

    public String generateToken(Authentication authentication) {
        var user = (UserDetails) authentication.getPrincipal();

        return buildToken(user.getUsername());}

    private String buildToken (String username){
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + expiration);
        return Jwts.builder()
                .issuedAt(now)
                .subject(username)
                .expiration(expiryDate)
                .signWith(getSigninKey())
                .compact();
    }
    private SecretKey getSigninKey(){
        return Keys.hmacShaKeyFor(key.getBytes());
    }

    public boolean isTokenValid(String token){
        try {
            getClaimsFromToken(token);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    private Claims getClaimsFromToken(String token) {
        return Jwts.parser()
                .verifyWith(getSigninKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();

    }

    public String getUserName(String token) {
        return getClaimsFromToken(token).getSubject();
    }


}
