package br.com.senai.pi.CicloBasico.controller;

import br.com.senai.pi.CicloBasico.service.AulaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AulaController {

    @Autowired
    AulaService aulaService;

    @GetMapping("/aula/{id}")
    public ModelAndView buscarAulaPorId(@PathVariable("id") Long idAula){
        ModelAndView mv = new ModelAndView("aula");
        mv.addObject(aulaService.buscarAulaPorId(idAula));
        mv.addObject("nomeCurso", aulaService.buscarNomeDoCursoPorAula(idAula));

        return mv;
    }
}
