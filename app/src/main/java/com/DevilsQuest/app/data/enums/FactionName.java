package com.DevilsQuest.app.data.enums;

import com.DevilsQuest.app.convertors.ConvertedEnum;
import com.DevilsQuest.app.convertors.resolver.ConvertedEnumResolver;

public enum FactionName implements ConvertedEnum<String> {
    ALLIANCE("Alliance"),
    HORDE("Horde");

    // ENUM -> DB VALUE CONVERSION
    private final String dbValue;

    private FactionName(String dbValue) {
        this.dbValue = dbValue;
    }

    @Override
	public String toDbValue() {
		return dbValue;
	}

    // DB VALUE -> ENUM CONVERSION
    public static final ConvertedEnumResolver<FactionName, String> resolver = 
        new ConvertedEnumResolver<>(FactionName.class);

	public static FactionName fromDbValue(String dbValue) {
		return resolver.get(dbValue);
	}
}