package com.br.ever.sistema_de_clinica.service;

import com.br.ever.sistema_de_clinica.database.dominio.ConsultaEntity;
import com.br.ever.sistema_de_clinica.database.dominio.DoutorEntity;
import com.br.ever.sistema_de_clinica.database.dominio.PacienteEntity;
import com.br.ever.sistema_de_clinica.database.dominio.StatusConsulta;
import com.br.ever.sistema_de_clinica.dto.ConsultaDto;
import com.br.ever.sistema_de_clinica.exception.BadRequestException;
import com.br.ever.sistema_de_clinica.repository.IConsultaRepository;
import com.br.ever.sistema_de_clinica.repository.IDoutorRepository;
import com.br.ever.sistema_de_clinica.repository.IPacienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ConsultaService {
    private final IConsultaRepository consultaRepository;
    private final IPacienteRepository pacienteRepository;
    private final IDoutorRepository doutorRepository;

    public void agendarConsulta(ConsultaDto consultaDto) throws BadRequestException {
        var pacienteEntity = pacienteRepository.findById(Math.toIntExact(consultaDto.getPaciente_id()))
                .orElseThrow();

        var doutorEntity = doutorRepository.findById(Math.toIntExact(consultaDto.getDoutor_id()))
                .orElseThrow();

        consultaRepository.save(ConsultaEntity.builder()
                .doutor(doutorEntity)
                .paciente(pacienteEntity)
                .status(StatusConsulta.AGENDADA).build());
    }
    public void finalizarConsulta(Long  id) {
        var consulta = consultaRepository.findById(Math.toIntExact(id)).orElseThrow(() -> new RuntimeException());
        consulta.finalizada();

        consultaRepository.save(consulta);
    }
    public void confirmarConsulta(Long  id) {
        var consulta = consultaRepository.findById(Math.toIntExact(id)).orElseThrow(() -> new RuntimeException());
        consulta.confirmar();

        consultaRepository.save(consulta);
    }
}
