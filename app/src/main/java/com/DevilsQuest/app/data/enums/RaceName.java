package com.DevilsQuest.app.data.enums;

import com.DevilsQuest.app.convertors.ConvertedEnum;
import com.DevilsQuest.app.convertors.resolver.ConvertedEnumResolver;

public enum RaceName implements ConvertedEnum<String> {
    HUMAN("Human"),
    DWARF("Dwarf"),
    NIGHT_ELF("Night Elf"),
    ORC("Orc"),
    TROLL("Troll"),
    UNDEAD("Undead");

    // ENUM -> DB VALUE CONVERSION
    private final String dbValue;

    private RaceName(String dbValue) {
        this.dbValue = dbValue;
    }

    @Override
	public String toDbValue() {
		return dbValue;
	}

    // DB VALUE -> ENUM CONVERSION
    public static final ConvertedEnumResolver<RaceName, String> resolver = 
        new ConvertedEnumResolver<>(RaceName.class);

	public static RaceName fromDbValue(String dbValue) {
		return resolver.get(dbValue);
	}
}