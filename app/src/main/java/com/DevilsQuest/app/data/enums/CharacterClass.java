package com.DevilsQuest.app.data.enums;

import com.DevilsQuest.app.convertors.ConvertedEnum;
import com.DevilsQuest.app.convertors.resolver.ConvertedEnumResolver;

public enum CharacterClass implements ConvertedEnum<String> {
    BARBARIAN("Barbarian"),
    CRUSADER("Crusader"),
    DEMON_HUNTER("Demon Hunter"),
    MONK("Monk"),
    WIZARD("Wizard"),
    WITCH_DOCTOR("Witch Doctor");

    // ENUM -> DB VALUE CONVERSION
    private final String dbValue;

    private CharacterClass(String dbValue) {
        this.dbValue = dbValue;
    }
    
    @Override
    public String toDbValue() {
        return dbValue;
    }
    
    // DB VALUE -> ENUM CONVERSION
    public static final ConvertedEnumResolver<CharacterClass, String> resolver = 
        new ConvertedEnumResolver<>(CharacterClass.class);
    
    public static CharacterClass fromDbValue(String dbValue) {
        return resolver.get(dbValue);
    }
}