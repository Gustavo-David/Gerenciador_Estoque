package com.GerenciadoEstoque.Entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class ProductsCategory implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    @OneToMany(mappedBy = "category")
    private List<Products> products = new ArrayList<>();

    public ProductsCategory() {
    }

    public ProductsCategory(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<Products> getProducts() {
        return new ArrayList<>(products); // Retorna uma cópia da lista para evitar modificações externas
    }

    public void setProducts(List<Products> products) {
        this.products.clear();
        if (products != null) {
            this.products.addAll(products);
        }
    }

    @Override
    public int hashCode() {
        return 31 + ((id == null) ? 0 : id.hashCode()); // Use id como a única chave para hashCode
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        ProductsCategory other = (ProductsCategory) obj;
        return id != null && id.equals(other.id);
    }

    @Override
    public String toString() {
        return "ProductsCategory [id=" + id + ", name=" + name + ", description=" + description + "]";
    }
}