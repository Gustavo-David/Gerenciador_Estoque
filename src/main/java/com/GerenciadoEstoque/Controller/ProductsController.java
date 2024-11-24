package com.GerenciadoEstoque.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.GerenciadoEstoque.Entities.Products;
import com.GerenciadoEstoque.Entities.ProductsException;
import com.GerenciadoEstoque.Repository.ProductsRepository;
import com.GerenciadoEstoque.Services.ProductsService;

@RestController
@RequestMapping("/Productss")
public class ProductsController {

    @Autowired
    private ProductsRepository productsRepository;

    @Autowired
    private ProductsService ProductsService;

    @PostMapping
    public Products saveProducts(@RequestBody Products Products) {
        return ProductsService.saveProducts(Products);
    }

    @PutMapping("/{id}")
    public Products updateProduct(@PathVariable Long id, @RequestBody Products product) {
        // Busque o produto pelo ID
        Products existingProduct = productsRepository.findById(id)
                .orElseThrow(() -> new ProductsException("Product not found with ID: " + id));

        // Atualize os campos permitidos
        existingProduct.setName(product.getName());
        existingProduct.setDescription(product.getDescription());
        existingProduct.setQuantity(product.getQuantity());
        existingProduct.setBuyPrice(product.getBuyPrice()); 
        existingProduct.setSellPrice(product.getSellPrice());
        existingProduct.setCategory(product.getCategory());

        // Salve as mudanças
        return productsRepository.save(existingProduct);
    }

    @DeleteMapping("/{id}")
    public void deleteProducts(@PathVariable Long id) {
        ProductsService.deleteProducts(id);
    }

    @GetMapping
    public List<Products> listProductss(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String category,
            @RequestParam(required = false) Integer Quantity) {
        return ProductsService.listProductss(name, category, Quantity);
    }
}
