package com.itc.pmb.service;

import com.itc.pmb.domain.Role;

import java.util.Collection;

public interface RoleService {
    Role getRoleByUserId(Long id);
    Collection<Role> getRoles();
}
