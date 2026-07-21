package com.br.ever.sistema_de_clinica.service;

import com.br.ever.sistema_de_clinica.database.dominio.DoutorEntity;
import com.br.ever.sistema_de_clinica.repository.IDoutorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsImp implements UserDetailsService {
    private IDoutorRepository doutorRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return doutorRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));
    }
}
