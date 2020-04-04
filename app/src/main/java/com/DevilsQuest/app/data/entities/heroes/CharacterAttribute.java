package com.DevilsQuest.app.data.entities.heroes;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "characters_attributes")
public class CharacterAttribute {
    @EmbeddedId
    private CharacterAttributeId id;

    @ManyToOne
    @MapsId("characterId")
    private Hero character;    

    @ManyToOne
    @MapsId("attributeId")
    private Attribute attribute;    

    @Column
    private int value = 1;

    public CharacterAttribute() {
    }

    public CharacterAttribute(Hero hero, Attribute attribute) {
        this.character = hero;
        this.attribute = attribute;
        this.id = new CharacterAttributeId(hero.getId(), attribute.getId());
    }

    public Hero getCharacter() {
        return this.character;
    }

    public void setCharacter(Hero character) {
        this.character = character;
    }

    public Attribute getAttribute() {
        return this.attribute;
    }

    public void setAttribute(Attribute attribute) {
        this.attribute = attribute;
    }

    public int getValue() {
        return this.value;
    }

    public void setValue(int value) {
        this.value = value;
    }    
}