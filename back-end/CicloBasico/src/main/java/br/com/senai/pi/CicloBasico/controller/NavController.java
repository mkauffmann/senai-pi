package br.com.senai.pi.CicloBasico.controller;

import br.com.senai.pi.CicloBasico.model.dto.AlunoDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavController {

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("alunoDTO", new AlunoDTO());
        return "index";
    }

    @GetMapping("/sobre")
    public String sobre(){
        return "sobre";
    }

    @GetMapping("/login")
    public String login(Model model){
        model.addAttribute("alunoDTO", new AlunoDTO());
        return "login";
    }

    @GetMapping("/contato")
    public String contato(){
        return "contato";
    }

    @GetMapping("/aluno")
    public String aluno() {return "aluno";}
}
