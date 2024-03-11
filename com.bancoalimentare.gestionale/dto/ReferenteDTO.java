package com.bancoalimentare.gestionale.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReferenteDTO
{

    private Long id;
    private String nome;
    private String cognome;
    private String cellulare;

}