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
public class DistribuzioneDTO
{

    private Long id;
    private LocalDate dataDistribuzione;

}