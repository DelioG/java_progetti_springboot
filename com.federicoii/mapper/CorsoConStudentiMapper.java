package universita.federicoii.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import universita.federicoii.dto.*;
import universita.federicoii.entity.Corso;
import java.util.ArrayList;
import java.util.List;

@Component
public class CorsoConStudentiMapper
{

    @Autowired
    StudenteMapper studenteMapper;

    /* ------------------------------------------------- */
    /*                        DTO                        */
    /* ------------------------------------------------- */

    public CorsoConStudentiDTO corsoToDTO(Corso corso)
    {
        if(corso == null)
        {
            return new CorsoConStudentiDTO();
        }

        CorsoConStudentiDTO corsoDTO = new CorsoConStudentiDTO();

        corsoDTO.setId( corso.getId() );
        corsoDTO.setRamoAppartenenza( corso.getRamoAppartenenza() );
        corsoDTO.setNome( corso.getNome() );
        corsoDTO.setNumeroStudenti( corso.getNumeroStudenti() );

        if(corso.getStudenti() != null)
        {
            corsoDTO.setStudenti( studenteMapper.studenteToDTOs( corso.getStudenti()) );
        }

        return corsoDTO;
    }

    public List<CorsoConStudentiDTO> corsoToDTOs(List<Corso> corsi)
    {
        List<CorsoConStudentiDTO> corsiDTO = new ArrayList<>();

        for(Corso corso : corsi)
        {
            corsiDTO.add( corsoToDTO(corso) );
        }

        return corsiDTO;
    }

    /* ------------------------------------------------- */
    /*                       ENTITY                      */
    /* ------------------------------------------------- */

    public Corso corsoToEntity(CorsoConStudentiDTO corso)
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
        corsoEntity.setStudenti( studenteMapper.studenteToEntities(corso.getStudenti()) );

        if(corso.getStudenti() != null)
        {
            corsoEntity.setStudenti( studenteMapper.studenteToEntities( corso.getStudenti() ) );
        }

        return corsoEntity;
    }

    public List<Corso> corsiToEntities(List<CorsoConStudentiDTO> corsi)
    {
        List<Corso> listaCorsi = new ArrayList<>();

        for(CorsoConStudentiDTO corso : corsi)
        {
            listaCorsi.add( corsoToEntity(corso) );
        }

        return listaCorsi;
    }

}