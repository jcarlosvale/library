package com.studying.library.controller;

import com.studying.library.controller.dto.AutorDtoRequest;
import com.studying.library.controller.dto.AutorDtoResponse;
import com.studying.library.service.AutorService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
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

@RestController
@RequestMapping(path = "/autor")
@Log4j2
public class AutorController {

    @Autowired
    private AutorService service;

    @GetMapping
    public ResponseEntity<List<AutorDtoResponse>> findAll() {
        var autores = service.findAll();
        return ResponseEntity.ok(autores);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AutorDtoResponse> findById(@PathVariable("id") UUID id) {
        log.info("ID: " + id);
        var autor = service.findById(id);
        return ResponseEntity.ok(autor);
    }

    @PostMapping
    public ResponseEntity<AutorDtoResponse> save(@RequestBody AutorDtoRequest dto) {
        log.info("Saving");
        var autor = service.save(dto);
        return ResponseEntity.
                status(HttpStatus.CREATED).
                body(autor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") UUID id) {
        log.info("Delete");
        return ResponseEntity
                .noContent()
                .build();
    }
}
