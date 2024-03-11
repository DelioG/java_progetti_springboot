package com.bancoalimentare.gestionale.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table (name = "referenti")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Referente
{

    @Id
    @NotNull
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "id", unique = true, updatable = false)
    private Long id;

    @Column (name = "nome")
    private String nome;

    @Column (name = "cognome")
    private String cognome;

    @NotNull
    @Column (name = "cellulare", unique = true)
    @Pattern (regexp = "^\\d{10}$")
    private String cellulare;

    @OneToOne (mappedBy = "referente")
    private Famiglia famiglia;

}