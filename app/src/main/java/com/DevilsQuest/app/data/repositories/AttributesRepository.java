package com.DevilsQuest.app.data.repositories;

import com.DevilsQuest.app.data.entities.heroes.Attribute;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttributesRepository extends JpaRepository<Attribute, Long> {

}