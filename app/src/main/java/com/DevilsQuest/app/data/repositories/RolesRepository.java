package com.DevilsQuest.app.data.repositories;

import com.DevilsQuest.app.data.entities.auth.Role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesRepository extends JpaRepository<Role, Long> {
    Role findByAuthority(String auth);
}