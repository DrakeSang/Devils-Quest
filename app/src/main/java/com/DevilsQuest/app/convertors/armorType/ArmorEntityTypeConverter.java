package com.DevilsQuest.app.convertors.armorType;

import com.DevilsQuest.app.convertors.attribute.EnumAttributeConverter;
import com.DevilsQuest.app.data.enums.ArmorTypeName;

public class ArmorEntityTypeConverter extends EnumAttributeConverter<ArmorTypeName, String> {    
    @Override
	public ArmorTypeName convertToEntityAttribute(String armorTypeName) {
		return ArmorTypeName.fromDbValue(armorTypeName);
	}
}