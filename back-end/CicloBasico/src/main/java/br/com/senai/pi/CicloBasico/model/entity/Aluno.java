package br.com.senai.pi.CicloBasico.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity(name = "TB_ALUNO")
@Data
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ALUNO")
    private Long id;

    @Column(name = "NOME", nullable = false)
    private String nome;

    @Column(name = "EMAIL", nullable = false)
    private String email;

    @Column(name = "SENHA", nullable = false)
    private String senha;

    @ManyToMany
    @JoinTable(
            name= "TB_ALUNO_CURSO",
            joinColumns = {@JoinColumn(name = "ID_ALUNO")},
            inverseJoinColumns = {@JoinColumn(name = "ID_CURSO")}
    )
    private List<Curso> cursos;
}
