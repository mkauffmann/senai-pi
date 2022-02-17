package br.com.senai.pi.CicloBasico.util;

import br.com.senai.pi.CicloBasico.model.dto.AulaDTO;
import br.com.senai.pi.CicloBasico.model.dto.ComentarioDTO;
import br.com.senai.pi.CicloBasico.model.entity.Aula;
import br.com.senai.pi.CicloBasico.model.entity.Comentario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AulaConv implements DTOConversion<Aula, AulaDTO> {

    @Override
    public Aula dtoToBusiness(AulaDTO dto) {
        Aula aula = new Aula();

        if(dto.getId() != null){
            aula.setId(dto.getId());
        }

        aula.setNome(dto.getNome());
        aula.setDescricao(dto.getDescricao());
        aula.setUrlVideo(dto.getUrlVideo());


        return aula;
    }

    @Override
    public AulaDTO businessToDto(Aula business) {
        AulaDTO dto = new AulaDTO();

        if(business.getId() != null){
            dto.setId(business.getId());
        }

        dto.setNome(business.getNome());
        dto.setDescricao(business.getDescricao());
        dto.setUrlVideo(business.getUrlVideo());

        return dto;
    }

    @Override
    public List<Aula> dtoListToBusinessList(List<AulaDTO> dtoList) {
        List<Aula> aulaList = new ArrayList<Aula>();

        for(AulaDTO dto : dtoList){
            Aula aula = this.dtoToBusiness(dto);
            aulaList.add(aula);
        }

        return aulaList;
    }

    @Override
    public List<AulaDTO> businessListToDtoList(List<Aula> businessList) {
        List<AulaDTO> dtoList = new ArrayList<AulaDTO>();

        for(Aula aula : businessList){
            AulaDTO dto = this.businessToDto(aula);
            dtoList.add(dto);
        }

        return dtoList;
    }
}
