package com.yoga.yogaclasses.service;

import com.yoga.yogaclasses.advice.EmailExistsException;
import com.yoga.yogaclasses.dto.UserRegistrationDto;
import com.yoga.yogaclasses.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public interface UserService extends UserDetailsService {
    User save(UserRegistrationDto registrationDto) throws EmailExistsException;
}
