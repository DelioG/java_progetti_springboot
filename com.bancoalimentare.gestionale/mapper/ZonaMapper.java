package com.bancoalimentare.gestionale.mapper;

import com.bancoalimentare.gestionale.dto.ZonaDTO;
import com.bancoalimentare.gestionale.entity.Zona;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ZonaMapper
{

    /* ------------------------------------------------- */
    /*                        DTO                        */
    /* ------------------------------------------------- */

    public ZonaDTO zonaToDTO (Zona zona)
    {

        if( zona == null )
        {
            return new ZonaDTO();
        }

        ZonaDTO zonaDTO = new ZonaDTO();

        zonaDTO.setId( zona.getId() );
        zonaDTO.setNome( zona.getNome() );

        return zonaDTO;
    }

    public List<ZonaDTO> zoneToDTOs (List<Zona> zone)
    {
        List<ZonaDTO> zoneDTO = new ArrayList<>();

        for ( Zona zona : zone )
        {
            zoneDTO.add( zonaToDTO(zona) );
        }

        return zoneDTO;
    }

    /* ------------------------------------------------- */
    /*                       ENTITY                      */
    /* ------------------------------------------------- */

    public Zona zonaToEntity (ZonaDTO zona)
    {
        if(zona == null)
        {
            return new Zona();
        }

        Zona zonaEntity = new Zona();

        zonaEntity.setId( zona.getId() );
        zonaEntity.setNome( zona.getNome() );

        return zonaEntity;
    }

    public List<Zona> zoneToEntities (List<ZonaDTO> zone)
    {
        List<Zona> zoneEntities = new ArrayList<>();

        for(ZonaDTO zona : zone)
        {
            zoneEntities.add( zonaToEntity(zona) );
        }

        return zoneEntities;
    }

}