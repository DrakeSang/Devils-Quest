package com.DevilsQuest.app.convertors.resourceGenerator;

import com.DevilsQuest.app.convertors.attribute.EnumAttributeConverter;
import com.DevilsQuest.app.data.enums.ResourceGeneratorName;

public class ResourceGeneratorEntityTypeConverter extends EnumAttributeConverter<ResourceGeneratorName, String> {    
    @Override
	public ResourceGeneratorName convertToEntityAttribute(String resourceGeneratorName) {
		return ResourceGeneratorName.fromDbValue(resourceGeneratorName);
	}
}