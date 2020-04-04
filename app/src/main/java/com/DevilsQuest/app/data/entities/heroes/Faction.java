package com.DevilsQuest.app.data.entities.heroes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.DevilsQuest.app.convertors.faction.FactionEntityTypeConverter;
import com.DevilsQuest.app.data.entities.base.BaseEntity;
import com.DevilsQuest.app.data.enums.FactionName;

@Entity
@Table(name = "factions")
public class Faction extends BaseEntity {
    @Convert(converter = FactionEntityTypeConverter.class)
    @Column
    private FactionName name;

    @ManyToMany(mappedBy = "factions")
    private List<Race> races;  

    public Faction() {
    }

    public FactionName getName() {
        return this.name;
    }

    public void setName(FactionName name) {
        this.name = name;
    }

    public List<Race> getRaces() {
        return this.races;
    }

    public void setRaces(List<Race> races) {
        this.races = races;
    }
}