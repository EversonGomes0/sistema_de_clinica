package com.br.ever.sistema_de_clinica.repository;

import com.br.ever.sistema_de_clinica.database.dominio.ConsultaEntity;
import com.br.ever.sistema_de_clinica.database.dominio.DoutorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface IDoutorRepository extends JpaRepository<DoutorEntity, Integer> {

    Optional<DoutorEntity> findByUsername(String username);
}
