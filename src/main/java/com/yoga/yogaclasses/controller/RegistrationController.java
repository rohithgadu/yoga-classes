package com.yoga.yogaclasses.controller;

import com.yoga.yogaclasses.advice.EmailExistsException;
import com.yoga.yogaclasses.dto.UserRegistrationDto;
import com.yoga.yogaclasses.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/registration")
public class RegistrationController {
    @Autowired
    private UserService userService;

    @ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto() {
        return new UserRegistrationDto();
    }

    @GetMapping
    public String showRegistrationForm() {
        return "registration";
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") @Valid UserRegistrationDto registrationDto) throws EmailExistsException {
        userService.save(registrationDto);
        return "success";
    }


}
