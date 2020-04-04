package com.DevilsQuest.app.convertors.race;

import com.DevilsQuest.app.convertors.attribute.EnumAttributeConverter;
import com.DevilsQuest.app.data.enums.RaceName;

public class RaceEntityTypeConverter extends EnumAttributeConverter<RaceName, String> {    
    @Override
	public RaceName convertToEntityAttribute(String raceName) {
		return RaceName.fromDbValue(raceName);
	}
}