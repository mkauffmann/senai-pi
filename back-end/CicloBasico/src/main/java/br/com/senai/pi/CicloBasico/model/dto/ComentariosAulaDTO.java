package br.com.senai.pi.CicloBasico.model.dto;

import lombok.Data;

import java.util.List;

@Data
public class ComentariosAulaDTO {
    AulaDTO aula;
    List<ComentarioDTO> comentarios;
}
