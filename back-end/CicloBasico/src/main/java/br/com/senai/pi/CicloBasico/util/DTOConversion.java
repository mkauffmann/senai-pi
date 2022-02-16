package br.com.senai.pi.CicloBasico.util;

import java.util.List;

public interface DTOConversion<B, D> {
    public B dtoToBusiness(D dto);
    public D businessToDto(B business);
    public List<B> dtoListToBusinessList(List<D> dtoList);
    public List<D> businessListToDtoList(List<B> businessList);
}
