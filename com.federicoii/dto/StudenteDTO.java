package universita.federicoii.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudenteDTO
{
    private Long id;
    private String nome;
    private String cognome;
    private String codiceFiscale;
    private String matricola;
}