package br.com.senai.pi.CicloBasico.controller;

import br.com.senai.pi.CicloBasico.model.dto.CursoDTO;
import br.com.senai.pi.CicloBasico.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursoController {
    @Autowired
    CursoService cursoService;

    @GetMapping("/{id}")
    public CursoDTO buscarCursoId(@PathVariable("id") Long id){
        return cursoService.buscarCursoPorId(id);
    }

    @GetMapping
    public List<CursoDTO> listarCursos(){
        return cursoService.listarCursos();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CursoDTO adicionarAluno(@RequestBody CursoDTO dto){
        return cursoService.adicionarCurso(dto);
    }

    @PutMapping("/{id}")
    public CursoDTO editarAluno(@RequestBody CursoDTO dto, @PathVariable("id") Long id){
        return cursoService.editarCurso(dto, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluirAluno(@PathVariable("id") Long id){
        cursoService.excluirCurso(id);
    }
}
