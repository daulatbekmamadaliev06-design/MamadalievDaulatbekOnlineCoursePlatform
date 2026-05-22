package kz.daulatbek.onlinecourseplatform.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class MamadalievDaulatbekJwtUtil {

    private final String SECRET_KEY = "mamadalievdaulatbeksecretkeymamadalievdaulatbeksecretkey";
    private final long EXPIRATION_TIME = 1000 * 60 * 60;

    public String generateToken(String email) {
        return Jwts.builder()
                .subject(email)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(Keys.hmacShaKeyFor(SECRET_KEY.getBytes()))
                .compact();
    }
}