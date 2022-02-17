package br.com.senai.pi.CicloBasico.service;

import br.com.senai.pi.CicloBasico.model.dto.CursoDTO;
import br.com.senai.pi.CicloBasico.model.entity.Curso;
import br.com.senai.pi.CicloBasico.repository.CursoRepository;
import br.com.senai.pi.CicloBasico.util.AulaConv;
import br.com.senai.pi.CicloBasico.util.CursoConv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoService {
    @Autowired
    CursoConv cursoConv;

    @Autowired
    AulaConv aulaConv;

    @Autowired
    CursoRepository cursoRepository;

    public CursoDTO buscarCursoPorId(Long id){
        Optional<Curso> op = cursoRepository.findById(id);
        if (op.isPresent()){
            return cursoConv.businessToDto(op.get());
        }

        return null;
    }

    public List<CursoDTO> listarCursos(){
        return cursoConv.businessListToDtoList(cursoRepository.findAll());
    }

    public void excluirCurso(Long id){
        cursoRepository.deleteById(id);
    }

    public CursoDTO adicionarCurso(CursoDTO dto){
        Curso curso = cursoConv.dtoToBusiness(dto);
        curso = cursoRepository.save(curso);

        return cursoConv.businessToDto(curso);
    }

    public CursoDTO editarCurso(CursoDTO dto, Long id){
        Optional<Curso> op = cursoRepository.findById(id);

        if(op.isPresent()){
            Curso curso = op.get();

            if(dto.getNome() != null){
                curso.setNome(dto.getNome());
            }
            if(dto.getDescricao() != null){
                curso.setDescricao(dto.getDescricao());
            }
            if(dto.getUrlCapa() != null){
                curso.setUrlCapa(dto.getUrlCapa());
            }
            if(dto.getAulas() != null){
                curso.setAulas(aulaConv.dtoListToBusinessList(dto.getAulas()));
            }

            cursoRepository.save(curso);

            return cursoConv.businessToDto(curso);
        }

        return null;
    }
}
