package com.bancoalimentare.gestionale.mapper;

import com.bancoalimentare.gestionale.dto.ReferenteDTO;
import com.bancoalimentare.gestionale.entity.Referente;
import org.springframework.stereotype.Component;

import java.sql.Ref;
import java.util.ArrayList;
import java.util.List;

@Component
public class ReferenteMapper
{

    /* ------------------------------------------------- */
    /*                        DTO                        */
    /* ------------------------------------------------- */

    public ReferenteDTO referenteToDTO (Referente referente)
    {

        if( referente == null )
        {
            return new ReferenteDTO();
        }

        ReferenteDTO referenteDTO = new ReferenteDTO();

        referenteDTO.setId( referente.getId() );
        referenteDTO.setNome( referente.getNome() );
        referenteDTO.setCognome( referente.getCognome() );
        referenteDTO.setCellulare( referente.getCellulare() );

        return referenteDTO;
    }

    public List<ReferenteDTO> referentiToDTOs (List<Referente> referenti)
    {
        List<ReferenteDTO> referentiDTO = new ArrayList<>();

        for ( Referente referente : referenti )
        {
            referentiDTO.add( referenteToDTO(referente) );
        }

        return referentiDTO;
    }

    /* ------------------------------------------------- */
    /*                       ENTITY                      */
    /* ------------------------------------------------- */

    public Referente referenteToEntity (ReferenteDTO referente)
    {
        if(referente == null)
        {
            return new Referente();
        }

        Referente referenteEntity = new Referente();

        referenteEntity.setId( referente.getId() );
        referenteEntity.setNome( referente.getNome() );
        referenteEntity.setCognome( referente.getCognome() );
        referenteEntity.setCellulare( referente.getCellulare() );

        return referenteEntity;
    }

    public List<Referente> referentiToEntities (List<ReferenteDTO> referenti)
    {
        List<Referente> referentiEntities = new ArrayList<>();

        for(ReferenteDTO referente : referenti)
        {
            referentiEntities.add( referenteToEntity(referente) );
        }

        return referentiEntities;
    }

}