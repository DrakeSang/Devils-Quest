package com.DevilsQuest.app.data.entities.heroes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.DevilsQuest.app.data.entities.base.BaseEntity;

@Entity
@Table(name = "avaiable_character_types")
public class CharacterType extends BaseEntity {
    @Column
    private String name;

    @ManyToMany(mappedBy = "characterTypes")
    private List<Hero> heroes;  

    public CharacterType() {
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Hero> getHeroes() {
        return this.heroes;
    }

    public void setHeroes(List<Hero> heroes) {
        this.heroes = heroes;
    }
}