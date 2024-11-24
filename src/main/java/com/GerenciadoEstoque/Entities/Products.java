package com.GerenciadoEstoque.Entities;

import java.io.Serializable;

import com.GerenciadoEstoque.EntitiesStatus.ProductsCategory;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Products implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Integer quantity;
    private Double buyPrice;
    private Double shellPrive;
    private ProductsCategory category;

    public Products() {

    }

    public Products(String name, String description, Integer quantity, Double buyPrice, Double shellPrive, ProductsCategory category) {
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.buyPrice = buyPrice;
        this.shellPrive = shellPrive;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(Double buyPrice) {
        this.buyPrice = buyPrice;
    }

    public Double getShellPrive() {
        return shellPrive;
    }

    public void setShellPrive(Double shellPrive) {
        this.shellPrive = shellPrive;
    }

    public ProductsCategory getCategory() {
        return category;
    }

    public void setCategory(ProductsCategory category) {
        this.category = category;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Products other = (Products) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Products [id=" + id + ", name=" + name + ", description=" + description + ", quantity=" + quantity + ", buyPrice=" + buyPrice + ", shellPrive=" + shellPrive + ", category=" + category + "]";
    }
    

}
