package com.GerenciadoEstoque.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GerenciadoEstoque.Entities.Products;
import com.GerenciadoEstoque.Entities.ProductsCategory;
import com.GerenciadoEstoque.Repository.CategoryRepository;
import com.GerenciadoEstoque.Repository.ProductsRepository;

@Service
public class ProductsService {

    @Autowired
    private ProductsRepository productsRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    // Salvar ou atualizar um produto
    public Products saveOrUpdateProduct(Products product) {
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
    public List<Products> listProducts(String name, String categoryName, Integer quantity) {
        if (name != null && categoryName != null && quantity != null) {
            return productsRepository.findByNameContainingIgnoreCaseAndCategoryNameAndQuantityLessThan(
                    name, categoryName, quantity);
        }
        if (name != null && categoryName != null) {
            return productsRepository.findByNameContainingIgnoreCaseAndCategoryName(name, categoryName);
        }
        if (categoryName != null && quantity != null) {
            return productsRepository.findByCategoryNameAndQuantityLessThan(categoryName, quantity);
        }
        if (name != null) {
            return productsRepository.findByNameContainingIgnoreCase(name);
        }
        if (categoryName != null) {
            return productsRepository.findByCategoryName(categoryName);
        }
        if (quantity != null) {
            return productsRepository.findByQuantityLessThan(quantity);
        }
        return productsRepository.findAll();
    }

    // Cadastrar um produto junto com sua categoria
    public Products cadastrarProdutoCategoria(String nomeProduto, String categoriaProduto, Double precoCompra,
            Double precoVenda, Integer quantidade) {
        // Verifica se a categoria já existe
        ProductsCategory categoria = categoryRepository.findByName(categoriaProduto).stream()
                .findFirst() // Obtém o primeiro elemento da lista, se existir
                .orElseGet(() -> {
                    // Cria a categoria caso não exista
                    ProductsCategory novaCategoria = new ProductsCategory();
                    novaCategoria.setName(categoriaProduto);
                    return categoryRepository.save(novaCategoria);
                });

        // Cria o produto
        Products produto = new Products();
        produto.setName(nomeProduto);
        produto.setCategory(categoria);
        produto.setBuyPrice(precoCompra);
        produto.setSellPrice(precoVenda);
        produto.setQuantity(quantidade);

        // Salva o produto
        return productsRepository.save(produto);
    }
}
