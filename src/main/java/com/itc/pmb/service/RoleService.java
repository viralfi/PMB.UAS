package com.vialfinaz.sisteminforklinik.service;

import com.vialfinaz.sisteminforklinik.domain.Role;

import java.util.Collection;

public interface RoleService {
    Role getRoleByUserId(Long id);
    Collection<Role> getRoles();
}
