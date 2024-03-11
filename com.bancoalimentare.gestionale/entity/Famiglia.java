package com.bancoalimentare.gestionale.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Table (name = "famiglie")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Famiglia
{

    @Id
    @NotNull
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (unique = true, name = "id", updatable = false)
    private Long id;

    @NotNull
    @Column (name = "numComponenti", columnDefinition = "integer default 0")
    private Integer numComponenti;

    @Column (name = "note")
    private String note;

    @ManyToOne  (cascade = CascadeType.ALL)
    private Zona zona;

    @OneToOne   (cascade = CascadeType.ALL)
    @JoinColumn (name = "id_referente", referencedColumnName = "id")
    private Referente referente;

    // Many To Many distribuzioni - famiglie
    // Ogni famiglia può avere più distribuzioni, ed ogni distribuzione può possedere più famiglie.
    @ManyToMany (mappedBy = "famiglie")
    private List<Distribuzione> distribuzioni;

}