package com.bancoalimentare.gestionale.repository;

import com.bancoalimentare.gestionale.entity.Referente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReferenteRepository extends JpaRepository<Referente, Long>
{

}