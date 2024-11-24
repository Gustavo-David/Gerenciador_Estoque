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

import com.GerenciadoEstoque.Entities.ProductsCategory;
import com.GerenciadoEstoque.Services.CategoryService;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public ProductsCategory saveCategory(@RequestBody ProductsCategory category) {
        return categoryService.saveCategory(category);
    }

    @PutMapping
    public ProductsCategory updateCategory(@RequestBody ProductsCategory category) {
        return categoryService.updateCategory(category);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
    }

    @GetMapping
    public List<ProductsCategory> listCategories(@RequestParam(required = false) String name) {
        return categoryService.listCategories(name);
    }
}
