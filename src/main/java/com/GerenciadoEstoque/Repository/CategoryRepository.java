package com.GerenciadoEstoque.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.GerenciadoEstoque.Entities.ProductsCategory;  // Importando a classe ProductsCategory

@Repository
public interface CategoryRepository extends JpaRepository<ProductsCategory, Long> {

    // Método para buscar categorias pelo nome, ignorando maiúsculas e minúsculas
    List<ProductsCategory> findByName(String name);
    
}
