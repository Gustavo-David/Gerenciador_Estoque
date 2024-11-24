package com.GerenciadoEstoque.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GerenciadoEstoque.Entities.Products;
import com.GerenciadoEstoque.Repository.ProductsRepository;

@Service
public class ProductsService {

    @Autowired
    private ProductsRepository ProductsRepository;

    public Products saveProducts(Products Products) {
        return ProductsRepository.save(Products);
    }

    public Products updateProducts(Products Products) {
        return ProductsRepository.save(Products);
    }

    public void deleteProducts(Long id) {
        ProductsRepository.deleteById(id);
    }

    public List<Products> listProductss(String name, String categoryName, Integer stockQuantity) {
        if (name != null) {
            return ProductsRepository.findByNameContainingIgnoreCase(name);
        } else if (categoryName != null) {
            return ProductsRepository.findByCategoryName(categoryName);
        } else if (stockQuantity != null) {
            return ProductsRepository.findByStockQuantityLessThan(stockQuantity);
        }
        return ProductsRepository.findAll();
    }
}
