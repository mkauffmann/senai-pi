package br.com.senai.pi.CicloBasico.controller;

import br.com.senai.pi.CicloBasico.model.dto.AlunoDTO;
import br.com.senai.pi.CicloBasico.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class CadastroController {
    @Autowired
    AlunoService service;

    @GetMapping("/cadastro")
    public String getCadastro(Model model){
        model.addAttribute("alunoCadastro", model.getAttribute("alunoDTO"));
        return "login";
    }

    @PostMapping("/cadastro")
    public String adicionarAluno(@Valid AlunoDTO dto, BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute("alunoDTO", dto);
            return "login";
        }
        service.adicionarNovoAluno(dto);
        model.addAttribute("alunoDTO", new AlunoDTO());
        model.addAttribute("sucesso", "Usuário cadastrado com sucesso!");
        return "login";
    }
}
