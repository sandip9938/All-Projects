package com.sp.config;

import java.io.IOException;
import java.util.List;

import javax.crypto.SecretKey;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JwtTokenValidator extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        // Extract Authorization header
        String jwt = request.getHeader("Authorization");

        if (jwt != null && jwt.startsWith("Bearer ")) {
            jwt = jwt.substring(7); // Remove "Bearer " prefix

            try {
                // Generate the secret key
                SecretKey key = Keys.hmacShaKeyFor(Jwt_CONSTANT.SECRET_KEY_STRING.getBytes());

                // Parse JWT token and extract claims
                Claims claims = Jwts.parserBuilder()
                        .setSigningKey(key)
                        .build()
                        .parseClaimsJws(jwt)
                        .getBody();

                // Extract email from JWT claims
                String email = String.valueOf(claims.get("email"));

                // Extract authorities (ensure correct key name)
                String authorities = String.valueOf(claims.get("authorities"));

                // Convert authorities string into a list of GrantedAuthority objects
                List<GrantedAuthority> authList = AuthorityUtils.commaSeparatedStringToAuthorityList(authorities);

                // Create an authentication token (credentials should be null for JWT-based authentication)
                UsernamePasswordAuthenticationToken authentication =
                        new UsernamePasswordAuthenticationToken(email, null, authList);

                // Set authentication in SecurityContext
                SecurityContextHolder.getContext().setAuthentication(authentication);

                // Store claims in request attributes (optional)
                request.setAttribute("claims", claims);

            } catch (Exception e) {
                throw new BadCredentialsException("Invalid JWT token", e);
            }
        }

        // Continue the filter chain
        filterChain.doFilter(request, response);
    }
}
