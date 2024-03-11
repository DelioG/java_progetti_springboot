package com.bancoalimentare.gestionale.repository;

import com.bancoalimentare.gestionale.entity.Famiglia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FamigliaRepository extends JpaRepository<Famiglia, Long>
{

}