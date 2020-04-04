package com.DevilsQuest.app.services;

import java.util.List;

public interface MappingService<T, Y> {
    /**
     * Method for mapping list of source models to list of destnation models
     * 
     * @param source the source model
     * @param dest the destination model
     * @return list of destination models
     */
    List<Y> getAllMappedModels(List<T> source, Y dest);
}