package br.com.senai.pi.CicloBasico.controller;

import br.com.senai.pi.CicloBasico.model.dto.AlunoDTO;
import br.com.senai.pi.CicloBasico.model.dto.CursoDTO;
import br.com.senai.pi.CicloBasico.service.AlunoService;
import br.com.senai.pi.CicloBasico.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CursoController {
    @Autowired
    CursoService cursoService;

    @Autowired
    AlunoService alunoService;

    @GetMapping("/curso/{id}")
    public ModelAndView buscarCursoId(@PathVariable("id") Long id){
        ModelAndView mv = new ModelAndView("curso");
        mv.addObject(cursoService.buscarCursoPorId(id));
        return mv;
    }

    @PostMapping("/matricula/{idAluno}/{idCurso}")
    public String matricularAlunoCurso(@PathVariable("idAluno") Long idAluno, @PathVariable("idCurso") Long idCurso, Model model){
        if(alunoService.alunoEstaMatriculadoEmCurso(idAluno, idCurso)){
            model.addAttribute("erro");
            return "redirect:/curso/" + idCurso + "?erro=erro";

        }

        AlunoDTO dto = alunoService.matricularAlunoEmCurso(idAluno, idCurso);
        return "aluno";
    }

    @GetMapping("/catalogo")
    public ModelAndView listarCursos(){
        List<CursoDTO> listaCursos = cursoService.listarCursos();
        ModelAndView mv = new ModelAndView("catalogo");
        mv.addObject(listaCursos);
        return mv;
    }

}
