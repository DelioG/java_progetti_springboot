package universita.federicoii.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import universita.federicoii.entity.*;

@Repository
public interface DocenteRepository extends JpaRepository<Docente, Long>
{
    Docente findDocenteByCodiceFiscale(String codiceFiscale);
}