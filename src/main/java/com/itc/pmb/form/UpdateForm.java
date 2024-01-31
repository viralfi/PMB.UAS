package com.itc.pmb.form;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateForm {
    @NotNull(message = "ID cannot be null or empty")
    private Long id;
    @NotEmpty(message = "Full name can not empty")
    private String fullName;
    @NotEmpty(message = "Email can not empty")
    @Email(message = "Invalid email, Please enter a valid email")
    private String email;
    @Pattern(regexp = "^\\d{11}$", message = "Invalid phone number")
    private String phone;
    private String address;
    private String title;
    private String bio;
}
