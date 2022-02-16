package br.com.senai.pi.CicloBasico.model.dto;


import lombok.Data;

import java.util.List;

@Data
public class CursoDTO {
    private Long id;
    private String nome;
    private String descricao;
    private String urlCapa;
    private List<AulaDTO> aulas;
}
