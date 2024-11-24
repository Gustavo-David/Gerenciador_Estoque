package com.GerenciadoEstoque.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.GerenciadoEstoque.Entities.Products;
import com.GerenciadoEstoque.Services.ProductsService;

@RestController
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    private ProductsService productsService;

    // Salvar ou atualizar um produto
    @PostMapping
    public Products saveOrUpdateProduct(@RequestBody Products product) {
        return productsService.saveOrUpdateProduct(product);
    }

    // Deletar um produto
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productsService.deleteProduct(id);
    }

    // Listar produtos com filtros
    @GetMapping("/list")
    public List<Products> listProducts(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String categoryName,
            @RequestParam(required = false) Integer stockQuantity) {
        return productsService.listProducts(name, categoryName, stockQuantity);
    }

    // Cadastrar produto com categoria
    @PostMapping("/cadastrar")
    public void cadastrarProdutoCategoria(@RequestBody Products product) {
        productsService.cadastrarProdutoCategoria(
                product.getName(),
                product.getCategory().getName(),
                product.getBuyPrice(),
                product.getSellPrice(),
                product.getQuantity());
    }
}
