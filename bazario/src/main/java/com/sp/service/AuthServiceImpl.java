package com.sp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

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

	@Autowired
	private final UserRepository userRepository;
	@Autowired
	private final PasswordEncoder passwordEncoder;
	@Autowired
	private final CartRepository cartRepository;

	@Override
	public String craeteUser(SignUpRequest signUpRequest) {

		User user = userRepository.findByEmail(signUpRequest.getEmail());

		if (user == null) {
			User user2 = new User();
			user2.setEmail(signUpRequest.getEmail());
			user2.setFullName(signUpRequest.getFullName());
			user2.setRole(UserRole.ROLE_CUSTOMER);
			user2.setPhNo(9337318660l);
			;
			user2.setPassword(passwordEncoder.encode(signUpRequest.getOtp()));

			user = userRepository.save(user2);

			Cart cart = new Cart();
			cart.setUser(user);
			cartRepository.save(cart);
		}

		return " ";
	}

}
