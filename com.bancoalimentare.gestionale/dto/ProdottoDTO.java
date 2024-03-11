package com.bancoalimentare.gestionale.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProdottoDTO
{

    private Long id;
    private String lotto;
    private String nome;
    private LocalDate dataScadenza;
    private Integer quantita;

}