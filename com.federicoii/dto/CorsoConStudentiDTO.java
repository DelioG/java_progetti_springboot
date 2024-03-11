package universita.federicoii.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import universita.federicoii.entity.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CorsoConStudentiDTO
{
    private Long id;
    private String ramoAppartenenza;
    private String nome;
    private Integer numeroStudenti;
    private Docente docente;
    private List<StudenteDTO> studenti;
}