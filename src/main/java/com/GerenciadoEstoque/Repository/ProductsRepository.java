package com.GerenciadoEstoque.Repository;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import com.GerenciadoEstoque.Entities.Products;

@Repository
public interface ProductsRepository extends JpaRepository<Products, Long> {

    // Buscar produtos com base no nome e adicionar paginação
    Page<Products> findByNameContainingIgnoreCase(String name, Pageable pageable);

    // Buscar produtos por categoria e adicionar paginação
    Page<Products> findByCategoryName(String categoryName, Pageable pageable);

    // Buscar produtos com quantidade de estoque abaixo de um valor e adicionar
    // paginação
    Page<Products> findByQuantityLessThan(int quantity, Pageable pageable); // Alterado para 'quantity'

    List<Products> findByNameContainingIgnoreCaseAndCategoryNameAndQuantityLessThan(String name,
            String categoryName, int quantity); // Alterado para 'quantity'

    List<Products> findByNameContainingIgnoreCaseAndCategoryName(String name, String categoryName);

    List<Products> findByCategoryNameAndQuantityLessThan(String categoryName, int quantity); // Alterado para 'quantity'

    List<Products> findByNameContainingIgnoreCase(String name);

    List<Products> findByCategoryName(String categoryName);

    List<Products> findByQuantityLessThan(int quantity); // Alterado para 'quantity'

    List<Products> findByQuantityLessThan(Integer quantity); // Alterado para 'quantity'

    List<Products> findByCategoryNameAndQuantityLessThan(String categoryName, Integer quantity); // Alterado para 'quantity'

    List<Products> findByNameContainingIgnoreCaseAndCategoryNameAndQuantityLessThan(String name,
            String categoryName, Integer quantity); // Alterado para 'quantity'

    @Procedure(name = "CadastrarProdutoCategoria")
    void cadastrarProdutoCategoria(String nomeProduto, String categoriaProduto,
            Double precoCompra, Double precoVenda, Integer quantidade);
}
