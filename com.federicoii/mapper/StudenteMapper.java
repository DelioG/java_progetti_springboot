package universita.federicoii.mapper;

import org.springframework.stereotype.Component;
import universita.federicoii.entity.*;
import universita.federicoii.dto.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class StudenteMapper
{

    /* ------------------------------------------------- */
    /*                        DTO                        */
    /* ------------------------------------------------- */

    public StudenteDTO studenteToDTO(Studente studente)
    {

        if(studente == null)
        {
            return new StudenteDTO();
        }

        StudenteDTO studenteDTO = new StudenteDTO();

        studenteDTO.setId( studente.getId() );
        studenteDTO.setNome( studente.getNome() );
        studenteDTO.setCognome( studente.getCognome() );
        studenteDTO.setCodiceFiscale( studente.getCodiceFiscale() );
        studenteDTO.setMatricola( studente.getMatricola() );

        return studenteDTO;
    }

    public List<StudenteDTO> studenteToDTOs(List<Studente> studenti)
    {
        List<StudenteDTO> studentiDto = new ArrayList<>();

        for(Studente studente : studenti)
        {
            studentiDto.add( studenteToDTO(studente) );
        }

        return studentiDto;
    }

    /* ------------------------------------------------- */
    /*                       ENTITY                      */
    /* ------------------------------------------------- */

    public Studente studenteToEntity(StudenteDTO studente)
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

        return studenteEntity;
    }

    public List<Studente> studenteToEntities(List<StudenteDTO> studenti)
    {
        List<Studente> studentiEntity = new ArrayList<>();

        for(StudenteDTO studente : studenti)
        {
           studentiEntity.add( studenteToEntity(studente) );
        }

        return studentiEntity;
    }

}