package br.com.senai.pi.CicloBasico.service;

import br.com.senai.pi.CicloBasico.model.dto.AlunoDTO;
import br.com.senai.pi.CicloBasico.model.dto.CursoDTO;
import br.com.senai.pi.CicloBasico.model.entity.Aluno;
import br.com.senai.pi.CicloBasico.model.entity.Curso;
import br.com.senai.pi.CicloBasico.repository.AlunoRepository;
import br.com.senai.pi.CicloBasico.util.AlunoConv;
import br.com.senai.pi.CicloBasico.util.CursoConv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {
    @Autowired
    AlunoRepository alunoRepository;

    @Autowired
    AlunoConv alunoConv;

    @Autowired
    CursoConv cursoConv;

    @Autowired
    CursoService cursoService;

    @Autowired
    PasswordEncoder encoder;

    public AlunoDTO adicionarNovoAluno(AlunoDTO dto){
        Aluno aluno = alunoConv.dtoToBusiness(dto);

        String encodedSenha = encoder.encode(aluno.getSenha());
        aluno.setSenha(encodedSenha);

        aluno = alunoRepository.save(aluno);
        return alunoConv.businessToDto(aluno);
    }

    public AlunoDTO editarAluno(AlunoDTO dto, Long id){
        Optional<Aluno> op = alunoRepository.findById(id);

        if(op.isPresent()){
            Aluno aluno = op.get();

            if(dto.getNome() != null){
                aluno.setNome(dto.getNome());
            }
            if(dto.getEmail() != null){
                aluno.setEmail(dto.getEmail());
            }
            if(dto.getSenha() != null){
                aluno.setSenha(dto.getSenha());
            }
            if(dto.getCursos() != null){
                aluno.setCursos(cursoConv.dtoListToBusinessList(dto.getCursos()));
            }

            alunoRepository.save(aluno);
            return alunoConv.businessToDto(aluno);
        }

        return null;
    }

    public AlunoDTO encontrarAlunoPorId(Long id){
        Optional<Aluno> op = alunoRepository.findById(id);

        if (op.isPresent()){
            return alunoConv.businessToDto(op.get());
        }

        return null;
    }

    public List<AlunoDTO> listarAlunos(){
        List<Aluno> alunos = alunoRepository.findAll();
        return alunoConv.businessListToDtoList(alunos);
    }

    public void excluirAluno(Long id){
        alunoRepository.deleteById(id);
    }

    public AlunoDTO matricularAlunoEmCurso(Long idAluno, Long idCurso){
        Optional<Aluno> op = alunoRepository.findById(idAluno);
        CursoDTO cursoDTO = cursoService.buscarCursoPorId(idCurso);

        if(op.isPresent() && cursoDTO != null){
            Curso curso = cursoConv.dtoToBusiness(cursoDTO);
            Aluno aluno = op.get();

            List<Curso> listaCursos = aluno.getCursos();
            listaCursos.add(curso);
            aluno.setCursos(listaCursos);

            alunoRepository.save(aluno);

            return alunoConv.businessToDto(aluno);
        }

        return null;
    }

    public AlunoDTO excluirCursoDeAluno(Long idAluno, Long idCurso){
        Optional<Aluno> op = alunoRepository.findById(idAluno);
        CursoDTO cursoDTO = cursoService.buscarCursoPorId(idCurso);

        if(op.isPresent() && cursoDTO != null){
            Curso curso = cursoConv.dtoToBusiness(cursoDTO);
            Aluno aluno = op.get();

            List<Curso> listaCursos = aluno.getCursos();
            listaCursos.remove(curso);
            aluno.setCursos(listaCursos);

            alunoRepository.save(aluno);

            return alunoConv.businessToDto(aluno);
        }

        return null;
    }
}
