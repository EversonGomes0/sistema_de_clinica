package com.br.ever.sistema_de_clinica.controller;


import com.br.ever.sistema_de_clinica.database.dominio.DoutorEntity;
import com.br.ever.sistema_de_clinica.dto.DoutorDto;
import com.br.ever.sistema_de_clinica.dto.PacienteDto;
import com.br.ever.sistema_de_clinica.service.DoutorService;
import com.br.ever.sistema_de_clinica.service.PacienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doutores")
@RequiredArgsConstructor
public class DoutorController {

    private final DoutorService doutorService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void salvar(@Validated @RequestBody DoutorDto doutorDto) {
        doutorService.cadastrarDoutor(doutorDto);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<DoutorEntity> listarDoutores(){return doutorService.listarDoutores();}
}
