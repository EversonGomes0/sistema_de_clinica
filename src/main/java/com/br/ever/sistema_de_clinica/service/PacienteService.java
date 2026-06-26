package com.br.ever.sistema_de_clinica.service;

import com.br.ever.sistema_de_clinica.database.dominio.PacienteEntity;
import com.br.ever.sistema_de_clinica.dto.PacienteDto;
import com.br.ever.sistema_de_clinica.repository.IPacienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PacienteService {
    private final IPacienteRepository pacienteRepository;

    public void cadastrarPaciente(PacienteDto pacientedto) {
        if (pacientedto.getCpf() == null) {
            throw new RuntimeException("Paciente já cadastrado");
        }
        pacienteRepository.save(PacienteEntity.builder()
                .nome(pacientedto.getNome())
                .cpf(pacientedto.getCpf()).build());
    }

    public List<PacienteEntity> getPacientes(){
        return pacienteRepository.findAll();
    }
}
