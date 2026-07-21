package com.br.ever.sistema_de_clinica.repository;

import com.br.ever.sistema_de_clinica.database.dominio.RolesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IRolesRepository extends JpaRepository<RolesEntity, Integer> {

    Optional<RolesEntity> findByName(String name);
}
