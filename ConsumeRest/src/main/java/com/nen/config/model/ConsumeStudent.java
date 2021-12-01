package com.nen.config.model;


import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.*;

@Data
@NoArgsConstructor
public class ConsumeStudent {

    private int id;

    @Size(min = 3, message = "username minimum length should be 3")
    @NotBlank(message = "username can't be empty!")
    private String username;

    @Size(min = 10)
    @NotBlank
    @Email(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]+$", message = "email should be in this format ******@******.***")
    private String email;

    @NotBlank(message = "password can't be empty!")
    @Size(min = 4, message = "Password minimum length should be 4!")
    private String password;

    @NotBlank(message = "country field can't be empty!")
    private String country;

    @NotBlank(message = "Gender can't be empty!")
    private String gender;

    @NotNull(message = "age can't be empty!")
    @Min(value = 18, message = "Minimum age should be above 18.")
    private Integer age;

}