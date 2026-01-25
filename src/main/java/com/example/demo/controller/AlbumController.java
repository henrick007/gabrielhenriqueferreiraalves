/*
    ARQUIVO ALBUMCONTROLLER.JAVA: AQUI IMPLEMENTAMOS O METODO POST PARA A CRIAÇÃO DE NOVOS ALBUMS;
    TAMBÉM APRESENTA A LISTAGEM COMPLETA DOS ALBUMS, COM FILTROS E PAGINAÇÃO.
*/

package com.example.demo.controller;

import com.example.demo.dto.AlbumRequestDTO;
import com.example.demo.model.Album;
import com.example.demo.service.AlbumService;

import jakarta.validation.Valid;

import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/albums")
public class AlbumController {

    @Autowired
    private AlbumService service;
 
    @GetMapping
    public Page<Album> list(
        @RequestParam(required = false) String title,
        @RequestParam(required = false) String artistType,
        @ParameterObject Pageable pageable
) {
    return service.list(title, artistType, pageable);
}
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Album create(@RequestBody @Valid AlbumRequestDTO dto) {
    return service.create(dto);
}

}