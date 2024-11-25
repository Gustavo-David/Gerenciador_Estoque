package com.GerenciadoEstoque.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.GerenciadoEstoque.Entities.Products;
import com.GerenciadoEstoque.Entities.ProductsCategory;
import com.GerenciadoEstoque.Repository.CategoryRepository;
import com.GerenciadoEstoque.Repository.ProductsRepository;
import com.GerenciadoEstoque.Services.ProductsService;

@RestController
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    private ProductsRepository productsRepository;

    @Autowired
    private CategoryRepository categoriaRepository;

    @GetMapping("/test")
    public String test() {
        return "Server is running!";
    }

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

    @PostMapping("/cadastrar")
public ResponseEntity<String> cadastrarProdutoCategoria(@RequestBody Products produto) {
    if (produto.getCategory() == null || produto.getCategory().getName() == null) {
        return ResponseEntity.badRequest().body("A categoria precisa ter um nome.");
    }

    if (produto.getBuyPrice() == null || produto.getSellPrice() == null) {
        return ResponseEntity.badRequest().body("O preço de compra e venda devem ser fornecidos.");
    }

    // Criação ou busca da categoria no banco de dados
    ProductsCategory categoria = produto.getCategory();
    
    // Buscar categoria pelo nome e verificar se existe
    List<ProductsCategory> categoriasExistentes = categoriaRepository.findByName(categoria.getName());
    
    // Se a lista de categorias existentes não for vazia, pega o primeiro elemento
    Optional<ProductsCategory> categoriaExistente = categoriasExistentes.stream().findFirst();
    
    if (categoriaExistente.isEmpty()) {
        categoriaRepository.save(categoria);
    } else {
        categoria = categoriaExistente.get(); // Atribui a categoria já existente
    }

    // Atribuindo categoria ao produto
    produto.setCategory(categoria);

    // Atribuindo preços de compra e venda ao produto
    produto.setBuyPrice(produto.getBuyPrice());
    produto.setSellPrice(produto.getSellPrice());

    // Salvando o produto no banco de dados
    productsRepository.save(produto);

    return ResponseEntity.ok("Produto e categoria cadastrados com sucesso!");
}

}
