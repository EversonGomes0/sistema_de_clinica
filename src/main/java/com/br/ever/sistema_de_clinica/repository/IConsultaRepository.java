package com.br.ever.sistema_de_clinica.repository;

import com.br.ever.sistema_de_clinica.database.dominio.ConsultaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IConsultaRepository extends JpaRepository<ConsultaEntity, Integer> {
}
