package com.DevilsQuest.app.data.entities.heroes;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CharacterAttributeId implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "character_id")
    private long characterId;
 
    @Column(name = "attribute_id")
    private long attributeId;

    public CharacterAttributeId() {
    }   
    
    public CharacterAttributeId(long characterId, long attributeId) {
        this.characterId = characterId;
        this.attributeId = attributeId;
    }    

    public long getCharacterId() {
        return this.characterId;
    }

    public void setCharacterId(long characterId) {
        this.characterId = characterId;
    }

    public long getAttributeId() {
        return this.attributeId;
    }

    public void setAttributeId(long attributeId) {
        this.attributeId = attributeId;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CharacterAttributeId)) {
            return false;
        }
        CharacterAttributeId characterAttributeId = (CharacterAttributeId) o;
        return characterId == characterAttributeId.characterId && attributeId == characterAttributeId.attributeId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(characterId, attributeId);
    }
}