package com.bancoalimentare.gestionale.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Table (name = "distribuzioni")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Distribuzione
{

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (unique = true, name = "id", updatable = false)
    private Long id;

    @NotNull
    @Column (name = "data_distribuzione")
    LocalDate dataDistribuzione;

    // Many To Many distribuzioni - famiglie
    // Ogni famiglia può avere più distribuzioni, ed ogni distribuzione può possedere più famiglie.
    @ManyToMany
    @JoinTable
            (
                name               = "distribuzione_famiglia",
                joinColumns        = @JoinColumn (name = "id_distribuzione"),
                inverseJoinColumns = @JoinColumn (name = "id_famiglia")
            )
    private List<Famiglia> famiglie;

    // Many To Many prodotti - distribuzioni
    // Ogni distribuzione può avere più prodotti distribuiti, ed ogni prodotto può appartenere a più distribuzioni.
    @ManyToMany (mappedBy = "distribuzioni")
    private List<Prodotto> prodotti;

}