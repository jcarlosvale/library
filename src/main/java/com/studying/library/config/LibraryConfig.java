package com.studying.library.config;


import com.studying.library.entity.Autor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class LibraryConfig {

    @Bean(name = "repositorio")
    public List<Autor> getRepositorio() {
        return new ArrayList<>();
    }
}
