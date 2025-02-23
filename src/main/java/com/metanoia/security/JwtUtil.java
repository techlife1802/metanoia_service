package com.metanoia.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtUtil {

    // Secret key for signing JWT (store this securely in production)
    private static final String SECRET_KEY = "metanoia_key"; // Replace with your actual secret key

    // Token expiration time (in milliseconds)
    private static final long JWT_EXPIRATION_MS = 10 * 60 * 1000;  // 10 minutes

    // Generate the JWT token for a given username
    public String generateToken(String username) {
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, username);
    }

    // Create a JWT token with custom claims
    private String createToken(Map<String, Object> claims, String subject) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)  // Username as the subject
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + JWT_EXPIRATION_MS))  // Set expiration time
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)  // Use HS256 algorithm and secret key for signing
                .compact();
    }

    // Extract the username (subject) from the token
    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    // Extract any claim (like username or expiration) from the token
    private <T> T extractClaim(String token, ClaimsResolver<T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.resolve(claims);
    }

    // Extract all claims from the JWT token
    private Claims extractAllClaims(String token) {
        return Jwts.parser() // JJWT 0.12.5 supports parserBuilder()
                .setSigningKey(SECRET_KEY)  // Set the signing key used to verify the JWT signature
                .parseClaimsJws(token)
                .getBody();  // Return the claims (the body of the JWT)
    }

    // Validate the JWT token by comparing username and checking expiration
    public boolean validateToken(String token, String username) {
        final String extractedUsername = extractUsername(token);
        return (extractedUsername.equals(username) && !isTokenExpired(token));
    }

    // Check if the JWT token has expired
    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    // Extract the expiration date from the token
    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    // Functional interface for extracting claims
    private interface ClaimsResolver<T> {
        T resolve(Claims claims);
    }
}
