package br.com.senai.pi.CicloBasico.model.dto;

import lombok.Data;

import java.util.List;

@Data
public class AlunoDTO {
    private Long id;
    private String nome;
    private String email;
    private String senha;
    private List<CursoDTO> cursos;
}
