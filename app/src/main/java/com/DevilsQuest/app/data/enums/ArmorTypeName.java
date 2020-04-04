package com.DevilsQuest.app.data.enums;

import com.DevilsQuest.app.convertors.ConvertedEnum;
import com.DevilsQuest.app.convertors.resolver.ConvertedEnumResolver;

public enum ArmorTypeName implements ConvertedEnum<String> {
    MAIL("Mail"),
    CLOTH("Cloth"),
    LEATHER("Leather");

    // ENUM -> DB VALUE CONVERSION
    private final String dbValue;

    private ArmorTypeName(String dbValue) {
        this.dbValue = dbValue;
    }
    
    @Override
    public String toDbValue() {
        return dbValue;
    }
    
    // DB VALUE -> ENUM CONVERSION
    public static final ConvertedEnumResolver<ArmorTypeName, String> resolver = 
        new ConvertedEnumResolver<>(ArmorTypeName.class);
    
    public static ArmorTypeName fromDbValue(String dbValue) {
        return resolver.get(dbValue);
    }
}