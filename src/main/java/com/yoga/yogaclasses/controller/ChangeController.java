package com.yoga.yogaclasses.controller;

import com.yoga.yogaclasses.advice.EmailExistsException;
import com.yoga.yogaclasses.dto.UserRegistrationDto;
import com.yoga.yogaclasses.model.User;
import com.yoga.yogaclasses.repository.UserRepository;
import com.yoga.yogaclasses.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/changeTheDate")
public class ChangeController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;


    @ModelAttribute("users")
    public UserRegistrationDto userRegistrationDto() {
        return new UserRegistrationDto();
    }

    @GetMapping
    public String showChangeForm() {
        return "change";
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") int yogaTime, Authentication authentication, Model model) {
        String email= authentication.getName();
        User user=userRepository.findByEmail(email);
        user.setYogaTime(yogaTime);
        return "index";
    }
}
