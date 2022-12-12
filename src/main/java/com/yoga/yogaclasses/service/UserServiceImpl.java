package com.yoga.yogaclasses.service;

import com.yoga.yogaclasses.advice.EmailExistsException;
import com.yoga.yogaclasses.dto.UserRegistrationDto;
import com.yoga.yogaclasses.model.Role;
import com.yoga.yogaclasses.model.User;
import com.yoga.yogaclasses.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Override
    public User save(UserRegistrationDto registrationDto) throws EmailExistsException {
        String email= registrationDto.getEmail();
        User u=userRepository.findByEmail(email);
        if(u!=null){
            throw new EmailExistsException("user exists");
        }
        User user=new User(registrationDto.getName(),registrationDto.getAge(),registrationDto.getEmail(),passwordEncoder.encode(registrationDto.getPassword()),registrationDto.getYogaTime(), new Date(System.currentTimeMillis()),
                Arrays.asList(new Role("ROLE_USER")));
        return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("User details not found for the user "+email);
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(), mapRolesToAuthorities(user.getRoles()));
    }


    private Collection<?extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }
}
