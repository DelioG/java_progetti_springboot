package com.bancoalimentare.gestionale.repository;

import com.bancoalimentare.gestionale.entity.Prodotto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdottoRepository extends JpaRepository<Prodotto, Long>
{

}