package universita.federicoii.mapper;

import org.springframework.stereotype.Component;
import universita.federicoii.dto.CorsoDTO;
import universita.federicoii.entity.Corso;
import java.util.ArrayList;
import java.util.List;

@Component
public class CorsoMapper
{

    /* ------------------------------------------------- */
    /*                        DTO                        */
    /* ------------------------------------------------- */

    public CorsoDTO corsoToDTO(Corso corso)
    {
        if(corso == null)
        {
            return new CorsoDTO();
        }

        CorsoDTO corsoDTO = new CorsoDTO();

        corsoDTO.setId( corso.getId() );
        corsoDTO.setRamoAppartenenza( corso.getRamoAppartenenza() );
        corsoDTO.setNome( corso.getNome() );
        corsoDTO.setNumeroStudenti( corso.getNumeroStudenti() );

        return corsoDTO;
    }

    public List<CorsoDTO> corsoToDTOs(List<Corso> corsi)
    {
        List<CorsoDTO> corsiDTO = new ArrayList<>();

        for(Corso corso : corsi)
        {
            corsiDTO.add( corsoToDTO(corso) );
        }

        return corsiDTO;
    }

    /* ------------------------------------------------- */
    /*                       ENTITY                      */
    /* ------------------------------------------------- */

    public Corso corsoToEntity(CorsoDTO corso)
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

        return corsoEntity;
    }

    public List<Corso> corsiToEntities(List<CorsoDTO> corsi)
    {
        List<Corso> listaCorsi = new ArrayList<>();

        for(CorsoDTO corso : corsi)
        {
            listaCorsi.add( corsoToEntity(corso) );
        }

        return listaCorsi;
    }

}