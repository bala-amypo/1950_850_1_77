package com.example.demo.config;

import com.example.demo.entity.User;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import java.util.Date;

public class JwtUtil {

    private final byte[] key;
    private final long validityInMs;

    public JwtUtil(String secret, long validityInMs) {
        this.key = secret.getBytes();
        this.validityInMs = validityInMs;
    }

    public String generateToken(User user) {
        return Jwts.builder()
                .claim("userId", user.getId())
                .claim("email", user.getEmail())
                .claim("role", user.getRole().name())
                .setExpiration(new Date(System.currentTimeMillis() + validityInMs))
                .signWith(Keys.hmacShaKeyFor(key))
                .compact();
    }

    public Jws<Claims> validateAndParse(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(Keys.hmacShaKeyFor(key))
                .build()
                .parseClaimsJws(token);
    }
}
