package universita.federicoii.entity;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "docente")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Docente
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (unique = true, name = "id", nullable = false, updatable = false)
    private Long id;

    @Column (name = "nome")
    private String nome;

    @Column (name = "cognome")
    private String cognome;

    @Column (unique = true, name = "codice_fiscale")
    private String codiceFiscale;

    @Column (unique = true, name = "matricola")
    private String matricola;

    @OneToOne (mappedBy = "docente")
    private Corso corso;
}