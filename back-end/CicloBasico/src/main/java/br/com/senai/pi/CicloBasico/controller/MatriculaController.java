package br.com.senai.pi.CicloBasico.controller;

import br.com.senai.pi.CicloBasico.model.dto.AlunoDTO;
import br.com.senai.pi.CicloBasico.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MatriculaController {
    @Autowired
    AlunoService alunoService;

    @PostMapping("/matricula/{idAluno}/{idCurso}")
    public ModelAndView matricularAlunoCurso(@PathVariable("idAluno") Long idAluno, @PathVariable("idCurso") Long idCurso){
        AlunoDTO dto = alunoService.matricularAlunoEmCurso(idAluno, idCurso);

        if(dto != null){
            return new ModelAndView("/");
        }
        ModelAndView mv = new ModelAndView("curso/" + idCurso);
        mv.addObject("erro", "Erro");
        return mv;
    }
}
