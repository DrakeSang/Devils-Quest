package com.DevilsQuest.app.data.enums;

import com.DevilsQuest.app.convertors.ConvertedEnum;
import com.DevilsQuest.app.convertors.resolver.ConvertedEnumResolver;

public enum ResourceGeneratorName implements ConvertedEnum<String> {
    FURY("Fury"),
    SPIRIT("Spirit"),
    WRATH("Wrath"),
    DEISCIPLINE("Discipline"),
    MANA("Mana");

    // ENUM -> DB VALUE CONVERSION
    private final String dbValue;

    private ResourceGeneratorName(String dbValue) {
        this.dbValue = dbValue;
    }

    @Override
	public String toDbValue() {
		return dbValue;
	}

    // DB VALUE -> ENUM CONVERSION
    public static final ConvertedEnumResolver<ResourceGeneratorName, String> resolver = 
        new ConvertedEnumResolver<>(ResourceGeneratorName.class);

	public static ResourceGeneratorName fromDbValue(String dbValue) {
		return resolver.get(dbValue);
	}
}