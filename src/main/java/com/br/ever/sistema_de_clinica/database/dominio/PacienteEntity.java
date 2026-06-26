package com.br.ever.sistema_de_clinica.database.dominio;

import jakarta.persistence.*;
import lombok.*;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Table(name = "pacientes")
@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PacienteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    private String nome;
    @Column(nullable = false, unique = true)
    private String cpf;

    @OneToMany(mappedBy = "paciente")
    private List<ConsultaEntity> consultas = new ArrayList<>();
}
