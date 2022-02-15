package br.com.senai.pi.CicloBasico.model.dto;

import lombok.Data;

import java.util.List;

@Data
public class AulaDTO {
    private Long id;
    private String nome;
    private String descricao;
    private String urlVideo;
    private List<ComentarioDTO> comentarios;
}
