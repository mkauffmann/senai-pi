package br.com.senai.pi.CicloBasico.util.validacao;

import br.com.senai.pi.CicloBasico.model.dto.AlunoDTO;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidacaoSenha implements ConstraintValidator<SenhaValida, AlunoDTO> {
    @Override
    public void initialize(SenhaValida constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(AlunoDTO dto, ConstraintValidatorContext context) {
        if(dto.getSenha().equals(dto.getConfirmaSenha())){
            return true;
        }
        return false;
    }

}
