package br.com.senai.pi.CicloBasico.service;

import br.com.senai.pi.CicloBasico.data.UserDetailsData;
import br.com.senai.pi.CicloBasico.model.dto.AlunoDTO;
import br.com.senai.pi.CicloBasico.model.entity.Aluno;
import br.com.senai.pi.CicloBasico.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    AlunoRepository alunoRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Aluno> aluno = alunoRepository.findByEmail(email);

        if(!aluno.isPresent()){
            throw new UsernameNotFoundException("Usuário não encontrado");
        }

        return new UserDetailsData(aluno);
    }
}
