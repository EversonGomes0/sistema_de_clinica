package com.br.ever.sistema_de_clinica.dto;

import com.br.ever.sistema_de_clinica.database.dominio.DoutorEntity;
import com.br.ever.sistema_de_clinica.database.dominio.PacienteEntity;
import com.br.ever.sistema_de_clinica.database.dominio.StatusConsulta;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.validation.annotation.Validated;

@Validated
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ConsultaDto {

    @NotNull
    private Long doutor_id;

    @NotNull
    private Long paciente_id;

}
