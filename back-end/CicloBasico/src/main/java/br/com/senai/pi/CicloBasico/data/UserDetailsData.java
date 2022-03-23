package br.com.senai.pi.CicloBasico.data;

import br.com.senai.pi.CicloBasico.model.entity.Aluno;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

public class UserDetailsData implements UserDetails {

    private Optional<Aluno> aluno;

    public UserDetailsData(Optional<Aluno> aluno){
        this.aluno = aluno;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return new ArrayList<>();
    }


    @Override
    public String getPassword() {
        return aluno.orElse(new Aluno()).getSenha();
    }

    @Override
    public String getUsername() {
        return aluno.orElse(new Aluno()).getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
