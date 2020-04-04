package com.DevilsQuest.app.data.entities.heroes;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.DevilsQuest.app.convertors.heroClass.HeroClassEntityTypeConverter;
import com.DevilsQuest.app.data.entities.base.BaseEntity;
import com.DevilsQuest.app.data.enums.CharacterClass;

@Entity
@Table(name = "classes")
public class HeroClass extends BaseEntity {
    @Convert(converter = HeroClassEntityTypeConverter.class)
    @Column
    private CharacterClass name;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "classes_armors",
            joinColumns = {@JoinColumn(name = "class_id")},
            inverseJoinColumns = {@JoinColumn(name = "armor_id")}
    )
    private List<ArmorType> armorTypes;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "classes_resource",
            joinColumns = {@JoinColumn(name = "class_id")},
            inverseJoinColumns = {@JoinColumn(name = "resource_id")}
    )
    private Set<ResourceGenerator> resourceGenerators;

    @Column
    private String imageUrl;

    @Column(columnDefinition = "text")
    private String overview;

    @ManyToMany(mappedBy = "heroClasses")
    private List<Hero> heroes;  
    
    public HeroClass() {   
        this.armorTypes = new ArrayList<>();  
        this.resourceGenerators = new HashSet<>();     
    }
    
    public CharacterClass getName() {
        return this.name;
    }

    public void setName(CharacterClass name) {
        this.name = name;
    }

    public List<ArmorType> getArmorTypes() {
        return this.armorTypes;
    }

    public void addArmorType(ArmorType armorType) {
        this.armorTypes.add(armorType);
    }

	public void addArmorTypes(List<ArmorType> armorTypes) {
        this.armorTypes = armorTypes;
    }

    public Set<ResourceGenerator> getResourceGnerators() {
        return this.resourceGenerators;
    }
    
    public void addResourceGenerator(ResourceGenerator resourceGnerator) {
        this.resourceGenerators.add(resourceGnerator);
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getOverview() {
        return this.overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public List<Hero> getHeroes() {
        return this.heroes;
    }
    
    public void setHeroes(List<Hero> heroes) {
        this.heroes = heroes;
    }
}