package com.DevilsQuest.app.convertors.attribute;

import javax.persistence.AttributeConverter;

import com.DevilsQuest.app.convertors.ConvertedEnum;

public abstract class EnumAttributeConverter<X extends ConvertedEnum<Y>, Y> implements AttributeConverter<X, Y> {
	@Override
	public final Y convertToDatabaseColumn(X x) {
		return x.toDbValue();
	}
}