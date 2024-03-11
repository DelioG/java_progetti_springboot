package com.bancoalimentare.gestionale.repository;

import com.bancoalimentare.gestionale.entity.Zona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZonaRepository extends JpaRepository<Zona, Long>
{

}