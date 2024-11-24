package com.GerenciadoEstoque.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.GerenciadoEstoque.Entities.Products;

@Repository
public interface ProductsRepository extends JpaRepository<Products, Long> {
    List<Products> findByNameContainingIgnoreCase(String name);
    List<Products> findByCategoryName(String categoryName);
    List<Products> findByStockQuantityLessThan(int quantity);
}
