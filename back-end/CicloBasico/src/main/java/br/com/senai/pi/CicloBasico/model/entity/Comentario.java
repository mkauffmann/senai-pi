package br.com.senai.pi.CicloBasico.model.entity;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "TB_COMENTARIO")
@Data
public class Comentario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_COMENTARIO")
    private Long id;

    @Column(name = "CONTEUDO", nullable = false)
    private String conteudo;

    @JoinColumn(name = "ID_ALUNO", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Aluno remetente;

}
