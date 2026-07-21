package com.br.ever.sistema_de_clinica.database.dominio;

import jakarta.persistence.*;
import lombok.*;
import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;

@Table(name = "roles")
@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RolesEntity implements GrantedAuthority{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
    @Column()
    private String nome;


    @Override
    public @Nullable String getAuthority() {
        return nome;
    }

}
