package com.sp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp.entity.RegisterPerson;
import com.sp.repository.RegisterRepository;

@Service
public class RegisterService implements RegisterInterface {

	@Autowired
	private RegisterRepository registerRepository;

	@Override
	public String registerData(RegisterPerson registerPerson) {
		// Save data and return success message
		RegisterPerson savedPerson = registerRepository.save(registerPerson);
		return "Registration Successful! ID: " + savedPerson.getPersonId();
	}
}
