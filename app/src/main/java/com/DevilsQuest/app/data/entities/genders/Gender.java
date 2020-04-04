package com.DevilsQuest.app.data.entities.genders;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.DevilsQuest.app.convertors.gender.GenderEntityTypeConverter;
import com.DevilsQuest.app.data.entities.base.BaseEntity;
import com.DevilsQuest.app.data.enums.GenderName;

@Entity
@Table(name = "genders")
public class Gender extends BaseEntity {
    @Convert(converter = GenderEntityTypeConverter.class)
    @Column
    private GenderName name;

    public Gender() {
    }

    public GenderName getName() {
        return this.name;
    }

    public void setName(GenderName name) {
        this.name = name;
    }
}