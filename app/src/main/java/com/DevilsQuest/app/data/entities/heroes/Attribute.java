package com.DevilsQuest.app.data.entities.heroes;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.DevilsQuest.app.data.entities.base.BaseEntity;

@Entity
@Table(name = "attributes")
public class Attribute extends BaseEntity {
    @Column
    private String name; 
    
    @Column
    private String description;
    
    @OneToMany(mappedBy = "attribute", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<CharacterAttribute> characters;

    public Attribute() {
        this.characters = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<CharacterAttribute> getCharacters() {
        return this.characters;
    }

    public void addCharacterAttribute(CharacterAttribute characterAttribute) {
        this.characters.add(characterAttribute);
    }
}