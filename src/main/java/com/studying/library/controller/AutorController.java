package com.studying.library.controller;

import com.studying.library.controller.dto.AutorDtoRequest;
import com.studying.library.controller.dto.AutorDtoResponse;
import com.studying.library.controller.mapper.AutorMapper;
import com.studying.library.service.AutorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

import static com.studying.library.controller.mapper.AutorMapper.toDto;

@RestController
@RequestMapping(path = "/autor")
@RequiredArgsConstructor
@Log4j2
public class AutorController {

    private final AutorService service;

    @GetMapping
    public ResponseEntity<List<AutorDtoResponse>> findAll() {
        var autores = service.findAll();
        final List<AutorDtoResponse> dto = toDto(autores);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AutorDtoResponse> findById(@PathVariable("id") UUID id) {
        log.info("ID: " + id);
        var dto = toDto(service.findById(id));
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<AutorDtoResponse> save(@RequestBody AutorDtoRequest autorDto) {
        log.info("Saving");

        var autor = AutorMapper.toEntity(autorDto);
        var response = toDto(service.save(autor));

        return ResponseEntity.
                status(HttpStatus.CREATED).
                body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") UUID id) {
        log.info("Delete");
        return ResponseEntity
                .noContent()
                .build();
    }
}
