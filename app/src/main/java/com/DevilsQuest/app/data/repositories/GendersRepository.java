package com.DevilsQuest.app.data.repositories;

import com.DevilsQuest.app.data.entities.genders.Gender;
import com.DevilsQuest.app.data.enums.GenderName;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GendersRepository extends JpaRepository<Gender, Long> {
    Gender findByName(GenderName name);
}