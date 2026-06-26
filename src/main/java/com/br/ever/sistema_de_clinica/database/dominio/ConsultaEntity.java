package com.br.ever.sistema_de_clinica.database.dominio;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "consultas")
@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ConsultaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private PacienteEntity paciente;

    @ManyToOne
    @JoinColumn(name = "doutor_id")
    private DoutorEntity doutor;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusConsulta status;



}
