package com.devsuperior.dsmeta.repositories;
import com.devsuperior.dsmeta.entities.Sale;
import java.time.LocalDate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author Patrick
 */

public interface SaleRepository extends JpaRepository<Sale, Long> {
    
    // UTILIZANDO 'JPQL' LINGUAGEM EQUIVALENTE AO 'SQL', POREM ADAPTADO PARA O JPA
    // DEFININDO UMA QUERY PERSONALIZADA QUE IRÁ BUSCAR TODOS OS 'obj'(OBJETOS) DO TIPO 'Sale' QUE 
    // TENHAM A DATA DE SUAS VENDAS ENTRE AS DATA MIN E MAX PASSADAS, TUDO ORDENADO PELO VALOR DECRESCENTE 
    // DO VALOR DA VENDA
    @Query("SELECT s FROM Sale s WHERE s.date BETWEEN :minDate AND :maxDate ORDER BY s.amount DESC")
            
    Page<Sale> findSalesByBetweenDates( //METODO PERSONALIZADO QUE IRA BUSCAR SOMENTE AS VENDAS ENTRE AS DEFINIDAS DATAS
            LocalDate minDate, 
                LocalDate maxDate, 
                   Pageable pageable
    );
}
