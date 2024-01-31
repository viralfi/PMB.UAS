package com.itc.pmb.utils;

import com.itc.pmb.domain.UserPrincipal;
import com.itc.pmb.dto.UserDTO;
import org.springframework.security.core.Authentication;

public class UserUtils {
    public static UserDTO getAuthenticatedUser(Authentication authentication) {
        return ((UserDTO) authentication.getPrincipal());
    }
    public static UserDTO getLoggedInUser(Authentication authentication) {
        return ((UserPrincipal) authentication.getPrincipal()).getUser();
    }
}
