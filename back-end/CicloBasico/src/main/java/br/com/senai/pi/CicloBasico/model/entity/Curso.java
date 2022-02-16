package br.com.senai.pi.CicloBasico.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity(name = "TB_CURSO")
@Data
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CURSO")
    private Long id;

    @Column(name = "NOME", nullable = false)
    private String nome;

    @Column(name = "DESCRICAO", nullable = false)
    private String descricao;

    @Column(name = "URL_CAPA", nullable = false)
    private String urlCapa;

    @ManyToMany
    @JoinTable(
            name= "TB_CURSO_AULA",
            joinColumns = {@JoinColumn(name = "ID_CURSO")},
            inverseJoinColumns = {@JoinColumn(name = "ID_AULA")}
    )
    private List<Aula> aulas;

}
