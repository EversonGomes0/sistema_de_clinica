package com.br.ever.sistema_de_clinica.repository;

import com.br.ever.sistema_de_clinica.database.dominio.ConsultaEntity;
import com.br.ever.sistema_de_clinica.database.dominio.DoutorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDoutorRepository extends JpaRepository<DoutorEntity, Integer> {
}
