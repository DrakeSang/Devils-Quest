package com.DevilsQuest.app.convertors.gender;

import com.DevilsQuest.app.convertors.attribute.EnumAttributeConverter;
import com.DevilsQuest.app.data.enums.GenderName;

public class GenderEntityTypeConverter extends EnumAttributeConverter<GenderName, String> {
    @Override
	public GenderName convertToEntityAttribute(String genderName) {
		return GenderName.fromDbValue(genderName);
	}
}