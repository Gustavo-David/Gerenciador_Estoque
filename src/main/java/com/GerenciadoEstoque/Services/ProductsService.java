package com.GerenciadoEstoque.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GerenciadoEstoque.Entities.Products;
import com.GerenciadoEstoque.Repository.ProductsRepository;

@Service
public class ProductsService {

    @Autowired
    private ProductsRepository productsRepository;

    // Salvar ou atualizar um produto
    public Products saveOrUpdateProduct(Products product) {
        // Se o produto não tem ID, é um novo produto, se tem, está sendo atualizado
        return productsRepository.save(product);
    }

    // Deletar um produto pelo ID
    public void deleteProduct(Long id) {
        if (productsRepository.existsById(id)) {
            productsRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Produto não encontrado com o ID: " + id);
        }
    }

    // Listar produtos com filtros opcionais
    public List<Products> listProducts(String name, String categoryName, Integer quantity) {  // Alterado 'stockQuantity' para 'quantity'
        if (name != null && categoryName != null && quantity != null) {
            return productsRepository.findByNameContainingIgnoreCaseAndCategoryNameAndQuantityLessThan(
                    name, categoryName, quantity);  // Alterado 'stockQuantity' para 'quantity'
        }
        if (name != null && categoryName != null) {
            return productsRepository.findByNameContainingIgnoreCaseAndCategoryName(name, categoryName);
        }
        if (categoryName != null && quantity != null) {
            return productsRepository.findByCategoryNameAndQuantityLessThan(categoryName, quantity);  // Alterado 'stockQuantity' para 'quantity'
        }
        if (name != null) {
            return productsRepository.findByNameContainingIgnoreCase(name);
        }
        if (categoryName != null) {
            return productsRepository.findByCategoryName(categoryName);
        }
        if (quantity != null) {
            return productsRepository.findByQuantityLessThan(quantity);  // Alterado 'stockQuantity' para 'quantity'
        }
        return productsRepository.findAll();
    }

    // Cadastrar um produto junto com sua categoria
    public void cadastrarProdutoCategoria(String nomeProduto, String categoriaProduto, Double precoCompra, 
                                           Double precoVenda, Integer quantidade) {
        // Verifique ou crie a categoria, se necessário (lógica pode ser expandida)
        productsRepository.cadastrarProdutoCategoria(nomeProduto, categoriaProduto, precoCompra, precoVenda, quantidade);
    }
}
