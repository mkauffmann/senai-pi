package br.com.senai.pi.CicloBasico.controller;

import br.com.senai.pi.CicloBasico.model.dto.AlunoDTO;
import br.com.senai.pi.CicloBasico.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class AlunoController implements WebMvcConfigurer{
//    @Autowired
//    AlunoService alunoService;
//
//    @GetMapping
//    public List<AlunoDTO> listarAlunos(){
//        return alunoService.listarAlunos();
//    }
//
//    @GetMapping("/{id}")
//    public AlunoDTO buscarAlunoPorId(@PathVariable("id") Long id){
//        return alunoService.encontrarAlunoPorId(id);
//    }
//
//
//    @PutMapping("/{id}")
//    public AlunoDTO editarAluno(@RequestBody AlunoDTO dto, @PathVariable("id") Long id){
//        return alunoService.editarAluno(dto, id);
//    }
//
//    @DeleteMapping("/{id}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void excluirAluno(@PathVariable("id") Long id){
//        alunoService.excluirAluno(id);
//    }
//
//    @PutMapping("/matricula/{idAluno}/{idCurso}")
//    public AlunoDTO matricularAlunoCurso(@PathVariable("idAluno") Long idAluno, @PathVariable("idCurso") Long idCurso){
//        return alunoService.matricularAlunoEmCurso(idAluno, idCurso);
//    }
//
//    @PutMapping("/excluirMatricula/{idAluno}/{idCurso}")
//    public AlunoDTO excluirCursoDeAluno(@PathVariable("idAluno") Long idAluno, @PathVariable("idCurso") Long idCurso){
//        return alunoService.excluirCursoDeAluno(idAluno, idCurso);
//    }
}
