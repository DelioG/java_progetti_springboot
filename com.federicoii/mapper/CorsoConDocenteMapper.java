package universita.federicoii.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import universita.federicoii.dto.*;
import universita.federicoii.entity.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class CorsoConDocenteMapper
{

    @Autowired
    DocenteMapper docenteMapper;

    /* ------------------------------------------------- */
    /*                        DTO                        */
    /* ------------------------------------------------- */

    public CorsoConDocenteDTO corsoToDTO(Corso corso)
    {
        if(corso == null)
        {
            return new CorsoConDocenteDTO();
        }

        CorsoConDocenteDTO corsoDTO = new CorsoConDocenteDTO();

        corsoDTO.setId( corso.getId() );
        corsoDTO.setRamoAppartenenza( corso.getRamoAppartenenza() );
        corsoDTO.setNome( corso.getNome() );
        corsoDTO.setNumeroStudenti( corso.getNumeroStudenti() );

        if(corso.getDocente() != null)
        {
            corsoDTO.setDocente( docenteMapper.docenteToDTO( corso.getDocente()) );
        }

        return corsoDTO;
    }

    public List<CorsoConDocenteDTO> corsoToDTOs(List<Corso> corsi)
    {
        List<CorsoConDocenteDTO> corsiDTO = new ArrayList<>();

        for(Corso corso : corsi)
        {
            corsiDTO.add( corsoToDTO(corso) );
        }

        return corsiDTO;
    }

    /* ------------------------------------------------- */
    /*                       ENTITY                      */
    /* ------------------------------------------------- */

    public Corso corsoToEntity(CorsoConDocenteDTO corso)
    {
        if(corso == null)
        {
            return new Corso();
        }

        Corso corsoEntity = new Corso();

        corsoEntity.setId( corso.getId() );
        corsoEntity.setRamoAppartenenza( corso.getRamoAppartenenza() );
        corsoEntity.setNome( corso.getNome() );
        corsoEntity.setNumeroStudenti( corso.getNumeroStudenti() );

        if(corso.getDocente() != null)
        {
            corsoEntity.setDocente( docenteMapper.docenteToEntity( corso.getDocente() ) );
        }

        return corsoEntity;
    }

    public List<Corso> corsiToEntities(List<CorsoConDocenteDTO> corsi)
    {
        List<Corso> listaCorsi = new ArrayList<>();

        for(CorsoConDocenteDTO corso : corsi)
        {
            listaCorsi.add( corsoToEntity(corso) );
        }

        return listaCorsi;
    }

}