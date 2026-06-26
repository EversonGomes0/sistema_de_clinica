package com.br.ever.sistema_de_clinica.dto;

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
public class PacienteDto {

    @NotBlank
    private String nome;
    @NotBlank
    private String cpf;
}
