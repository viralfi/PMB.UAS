package com.itc.pmb.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_DEFAULT;
//
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(NON_DEFAULT)
public class User {
    private Long id;
    @NotEmpty(message = "Full name can not empty")
    private String fullName;
    @Email(message = "Invalid email, Please enter a valid email")
    private String email;
    @NotEmpty(message = "Password can not empty")
    private String password;
    private String address;
    @NotEmpty(message = "Phone can not empty")
    private String phone;
    private String title;
    private String bio;
    private String imageUrl;
    private boolean enabled;
    private boolean isNotLocked;
    private boolean isUsingMfa;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAd;
    private LocalDateTime deletedAd;



}
