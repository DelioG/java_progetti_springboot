package com.bancoalimentare.gestionale.mapper;

import com.bancoalimentare.gestionale.dto.FamigliaDTO;
import com.bancoalimentare.gestionale.entity.Famiglia;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FamigliaMapper
{

    /* ------------------------------------------------- */
    /*                        DTO                        */
    /* ------------------------------------------------- */

    public FamigliaDTO famigliaToDTO (Famiglia famiglia)
    {

        if( famiglia == null )
        {
            return new FamigliaDTO();
        }

        FamigliaDTO famigliaDTO = new FamigliaDTO();

        famigliaDTO.setId( famiglia.getId() );
        famigliaDTO.setNumComponenti( famiglia.getNumComponenti() );
        famigliaDTO.setNote( famiglia.getNote() );

        return famigliaDTO;
    }

    public List<FamigliaDTO> famiglieToDTOs (List<Famiglia> famiglie)
    {
        List<FamigliaDTO> famiglieDTO = new ArrayList<>();

        for ( Famiglia famiglia : famiglie )
        {
            famiglieDTO.add( famigliaToDTO(famiglia) );
        }

        return famiglieDTO;
    }

    /* ------------------------------------------------- */
    /*                       ENTITY                      */
    /* ------------------------------------------------- */

    public Famiglia famiglieToEntity (FamigliaDTO famiglia)
    {
        if(famiglia == null)
        {
            return new Famiglia();
        }

        Famiglia famigliaEntity = new Famiglia();

        famigliaEntity.setId( famiglia.getId() );
        famigliaEntity.setNumComponenti( famiglia.getNumComponenti() );
        famigliaEntity.setNote( famiglia.getNote() );

        return famigliaEntity;
    }

    public List<Famiglia> famiglieToEntities (List<FamigliaDTO> famiglie)
    {
        List<Famiglia> famiglieEntities = new ArrayList<>();

        for(FamigliaDTO famiglia : famiglie)
        {
            famiglieEntities.add( famiglieToEntity(famiglia) );
        }

        return famiglieEntities;
    }

}