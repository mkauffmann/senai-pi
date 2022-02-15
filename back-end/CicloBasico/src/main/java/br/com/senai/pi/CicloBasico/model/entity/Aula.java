package br.com.senai.pi.CicloBasico.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity(name = "TB_AULA")
@Data
public class Aula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_AULA")
    private Long id;

    @Column(name = "NOME", nullable = false)
    private String nome;

    @Column(name = "DESCRICAO", nullable = false)
    private String descricao;

    @Column(name = "URL_VIDEO", nullable = false)
    private String urlVideo;

    @ManyToMany
    @JoinTable(
            name= "TB_AULA_COMENTARIO",
            joinColumns = {@JoinColumn(name = "ID_AULA")},
            inverseJoinColumns = {@JoinColumn(name = "ID_COMENTARIO")}
    )
    private List<Comentario> comentarios;
}
