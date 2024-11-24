package com.GerenciadoEstoque.Services;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GerenciadoEstoque.Entities.Products;
import com.GerenciadoEstoque.Entities.StockMovement;
import com.GerenciadoEstoque.Repository.ProductsRepository;
import com.GerenciadoEstoque.Repository.StockMovementRepository;

@Service
public class StockMovementService {

    @Autowired
    private ProductsRepository productsRepository;

    @Autowired
    private StockMovementRepository stockMovementRepository;

    public void registerMovement(Long productId, Integer quantity, String movementType) {
        // Busca o produto pelo ID
        Products product = productsRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        // Atualiza a quantidade do estoque com base no tipo de movimento
        if (movementType.equals("Entrada")) {
            product.setQuantity(product.getQuantity() + quantity);
        } else if (movementType.equals("Saída")) {
            product.setQuantity(product.getQuantity() - quantity);
        }

        // Salva a movimentação
        StockMovement movement = new StockMovement(new Date(), quantity, movementType, product);
        stockMovementRepository.save(movement);

        // Salva a atualização no produto
        productsRepository.save(product);

        // Verifica se o estoque está abaixo do mínimo
        if (product.getQuantity() < 10) {
            // Alerta de baixo estoque
            System.out.println("ALERTA: O estoque de " + product.getName() + " está abaixo do mínimo.");
        }
    }
}
