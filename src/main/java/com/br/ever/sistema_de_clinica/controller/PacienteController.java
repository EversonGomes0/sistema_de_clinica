package com.br.ever.sistema_de_clinica.controller;


import com.br.ever.sistema_de_clinica.database.dominio.PacienteEntity;
import com.br.ever.sistema_de_clinica.dto.PacienteDto;
import com.br.ever.sistema_de_clinica.service.PacienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
@RequiredArgsConstructor
public class PacienteController {

    private final PacienteService pacienteService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void salvar(@Validated @RequestBody PacienteDto pacienteDto) {
        pacienteService.cadastrarPaciente(pacienteDto);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<PacienteEntity> getPacientes(){
        return pacienteService.getPacientes();
    }
}
