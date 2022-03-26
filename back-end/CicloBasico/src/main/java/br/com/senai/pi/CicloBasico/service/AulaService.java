package br.com.senai.pi.CicloBasico.service;

import br.com.senai.pi.CicloBasico.model.dto.AulaDTO;
import br.com.senai.pi.CicloBasico.model.entity.Aula;
import br.com.senai.pi.CicloBasico.repository.AulaRepository;
import br.com.senai.pi.CicloBasico.util.AulaConv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AulaService {
    @Autowired
    AulaRepository aulaRepository;

    @Autowired
    AulaConv aulaConv;

    public AulaDTO buscarAulaPorId(Long id){
        Optional<Aula> op = aulaRepository.findById(id);

        if(op.isPresent()){
            return aulaConv.businessToDto(op.get());
        }
        return null;
    }

    public String buscarNomeDoCursoPorAula(Long id){
        return aulaRepository.buscarNomeDoCursoPorIdAula(id);
    }
}
