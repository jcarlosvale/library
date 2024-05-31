package com.studying.library.controller.mapper;

import com.studying.library.controller.dto.AutorDtoRequest;
import com.studying.library.controller.dto.AutorDtoResponse;
import com.studying.library.entity.Autor;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class AutorMapper {
    public static List<AutorDtoResponse> toDto(final List<Autor> autores) {
        if (Objects.isNull(autores)) return List.of();
        return autores.stream()
                .map(autor -> toDto(autor))
                .toList();
    }

    public static AutorDtoResponse toDto(final Autor autor) {
        if (Objects.isNull(autor)) return AutorDtoResponse.builder().build();
        return
                AutorDtoResponse.builder()
                        .id(autor.getId())
                        .name(autor.getName())
                        .email(autor.getEmail())
                        .build();
    }


    public static Autor toEntity(final AutorDtoRequest dto) {
        if (Objects.isNull(dto)) return Autor.builder().build();
        return
                Autor.builder()
                        .name(dto.getName())
                        .email(dto.getEmail())
                        .build();
    }
}
