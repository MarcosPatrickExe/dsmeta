package com.devsuperior.dsmeta.services;

import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.repositories.SaleRepository;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 *git pu
 * @author Patrick
 */

@Service
public class SaleService {
    
      @Autowired
      private SaleRepository repository;
    
      // retorna uma lista completa com todas as vendas (ou 'sales')
      public List<Sale> findSales(){
            return this.repository.findAll();
      }
      
      
      //retorna uma lista limitada/paginada dos dados
      public Page<Sale> findAllSalesPageable ( Pageable pageable ){
              
          return this.repository.findAll(pageable);
      }
      
      
      public Page<Sale> findSalesPageableByDate (
              String minDate, 
                String maxDate, 
                  Pageable pageable){
          
            LocalDate today = LocalDate.ofInstant(
                      Instant.now(), 
                      ZoneId.systemDefault()
            );
          
          
            LocalDate min = maxDate.equals("") ? today.minusDays(365) : LocalDate.parse(minDate);
            LocalDate max = maxDate.equals("") ? today : LocalDate.parse(maxDate);
            
          
            return this.repository.findSalesByBetweenDates(min, max, pageable);
      }
}
