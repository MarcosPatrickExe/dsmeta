package com.devsuperior.dsmeta.entities;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Patrick
 */

@Entity
@Table(name="tb_sales")
public class Sale {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
    private String sellerName; //nome vendedor
    private Integer visited; //visitas
    private Integer deals; //vendas
    private Double amount; //total
    private LocalDate date; //data
    
    public Sale(){}

    public Long getID() {
        return ID;
    }

    public String getSellerName() {
        return sellerName;
    }

    public Integer getVisited() {
        return visited;
    }

    public Integer getDeals() {
        return deals;
    }

    public Double getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public void setVisited(Integer visiteds) {
        this.visited = visiteds;
    }

    public void setDeals(Integer deals) {
        this.deals = deals;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
    
    
}
