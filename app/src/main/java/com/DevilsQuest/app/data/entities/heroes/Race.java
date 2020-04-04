package com.DevilsQuest.app.data.entities.heroes;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.DevilsQuest.app.convertors.race.RaceEntityTypeConverter;
import com.DevilsQuest.app.data.entities.base.BaseEntity;
import com.DevilsQuest.app.data.enums.RaceName;

@Entity
@Table(name = "races")
public class Race extends BaseEntity {
    @Convert(converter = RaceEntityTypeConverter.class)
    @Column
    private RaceName name;

    @ManyToMany(mappedBy = "races")
    private List<Hero> heroes;  

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "races_factions",
            joinColumns = {@JoinColumn(name = "race_id")},
            inverseJoinColumns = {@JoinColumn(name = "faction_id")}
    )
    private List<Faction> factions;

    public Race() {
        this.factions = new ArrayList<>();
    }

    public RaceName getName() {
        return this.name;
    }

    public void setName(RaceName name) {
        this.name = name;
    }

    public List<Hero> getHeroes() {
        return this.heroes;
    }

    public void setHeroes(List<Hero> heroes) {
        this.heroes = heroes;
    }

    public List<Faction> getFactions() {
        return this.factions;
    }

    public void addFaction(Faction faction) {
        this.factions.add(faction);
    }
}