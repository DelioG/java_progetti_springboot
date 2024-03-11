package com.bancoalimentare.gestionale.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Table (name = "prodotti")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Prodotto
{

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (unique = true, name = "id", updatable = false)
    private Long id;

    @NotNull
    @Column (name = "lotto", unique = true)
    private String lotto;

    @NotNull
    @Column (name = "nome")
    private String nome;

    @NotNull
    @Column (name = "data_scadenza")
    LocalDate dataScadenza;

    @NotNull
    @Column (name = "quantita", columnDefinition = "integer default 0")
    private Integer quantita;

    // Many To Many prodotti - distribuzioni
    // Ogni distribuzione può avere più prodotti distribuiti, ed ogni prodotto può appartenere a più distribuzioni.
    @ManyToMany
    @JoinTable
            (
                name               = "prodotto_distribuzione",
                joinColumns        = @JoinColumn (name = "id_prodotto"),
                inverseJoinColumns = @JoinColumn (name = "id_distribuzione")
            )
    private List<Distribuzione> distribuzioni;

}