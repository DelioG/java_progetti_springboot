package universita.federicoii.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import universita.federicoii.entity.*;
import universita.federicoii.dto.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class DocenteConCorsoMapper
{

    @Autowired
    CorsoMapper corsoMapper;

    /* ------------------------------------------------- */
    /*                        DTO                        */
    /* ------------------------------------------------- */

    public DocenteConCorsoDTO docenteToDTO(Docente docente)
    {
        if(docente == null)
        {
            return new DocenteConCorsoDTO();
        }

        DocenteConCorsoDTO docenteDTO = new DocenteConCorsoDTO();

        docenteDTO.setId( docente.getId() );
        docenteDTO.setNome( docente.getNome() );
        docenteDTO.setCognome( docente.getCognome() );
        docenteDTO.setCodiceFiscale( docente.getCodiceFiscale() );
        docenteDTO.setMatricola( docente.getMatricola() );

        if(docente.getCorso() != null)
        {
            docenteDTO.setCorso( corsoMapper.corsoToDTO( docente.getCorso()) );
        }

        return docenteDTO;
    }

    public List<DocenteConCorsoDTO> docenteToDTOs(List<Docente> docenti)
    {
        List<DocenteConCorsoDTO> docentiDto = new ArrayList<>();

        for(Docente docente : docenti)
        {
            docentiDto.add( docenteToDTO(docente) );
        }

        return docentiDto;
    }

    /* ------------------------------------------------- */
    /*                       ENTITY                      */
    /* ------------------------------------------------- */

    public Docente docenteToEntity(DocenteConCorsoDTO docente)
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

        if(docente.getCorso() != null)
        {
            docenteEntity.setCorso( corsoMapper.corsoToEntity( docente.getCorso()) );
        }

        return docenteEntity;
    }

    public List<Docente> docenteToEntities(List<DocenteConCorsoDTO> docenti)
    {
        List<Docente> docentiEntity = new ArrayList<>();

        for(DocenteConCorsoDTO docente : docenti)
        {
            docentiEntity.add( docenteToEntity(docente) );
        }

        return docentiEntity;
    }
}