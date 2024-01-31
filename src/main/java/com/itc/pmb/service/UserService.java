package com.itc.pmb.service;

import com.itc.pmb.domain.User;
import com.itc.pmb.dto.UserDTO;
import com.itc.pmb.form.UpdateForm;
import org.springframework.web.multipart.MultipartFile;

public interface UserService {
    UserDTO createUser(User user);

    UserDTO getUserByEmail(String email);

    void sendVerificationCode(UserDTO user);

    UserDTO verifyCode(String email, String code);

    void resetPassword(String email);

    UserDTO verifyPasswordKey(String key);
    void updatePassword(Long userId, String password, String confirmPassword);

    void renewPassword(String key, String password, String confirmPassword);

    UserDTO verifyAccountKey(String key);

    UserDTO updateUserDetails(UpdateForm user);

    UserDTO getUserById(Long userId);

    void updatePassword(Long id, String currentPassword, String newPassword, String confirmNewPassword);

    void updateUserRole(Long userId, String roleName);

    void updateAccountSettings(Long id, Boolean enabled, Boolean notLocked);

    UserDTO toggleMfa(String email);

    void updateImage(UserDTO user, MultipartFile image);

}