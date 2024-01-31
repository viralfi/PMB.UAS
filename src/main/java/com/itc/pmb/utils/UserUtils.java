package com.vialfinaz.sisteminforklinik.utils;

import com.vialfinaz.sisteminforklinik.domain.UserPrincipal;
import com.vialfinaz.sisteminforklinik.dto.UserDTO;
import org.springframework.security.core.Authentication;

public class UserUtils {
    public static UserDTO getAuthenticatedUser(Authentication authentication) {
        return ((UserDTO) authentication.getPrincipal());
    }
    public static UserDTO getLoggedInUser(Authentication authentication) {
        return ((UserPrincipal) authentication.getPrincipal()).getUser();
    }
}
