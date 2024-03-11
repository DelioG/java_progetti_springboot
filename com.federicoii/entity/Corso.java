package universita.federicoii.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Table(name = "corso")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Corso
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (unique = true, name = "id", nullable = false, updatable = false)
    private Long id;

    @Column (name = "ramo_appartenenza")
    private String ramoAppartenenza;

    @Column (unique = true, name = "nome")
    private String nome;

    @Column (name = "numero_studenti", columnDefinition = "integer default 0")
    private Integer numeroStudenti;

    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn (name = "id_docente", referencedColumnName = "id")
    private Docente docente;

    @OneToMany (mappedBy = "corso", cascade = CascadeType.ALL)
    private List<Studente> studenti;

    // @PrePersist //valore di default per java
    // public void prePersist()
    // {
    //    if (numeroStudenti == null)
    //    {
    //        numeroStudenti = 0;
    //    }
    // }
}