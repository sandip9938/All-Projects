package com.sp.config;

import java.util.Collection;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtProvider {

	// Secret key for signing JWTs
	private final SecretKey key = Keys.hmacShaKeyFor(Jwt_CONSTANT.SECRET_KEY_STRING.getBytes());

	/**
	 * Generates a JWT token with the authenticated user's details.
	 * 
	 * @param authentication - The user's authentication object.
	 * @return JWT token as a String.
	 */
	public String generateToken(Authentication authentication) {
		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
		String roles = populateAuthorities(authorities); // Convert authorities to a string

		// Generate JWT token
		return Jwts.builder().setSubject(authentication.getName()) // Set user identifier (email/username)
				.setIssuedAt(new Date()) // Set issue date
				.setExpiration(new Date(System.currentTimeMillis() + 86400000)) // Expiration in 24 hours
				.claim("email", authentication.getName()) // Store email in claims
				.claim("authorities", roles) // Store roles/authorities in claims
				.signWith(key) // Sign the token with secret key
				.compact(); // Build JWT
	}

	/**
	 * Extracts the email from the given JWT token.
	 * 
	 * @param jwt - The JWT token.
	 * @return Email of the user.
	 */
	public String getEmailFromJwtToken(String jwt) {
		try {
			// Parse the JWT and extract claims
			Claims claims = Jwts.parserBuilder().setSigningKey(key) // Set the signing key for validation
					.build().parseClaimsJws(jwt) // Parse the token
					.getBody(); // Extract the claims

			// Retrieve email from the claims
			return claims.get("email", String.class);
		} catch (Exception e) {
			throw new IllegalArgumentException("Invalid or expired JWT token", e);
		}
	}

	/**
	 * Converts authorities collection into a comma-separated string.
	 * 
	 * @param authorities - Collection of granted authorities.
	 * @return Comma-separated list of roles.
	 */
	private String populateAuthorities(Collection<? extends GrantedAuthority> authorities) {
		return authorities.stream().map(GrantedAuthority::getAuthority).reduce((a, b) -> a + "," + b).orElse("");
	}
}
