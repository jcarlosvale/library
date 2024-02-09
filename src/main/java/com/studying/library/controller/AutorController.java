package com.studying.library.controller;

import com.studying.library.controller.dto.AutorDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping(path="/autor")
public class AutorController {

    @GetMapping
    public AutorDto getAutor() {
        return AutorDto.builder()
                .id(UUID.randomUUID())
                .email("email@email.com")
                .nome("Josefina")
                .build();
    }



}
