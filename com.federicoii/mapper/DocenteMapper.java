package universita.federicoii.mapper;

import org.springframework.stereotype.Component;
import universita.federicoii.entity.*;
import universita.federicoii.dto.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class DocenteMapper
{

    /* ------------------------------------------------- */
    /*                        DTO                        */
    /* ------------------------------------------------- */

    public DocenteDTO docenteToDTO(Docente docente)
    {
        if(docente == null)
        {
            return new DocenteDTO();
        }

        DocenteDTO docenteDTO = new DocenteDTO();

        docenteDTO.setId( docente.getId() );
        docenteDTO.setNome( docente.getNome() );
        docenteDTO.setCognome( docente.getCognome() );
        docenteDTO.setCodiceFiscale( docente.getCodiceFiscale() );
        docenteDTO.setMatricola( docente.getMatricola() );

        return docenteDTO;
    }

    public List<DocenteDTO> docenteToDTOs(List<Docente> docenti)
    {
        List<DocenteDTO> docentiDto = new ArrayList<>();

        for(Docente docente : docenti)
        {
            docentiDto.add( docenteToDTO(docente) );
        }

        return docentiDto;
    }

    /* ------------------------------------------------- */
    /*                       ENTITY                      */
    /* ------------------------------------------------- */

    public Docente docenteToEntity(DocenteDTO docente)
    {
        if(docente == null)
        {
            return new Docente();
        }

        Docente docenteEntity = new Docente();

        docenteEntity.setId( docente.getId() );
        docenteEntity.setNome( docente.getNome() );
        docenteEntity.setCognome( docente.getCognome() );
        docenteEntity.setCodiceFiscale( docente.getCodiceFiscale() );
        docenteEntity.setMatricola( docente.getMatricola() );

        return docenteEntity;
    }

    public List<Docente> docenteToEntities(List<DocenteDTO> docenti)
    {
        List<Docente> docentiEntity = new ArrayList<>();

        for(DocenteDTO docente : docenti)
        {
            docentiEntity.add( docenteToEntity(docente) );
        }

        return docentiEntity;
    }

}