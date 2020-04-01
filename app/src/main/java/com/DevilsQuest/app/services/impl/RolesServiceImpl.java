package com.DevilsQuest.app.services.impl;

import com.DevilsQuest.app.data.entities.auth.Role;
import com.DevilsQuest.app.data.repositories.RolesRepository;
import com.DevilsQuest.app.services.RolesService;

import org.springframework.stereotype.Service;

@Service
public class RolesServiceImpl implements RolesService {
    private final RolesRepository roleRepository;

    public RolesServiceImpl(RolesRepository rolesRepository) {
        this.roleRepository = rolesRepository;
    }

    @Override
    public void seedRolesInDb() {
        if (roleRepository.count() == 0) {
            roleRepository.saveAndFlush(new Role("USER"));
            roleRepository.saveAndFlush(new Role("ADMIN"));
            roleRepository.saveAndFlush(new Role("ROOT"));
        }
    }     
}