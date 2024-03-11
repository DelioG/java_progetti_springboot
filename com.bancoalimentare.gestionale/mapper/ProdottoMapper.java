package com.bancoalimentare.gestionale.mapper;

import com.bancoalimentare.gestionale.dto.ProdottoDTO;
import com.bancoalimentare.gestionale.entity.Prodotto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProdottoMapper
{

    /* ------------------------------------------------- */
    /*                        DTO                        */
    /* ------------------------------------------------- */

    public ProdottoDTO prodottoToDTO (Prodotto prodotto)
    {

        if( prodotto == null )
        {
            return new ProdottoDTO();
        }

        ProdottoDTO prodottoDTO = new ProdottoDTO();

        prodottoDTO.setId( prodotto.getId() );
        prodottoDTO.setLotto( prodotto.getLotto() );
        prodottoDTO.setNome( prodotto.getNome() );
        prodottoDTO.setDataScadenza( prodotto.getDataScadenza() );
        prodottoDTO.setQuantita( prodotto.getQuantita() );

        return prodottoDTO;
    }

    public List<ProdottoDTO> prodottiToDTOs (List<Prodotto> prodotti)
    {
        List<ProdottoDTO> prodottiDTO = new ArrayList<>();

        for ( Prodotto prodotto : prodotti )
        {
            prodottiDTO.add( prodottoToDTO(prodotto) );
        }

        return prodottiDTO;
    }

    /* ------------------------------------------------- */
    /*                       ENTITY                      */
    /* ------------------------------------------------- */

    public Prodotto prodottoToEntity (ProdottoDTO prodotto)
    {
        if(prodotto == null)
        {
            return new Prodotto();
        }

        Prodotto prodottoEntity = new Prodotto();

        prodottoEntity.setId( prodotto.getId() );
        prodottoEntity.setLotto( prodotto.getLotto() );
        prodottoEntity.setNome( prodotto.getNome() );
        prodottoEntity.setDataScadenza( prodotto.getDataScadenza() );
        prodottoEntity.setQuantita( prodotto.getQuantita() );

        return prodottoEntity;
    }

    public List<Prodotto> prodottiToEntities (List<ProdottoDTO> prodotti)
    {
        List<Prodotto> prodottiEntities = new ArrayList<>();

        for(ProdottoDTO prodotto : prodotti)
        {
            prodottiEntities.add( prodottoToEntity(prodotto) );
        }

        return prodottiEntities;
    }

}