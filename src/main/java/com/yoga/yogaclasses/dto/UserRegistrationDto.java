package com.yoga.yogaclasses.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRegistrationDto {

    @NotNull
    @Size(min = 4,message ="name should have at least 4 characters")
    private String name;
    @Min(18)
    @Max(65)
    @NotNull
    private int age;
    @Email
    @NotNull
    private String email;

    @NotNull
    @Size(min = 8,message = "password should have at least 8 characters")
    private String password;

    private int yogaTime;

}
