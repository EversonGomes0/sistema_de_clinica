package com.br.ever.sistema_de_clinica.service;

import com.br.ever.sistema_de_clinica.database.dominio.DoutorEntity;
import com.br.ever.sistema_de_clinica.dto.DoutorDto;
import com.br.ever.sistema_de_clinica.repository.IDoutorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DoutorService {
    private final IDoutorRepository idoutorRepository;

    public void cadastrarDoutor(DoutorDto doutorDto){
        if (doutorDto.getNome().isEmpty() || doutorDto.getCpf().isEmpty()){
            throw new RuntimeException("Doutor não possui nome ou cpf");
        }
        idoutorRepository.save(DoutorEntity.builder().nome(doutorDto.getNome())
                .cpf(doutorDto.getCpf())
                .especialidade(doutorDto.getEspecialidade())
                .build());
    }
    public List<DoutorEntity> listarDoutores(){return idoutorRepository.findAll();}

}
