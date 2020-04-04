package com.DevilsQuest.app.convertors;

/**
 * Declares this enum as converted into database, column value of type Y.
 */
public interface ConvertedEnum<Y> {
    Y toDbValue();
}