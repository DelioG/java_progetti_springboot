package com.bancoalimentare.gestionale.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Table (name = "zone")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Zona
{

    @Id
    @NotNull
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "id", unique = true, updatable = false)
    private Long id;

    @NotNull
    @Column (name = "nome", unique = true)
    private String nome;

    @OneToMany (mappedBy = "zona", cascade = CascadeType.ALL)
    private List<Famiglia> famiglie;

}