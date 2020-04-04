package com.DevilsQuest.app.data.enums;

import com.DevilsQuest.app.convertors.ConvertedEnum;
import com.DevilsQuest.app.convertors.resolver.ConvertedEnumResolver;

public enum GenderName implements ConvertedEnum<String> {
    MALE("Male"),
    FEMALE("Female");

    // ENUM -> DB VALUE CONVERSION
    private final String dbValue;

    private GenderName(String dbValue) {
        this.dbValue = dbValue;
    }
    
    @Override
    public String toDbValue() {
        return dbValue;
    }
    
    // DB VALUE -> ENUM CONVERSION
    public static final ConvertedEnumResolver<GenderName, String> resolver = 
        new ConvertedEnumResolver<>(GenderName.class);
    
    public static GenderName fromDbValue(String dbValue) {
        return resolver.get(dbValue);
    }
}