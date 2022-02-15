package br.com.senai.pi.CicloBasico.model.dto;

import lombok.Data;

@Data
public class ComentarioDTO {
    private Long id;
    private String conteudo;
    private AlunoDTO remetente;
}
