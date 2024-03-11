package universita.federicoii.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import universita.federicoii.entity.*;
import universita.federicoii.dto.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class StudenteConCorsoMapper
{
    @Autowired
    CorsoMapper corsoMapper;

    /* ------------------------------------------------- */
    /*                        DTO                        */
    /* ------------------------------------------------- */

    public StudenteConCorsoDTO studenteToDTO(Studente studente)
    {
        if(studente == null)
        {
            return new StudenteConCorsoDTO();
        }

        StudenteConCorsoDTO studenteDTO = new StudenteConCorsoDTO();

        studenteDTO.setId( studente.getId() );
        studenteDTO.setNome( studente.getNome() );
        studenteDTO.setCognome( studente.getCognome() );
        studenteDTO.setCodiceFiscale( studente.getCodiceFiscale() );
        studenteDTO.setMatricola( studente.getMatricola() );

        if(studente.getCorso() != null)
        {
            studenteDTO.setCorso( corsoMapper.corsoToDTO( studente.getCorso()) );
        }

        return studenteDTO;
    }

    public List<StudenteConCorsoDTO> studenteToDTOs(List<Studente> studenti)
    {
        List<StudenteConCorsoDTO> studentiDto = new ArrayList<>();

        for(Studente studente : studenti)
        {
            studentiDto.add( studenteToDTO(studente) );
        }

        return studentiDto;
    }

    /* ------------------------------------------------- */
    /*                       ENTITY                      */
    /* ------------------------------------------------- */

    public Studente studenteToEntity(StudenteConCorsoDTO studente)
    {

        if(studente == null)
        {
            return new Studente();
        }

        Studente studenteEntity = new Studente();

        studenteEntity.setId( studente.getId() );
        studenteEntity.setNome( studente.getNome() );
        studenteEntity.setCognome( studente.getCognome() );
        studenteEntity.setCodiceFiscale( studente.getCodiceFiscale() );
        studenteEntity.setMatricola( studente.getMatricola() );

        if(studente.getCorso() != null)
        {
            studenteEntity.setCorso( corsoMapper.corsoToEntity( studente.getCorso()) );
        }

        return studenteEntity;
    }

    public List<Studente> studenteToEntities(List<StudenteConCorsoDTO> studenti)
    {
        List<Studente> studentiEntity = new ArrayList<>();

        for(StudenteConCorsoDTO studente : studenti)
        {
            studentiEntity.add( studenteToEntity(studente) );
        }

        return studentiEntity;
    }

}