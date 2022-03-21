package br.com.senai.pi.CicloBasico.model.dto;

import br.com.senai.pi.CicloBasico.util.validacao.SenhaValida;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@SenhaValida
public class AlunoDTO {
    private Long id;

    @NotEmpty(message = "Campo obrigatório")
    private String nome;

    @NotEmpty(message = "Campo obrigatório")
    @Email(message = "Email inválido")
    private String email;

    @NotEmpty(message = "Campo obrigatório")
    private String senha;

    @NotEmpty(message = "Campo obrigatório")
    private String confirmaSenha;

    private List<CursoDTO> cursos;
}
