package br.com.senai.pi.CicloBasico.util;

import br.com.senai.pi.CicloBasico.model.dto.AulaDTO;
import br.com.senai.pi.CicloBasico.model.dto.CursoDTO;
import br.com.senai.pi.CicloBasico.model.entity.Aula;
import br.com.senai.pi.CicloBasico.model.entity.Curso;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class CursoConv implements DTOConversion<Curso, CursoDTO> {
    @Autowired
    AulaConv aulaConv;

    @Override
    public Curso dtoToBusiness(CursoDTO dto) {
        Curso curso = new Curso();

        if(dto.getId() != null){
            curso.setId(dto.getId());
        }

        curso.setNome(dto.getNome());
        curso.setDescricao(dto.getDescricao());
        curso.setUrlCapa(dto.getUrlCapa());

        if(dto.getAulas() != null){
            List<Aula> aulaList = aulaConv.dtoListToBusinessList(dto.getAulas());
            curso.setAulas(aulaList);
        }

        return curso;
    }

    @Override
    public CursoDTO businessToDto(Curso business) {
        CursoDTO dto = new CursoDTO();

        if(business.getId() != null){
            dto.setId(business.getId());
        }

        dto.setNome(business.getNome());
        dto.setDescricao(business.getDescricao());
        dto.setUrlCapa(business.getUrlCapa());

        if(business.getAulas() != null){
            List<AulaDTO> dtoList = aulaConv.businessListToDtoList(business.getAulas());
            dto.setAulas(dtoList);
        }

        return dto;
    }

    @Override
    public List<Curso> dtoListToBusinessList(List<CursoDTO> dtoList) {
        List<Curso> cursoList = new ArrayList<Curso>();

        for(CursoDTO dto : dtoList){
            Curso curso = this.dtoToBusiness(dto);
            cursoList.add(curso);
        }

        return cursoList;
    }

    @Override
    public List<CursoDTO> businessListToDtoList(List<Curso> businessList) {
        List<CursoDTO> dtoList = new ArrayList<CursoDTO>();

        for(Curso curso : businessList){
            CursoDTO dto = this.businessToDto(curso);
            dtoList.add(dto);
        }

        return dtoList;
    }
}
