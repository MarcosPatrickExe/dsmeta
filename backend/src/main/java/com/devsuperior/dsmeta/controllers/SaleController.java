package com.devsuperior.dsmeta.controllers;
import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.services.SaleService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/*
 * @author Patrick
 */

@RestController
@RequestMapping(value="/sales")
public class SaleController {
    
    @Autowired
    private SaleService service;
    
  //  @GetMapping// permite q o metodo responda va web usando http 
    @GetMapping("/salesList")
    public List<Sale> findSales() {
        
             return this.service.findSales();
    }
   
    
    @GetMapping("/allSalesPage")
    public Page<Sale> findAllSalesPageable (
          Pageable pageable
        ) {
    
             return this.service.findAllSalesPageable(pageable);
    }
    
    
    
    @GetMapping("/salesPage")
    public Page<Sale> findSalesWithPages(
        @RequestParam(value="minDate", defaultValue="") String minDate, //obtendo 'minDate' através do parâmetro 'minDate' da URL
        @RequestParam(value="maxDate", defaultValue="") String maxDate,
        Pageable pageable//Esse parametro eh iniciado de forma automatica pelo proprio framework
        ) {
        
             return this.service.findSalesPageableByDate( minDate, maxDate, pageable);
    }
}
