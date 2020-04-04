package com.DevilsQuest.app.data.entities.heroes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.DevilsQuest.app.convertors.resourceGenerator.ResourceGeneratorEntityTypeConverter;
import com.DevilsQuest.app.data.entities.base.BaseEntity;
import com.DevilsQuest.app.data.enums.ResourceGeneratorName;

@Entity
@Table(name = "resource_generators")
public class ResourceGenerator extends BaseEntity {
    @Convert(converter = ResourceGeneratorEntityTypeConverter.class)
    @Column
    private ResourceGeneratorName name;

    @ManyToMany(mappedBy = "resourceGenerators")
    private List<HeroClass> classes;  

    public ResourceGenerator() {
    }

    public ResourceGeneratorName getName() {
        return this.name;
    }

    public void setName(ResourceGeneratorName name) {
        this.name = name;
    }

    public List<HeroClass> getClasses() {
        return this.classes;
    }

    public void setClasses(List<HeroClass> classes) {
        this.classes = classes;
    }
}