package com.DevilsQuest.app.convertors.heroClass;

import com.DevilsQuest.app.convertors.attribute.EnumAttributeConverter;
import com.DevilsQuest.app.data.enums.CharacterClass;

public class HeroClassEntityTypeConverter extends EnumAttributeConverter<CharacterClass, String> {
    @Override
	public CharacterClass convertToEntityAttribute(String characterClassname) {
		return CharacterClass.fromDbValue(characterClassname);
	}
}