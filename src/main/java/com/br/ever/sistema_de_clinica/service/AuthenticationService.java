package com.br.ever.sistema_de_clinica.service;

import com.br.ever.sistema_de_clinica.config.SecurityConfiguration;
import com.br.ever.sistema_de_clinica.database.dominio.DoutorEntity;
import com.br.ever.sistema_de_clinica.database.dominio.PacienteEntity;
import com.br.ever.sistema_de_clinica.database.dominio.RolesEntity;
import com.br.ever.sistema_de_clinica.dto.RegisterDto;
import com.br.ever.sistema_de_clinica.enums.RolesType;
import com.br.ever.sistema_de_clinica.repository.IDoutorRepository;
import com.br.ever.sistema_de_clinica.repository.IPacienteRepository;
import com.br.ever.sistema_de_clinica.repository.IRolesRepository;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class AuthenticationService {

    private IPacienteRepository pacienteRepository;
    private IDoutorRepository doutorRepository;
    private IRolesRepository rolesRepository;
    private SecurityConfiguration securityConfiguration;


    public void cadastrarDoutor(RegisterDto registerDto) {
        if (registerDto.getNome().isEmpty() || registerDto.getCpf().isEmpty()){
            throw new RuntimeException("Doutor não possui nome ou cpf");
        }

        var roles = rolesRepository.findByName(RolesType.ROLE_ADMIN.name())
                .orElseGet(() -> rolesRepository.save(RolesEntity.builder().nome(RolesType.ROLE_ADMIN.name()).build()));


        doutorRepository.save(DoutorEntity.builder().nome(registerDto.getNome())
                .cpf(registerDto.getCpf())
                        .roles(Set.of(roles))
                        .senha(securityConfiguration.passwordEncoder().encode(registerDto.getSenha()))
                .build());
    }

    public void cadastrarPaciente(RegisterDto registerDto) {
        if (registerDto.getNome().isEmpty() || registerDto.getCpf().isEmpty()){
            throw new RuntimeException("Paciente não possui nome ou cpf");
        }

        var roles = rolesRepository.findByName(RolesType.ROLE_ADMIN.name())
                .orElseGet(() -> rolesRepository.save(RolesEntity.builder().nome(RolesType.ROLE_ADMIN.name()).build()));


        pacienteRepository.save(PacienteEntity.builder().nome(registerDto.getNome())
                .cpf(registerDto.getCpf())
                .roles(Set.of(roles))
                .senha(securityConfiguration.passwordEncoder().encode(registerDto.getSenha()))
                .build());
    }
}
