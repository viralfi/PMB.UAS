package com.vialfinaz.sisteminforklinik.service.implementation;

import com.vialfinaz.sisteminforklinik.Repository.RoleRepository;
import com.vialfinaz.sisteminforklinik.domain.Role;
import com.vialfinaz.sisteminforklinik.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepository<Role> roleRepository;
    @Override
    public Role getRoleByUserId(Long id) {
        return roleRepository.getRoleByUserId(id);
    }

    @Override
    public Collection<Role> getRoles() {
        return roleRepository.list();
    }
}
