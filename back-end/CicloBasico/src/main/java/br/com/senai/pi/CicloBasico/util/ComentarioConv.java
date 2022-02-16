package br.com.senai.pi.CicloBasico.util;

import br.com.senai.pi.CicloBasico.model.dto.ComentarioDTO;
import br.com.senai.pi.CicloBasico.model.entity.Comentario;

import java.util.List;

public class ComentarioConv implements DTOConversion<Comentario, ComentarioDTO> {
    @Override
    public Comentario dtoToBusiness(ComentarioDTO dto) {
        return null;
    }

    @Override
    public ComentarioDTO businessToDto(Comentario business) {
        return null;
    }

    @Override
    public List<Comentario> dtoListToBusinessList(List<ComentarioDTO> dtoList) {
        return null;
    }

    @Override
    public List<ComentarioDTO> businessListToDtoList(List<Comentario> businessList) {
        return null;
    }
}
