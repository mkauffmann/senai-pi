package br.com.senai.pi.CicloBasico.util;

import br.com.senai.pi.CicloBasico.model.dto.AlunoDTO;
import br.com.senai.pi.CicloBasico.model.dto.CursoDTO;
import br.com.senai.pi.CicloBasico.model.entity.Aluno;
import br.com.senai.pi.CicloBasico.model.entity.Curso;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class AlunoConv implements DTOConversion<Aluno, AlunoDTO> {
    @Autowired
    CursoConv cursoConv;

    @Override
    public Aluno dtoToBusiness(AlunoDTO dto) {
        Aluno aluno = new Aluno();

        if(dto.getId() != null){
            aluno.setId(dto.getId());
        }

        aluno.setNome(dto.getNome());
        aluno.setEmail(dto.getEmail());
        aluno.setSenha(dto.getSenha());

        if(dto.getCursos() != null){
            List<Curso> cursos = cursoConv.dtoListToBusinessList(dto.getCursos());
            aluno.setCursos(cursos);
        }

        return aluno;
    }

    @Override
    public AlunoDTO businessToDto(Aluno business) {
        AlunoDTO dto = new AlunoDTO();

        dto.setId(business.getId());
        dto.setNome(business.getNome());
        dto.setEmail(business.getEmail());
        dto.setSenha(business.getSenha());

        if(dto.getCursos() != null){
            List<CursoDTO> cursosDTO = cursoConv.businessListToDtoList(business.getCursos());
            dto.setCursos(cursosDTO);
        }

        return dto;
    }

    @Override
    public List<Aluno> dtoListToBusinessList(List<AlunoDTO> dtoList) {
        List<Aluno> alunoList = new ArrayList<Aluno>();

        for (AlunoDTO dto : dtoList){
            Aluno aluno = this.dtoToBusiness(dto);
            alunoList.add(aluno);
        }

        return alunoList;
    }

    @Override
    public List<AlunoDTO> businessListToDtoList(List<Aluno> businessList) {
        List<AlunoDTO> dtoList = new ArrayList<AlunoDTO>();

        for (Aluno aluno : businessList){
            AlunoDTO dto = this.businessToDto(aluno);
            dtoList.add(dto);
        }

        return dtoList;
    }

}
