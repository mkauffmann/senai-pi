package br.com.senai.pi.CicloBasico.model.dto;


import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class CursoDTO {
    private Long id;
    private String nome;
    private String descricao;
    private String urlCapa;
    private LocalDate data;
    private List<AulaDTO> aulas;
}
