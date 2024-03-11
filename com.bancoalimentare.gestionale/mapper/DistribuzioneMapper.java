package com.bancoalimentare.gestionale.mapper;

import com.bancoalimentare.gestionale.dto.*;
import com.bancoalimentare.gestionale.entity.Distribuzione;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DistribuzioneMapper
{

    /* ------------------------------------------------- */
    /*                        DTO                        */
    /* ------------------------------------------------- */

    public DistribuzioneDTO distribuzioneToDTO (Distribuzione distribuzione)
    {

        if( distribuzione == null )
        {
            return new DistribuzioneDTO();
        }

        DistribuzioneDTO distribuzioneDTO = new DistribuzioneDTO();

        distribuzioneDTO.setId( distribuzione.getId() );
        distribuzioneDTO.setDataDistribuzione( distribuzione.getDataDistribuzione() );

        return distribuzioneDTO;
    }

    public List<DistribuzioneDTO> distribuzioniToDTOs (List<Distribuzione> distribuzioni)
    {
        List<DistribuzioneDTO> distribuzioniDTO = new ArrayList<>();

        for ( Distribuzione distribuzione : distribuzioni )
        {
            distribuzioniDTO.add( distribuzioneToDTO(distribuzione) );
        }

        return distribuzioniDTO;
    }

    /* ------------------------------------------------- */
    /*                       ENTITY                      */
    /* ------------------------------------------------- */

    public Distribuzione distribuzioneToEntity (DistribuzioneDTO distribuzione)
    {
        if(distribuzione == null)
        {
            return new Distribuzione();
        }

        Distribuzione distribuzioneEntity = new Distribuzione();

        distribuzioneEntity.setId( distribuzione.getId() );
        distribuzioneEntity.setDataDistribuzione( distribuzione.getDataDistribuzione() );

        return distribuzioneEntity;
    }

    public List<Distribuzione> distribuzioniToEntities (List<DistribuzioneDTO> distribuzioni)
    {
        List<Distribuzione> distribuzionesEntity = new ArrayList<>();

        for(DistribuzioneDTO distribuzione : distribuzioni)
        {
            distribuzionesEntity.add( distribuzioneToEntity(distribuzione) );
        }

        return distribuzionesEntity;
    }

}