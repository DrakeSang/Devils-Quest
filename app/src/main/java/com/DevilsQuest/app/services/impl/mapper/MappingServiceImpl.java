package com.DevilsQuest.app.services.impl.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.DevilsQuest.app.services.MappingService;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class MappingServiceImpl<T, Y> implements MappingService<T, Y> {
    private final ModelMapper modelMapper;

    public MappingServiceImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Y> getAllMappedModels(List<T> source, Y dest) {
        return (List<Y>) source
                .stream()
                .map(entity -> modelMapper.map(entity, dest.getClass()))
                .collect(Collectors.toList());
    }
}