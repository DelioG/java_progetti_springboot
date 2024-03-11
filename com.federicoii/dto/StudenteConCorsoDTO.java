package universita.federicoii.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudenteConCorsoDTO
{
    private Long id;
    private String nome;
    private String cognome;
    private String codiceFiscale;
    private String matricola;
    private CorsoDTO corso;
}