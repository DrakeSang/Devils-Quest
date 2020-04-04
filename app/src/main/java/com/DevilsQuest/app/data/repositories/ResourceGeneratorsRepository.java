package com.DevilsQuest.app.data.repositories;

import com.DevilsQuest.app.data.entities.heroes.ResourceGenerator;
import com.DevilsQuest.app.data.enums.ResourceGeneratorName;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResourceGeneratorsRepository extends JpaRepository<ResourceGenerator, Long> {
    ResourceGenerator findByName(ResourceGeneratorName name);
}