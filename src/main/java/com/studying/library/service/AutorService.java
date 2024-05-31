package com.studying.library.service;

import com.studying.library.entity.Autor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service//repository  component
public class AutorService {

    private final List<Autor> repositorio;

    public List<Autor> findAll() {
        return repositorio;
    }

    public Autor findById(final UUID id) {
        return null;
    }

    public Autor save(final Autor entity) {
        var response = Autor.builder()
                .id(UUID.randomUUID())
                .email(entity.getEmail())
                .name(entity.getName())
                .build();
        repositorio.add(response);
        return response;
    }
}
