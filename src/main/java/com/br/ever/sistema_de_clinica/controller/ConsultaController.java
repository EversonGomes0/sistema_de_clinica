package com.br.ever.sistema_de_clinica.controller;


import com.br.ever.sistema_de_clinica.database.dominio.PacienteEntity;
import com.br.ever.sistema_de_clinica.dto.ConsultaDto;
import com.br.ever.sistema_de_clinica.dto.PacienteDto;
import com.br.ever.sistema_de_clinica.exception.BadRequestException;
import com.br.ever.sistema_de_clinica.service.ConsultaService;
import com.br.ever.sistema_de_clinica.service.PacienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consultas")
@RequiredArgsConstructor
public class ConsultaController {
    private final ConsultaService consultaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void agendarConsulta(@Validated @RequestBody ConsultaDto consultaDto) throws BadRequestException {
        consultaService.agendarConsulta(consultaDto);
    }
}
