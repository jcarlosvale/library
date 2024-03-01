package com.studying.library.service;

import com.studying.library.controller.dto.AutorDtoRequest;
import com.studying.library.controller.dto.AutorDtoResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class AutorService {


    private List<AutorDtoResponse> database = new ArrayList<>();

    public List<AutorDtoResponse> findAll() {
        return database;
    }

    public AutorDtoResponse findById(final UUID id) {
        return null;
    }

    public AutorDtoResponse save(final AutorDtoRequest dto) {
        var response = AutorDtoResponse.builder()
                .id(UUID.randomUUID())
                .email(dto.getEmail())
                .name(dto.getName())
                .build();
        database.add(response);
        return response;
    }
}
