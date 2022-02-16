package br.com.senai.pi.CicloBasico.service;

import br.com.senai.pi.CicloBasico.model.dto.AlunoDTO;
import br.com.senai.pi.CicloBasico.model.entity.Aluno;
import br.com.senai.pi.CicloBasico.repository.AlunoRepository;
import br.com.senai.pi.CicloBasico.util.AlunoConv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlunoService {
    @Autowired
    AlunoRepository alunoRepository;

    @Autowired
    AlunoConv alunoConv;
}
