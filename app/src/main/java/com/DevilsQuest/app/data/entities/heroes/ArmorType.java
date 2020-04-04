package com.DevilsQuest.app.data.entities.heroes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.DevilsQuest.app.convertors.armorType.ArmorEntityTypeConverter;
import com.DevilsQuest.app.data.entities.base.BaseEntity;
import com.DevilsQuest.app.data.enums.ArmorTypeName;

@Entity
@Table(name = "armor_types")
public class ArmorType extends BaseEntity {
    @Convert(converter = ArmorEntityTypeConverter.class)
    @Column
    private ArmorTypeName name;

    @ManyToMany(mappedBy = "armorTypes")
    private List<HeroClass> classes;  

    public ArmorType() {
    }

    public ArmorTypeName getName() {
        return this.name;
    }

    public void setName(ArmorTypeName name) {
        this.name = name;
    }

    public List<HeroClass> getClasses() {
        return this.classes;
    }

    public void setClasses(List<HeroClass> classes) {
        this.classes = classes;
    }
}