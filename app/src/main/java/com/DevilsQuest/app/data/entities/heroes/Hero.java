package com.DevilsQuest.app.data.entities.heroes;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.DevilsQuest.app.convertors.gender.GenderEntityTypeConverter;
import com.DevilsQuest.app.data.entities.auth.User;
import com.DevilsQuest.app.data.entities.base.BaseEntity;
import com.DevilsQuest.app.data.enums.GenderName;

@Entity
@Table(name = "characters")
public class Hero extends BaseEntity {    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "characters_types",
            joinColumns = {@JoinColumn(name = "character_id")},
            inverseJoinColumns = {@JoinColumn(name = "type_id")}
    )
    private List<CharacterType> characterTypes;

    @Convert(converter = GenderEntityTypeConverter.class)
    @Column
    private GenderName gender;

    @OneToMany(mappedBy = "character", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CharacterAttribute> attributes;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "characters_races",
            joinColumns = {@JoinColumn(name = "character_id")},
            inverseJoinColumns = {@JoinColumn(name = "race_id")}
    )
    private List<Race> races;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "characters_classes",
            joinColumns = {@JoinColumn(name = "character_id")},
            inverseJoinColumns = {@JoinColumn(name = "class_id")}
    )
    private List<HeroClass> heroClasses;

    @Column
    private String name;

    @Column
    private int level = 1;

    @Column
    private int xp = 1;

    @Column
    private int money = 1;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;    

    public Hero() {
        this.characterTypes = new ArrayList<>();
        this.attributes = new ArrayList<>();
        this.races = new ArrayList<>();
        this.heroClasses = new ArrayList<>();
    }
    
    public List<CharacterType> getCharacterTypes() {
        return this.characterTypes;
    } 
    
    public void addCharacterType(CharacterType characterType) {
        this.characterTypes.add(characterType);
    }

    public GenderName getGender() {
        return this.gender;
    }

    public void setGender(GenderName gender) {
        this.gender = gender;
    }

    public List<CharacterAttribute> getAttributes() {
        return this.attributes;
    }

    public void addAttribute(Attribute attribute) {
        CharacterAttribute characterAttribute = new CharacterAttribute(this, attribute);
        attributes.add(characterAttribute);
        attribute.getCharacters().add(characterAttribute);
    }

    public List<Race> getRaces() {
        return this.races;
    }

    public void addRace(Race race) {
        this.races.add(race);
    }

    public List<HeroClass> getHeroClasses() {
        return this.heroClasses;
    }

    public void addHeroCLass(HeroClass heroCLass) {
        this.heroClasses.add(heroCLass);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return this.level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getXp() {
        return this.xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public int getMoney() {
        return this.money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}