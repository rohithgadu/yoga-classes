package com.yoga.yogaclasses.advice;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.*;



@Controller
@ControllerAdvice
public class ExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @org.springframework.web.bind.annotation.ExceptionHandler(org.springframework.validation.BindException.class)
    public String handleInvalidArgument(BindException ex) {
        return "error";
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @org.springframework.web.bind.annotation.ExceptionHandler(EmailExistsException.class)
    public String handleEmailException(EmailExistsException e){
        return "userExists";
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @org.springframework.web.bind.annotation.ExceptionHandler(DateException.class)
    public String handleDateException(DateException e){
        return "dateException";
    }


}
