package com.devsuperior.dsmeta.repositories;
import com.devsuperior.dsmeta.entities.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Patrick
 */

public interface SaleRepository extends JpaRepository<Sale, Long> {
    
}
