package com.bancoalimentare.gestionale.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bancoalimentare.gestionale.entity.Distribuzione;
import org.springframework.stereotype.Repository;

@Repository
public interface DistribuzioneRepository extends JpaRepository<Distribuzione, Long>
{

}