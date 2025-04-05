package com.sp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.sp.config.JwtProvider;
import com.sp.domain.UserRole;
import com.sp.entity.Cart;
import com.sp.entity.User;
import com.sp.repository.CartRepository;
import com.sp.repository.UserRepository;
import com.sp.response.SignUpRequest;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final JwtProvider jwtProvider;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final CartRepository cartRepository;

    @Override
    public String createUser(SignUpRequest signUpRequest) {

        User user = userRepository.findByEmail(signUpRequest.getEmail());

        if (user == null) {
            User user2 = new User();
            user2.setEmail(signUpRequest.getEmail());
            user2.setFullName(signUpRequest.getFullName());
            user2.setRole(UserRole.ROLE_CUSTOMER);
            user2.setPhNo(9337318660L); // Fixed 'L' placement
            user2.setPassword(passwordEncoder.encode(signUpRequest.getOtp()));

            user = userRepository.save(user2);

            Cart cart = new Cart();
            cart.setUser(user);
            cartRepository.save(cart);
        }

        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(UserRole.ROLE_CUSTOMER.toString()));

        Authentication authentication = new UsernamePasswordAuthenticationToken(
            signUpRequest.getEmail(), null, authorities);

        SecurityContextHolder.getContext().setAuthentication(authentication);

        return jwtProvider.generateToken(authentication);
    }

	
}
