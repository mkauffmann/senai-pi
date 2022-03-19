package br.com.senai.pi.CicloBasico.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavController {

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/sobre")
    public String sobre(){
        return "sobre";
    }

    @GetMapping("/catalogo")
    public String catalogo(){
        return "catalogo";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/contato")
    public String contato(){
        return "contato";
    }

    @GetMapping("/curso")
    public String curso(){
        return "curso";
    }

}
