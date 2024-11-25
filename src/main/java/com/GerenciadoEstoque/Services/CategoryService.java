package com.GerenciadoEstoque.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GerenciadoEstoque.Entities.ProductsCategory;  // Importando sua classe ProductsCategory
import com.GerenciadoEstoque.Repository.CategoryRepository;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    // Método para salvar uma nova categoria de produto
    public ProductsCategory saveCategory(ProductsCategory category) {
        return categoryRepository.save(category);
    }

    // Método para atualizar uma categoria de produto existente
    public ProductsCategory updateCategory(ProductsCategory category) {
        return categoryRepository.save(category);
    }

    // Método para excluir uma categoria pelo id
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }

    // Método para listar todas as categorias ou filtrar pelo nome
    public List<ProductsCategory> listCategories(String name) {
        if (name != null) {
            return categoryRepository.findByName(name);
        }
        return categoryRepository.findAll();
    }
}
