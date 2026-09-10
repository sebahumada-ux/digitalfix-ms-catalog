package cl.duoc.digitalfix.catalog.repository;

import cl.duoc.digitalfix.catalog.model.ServicioCatalogo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicioCatalogoRepository
        extends JpaRepository<ServicioCatalogo, Long> {
}