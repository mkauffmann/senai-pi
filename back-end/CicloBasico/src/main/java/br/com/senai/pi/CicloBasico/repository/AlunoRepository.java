package br.com.senai.pi.CicloBasico.repository;

import br.com.senai.pi.CicloBasico.model.entity.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}
