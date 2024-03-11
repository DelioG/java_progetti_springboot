package universita.federicoii.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import universita.federicoii.entity.*;

@Repository
public interface CorsoRepository extends JpaRepository<Corso, Long>
{
    @Query(value = "SELECT c.* FROM corso c WHERE c.nome = :nomeCorso", nativeQuery = true)
    Corso findCorsoByName(@Param("nomeCorso") String nome);
}

