package universita.federicoii.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CorsoConDocenteDTO
{
    private Long id;
    private String ramoAppartenenza;
    private String nome;
    private Integer numeroStudenti;
    private DocenteDTO docente;
}