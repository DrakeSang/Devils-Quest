package com.DevilsQuest.app.convertors.faction;

import com.DevilsQuest.app.convertors.attribute.EnumAttributeConverter;
import com.DevilsQuest.app.data.enums.FactionName;

public class FactionEntityTypeConverter extends EnumAttributeConverter<FactionName, String> {    
    @Override
	public FactionName convertToEntityAttribute(String factionName) {
		return FactionName.fromDbValue(factionName);
	}
}