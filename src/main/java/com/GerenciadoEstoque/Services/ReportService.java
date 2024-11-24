package com.GerenciadoEstoque.Services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GerenciadoEstoque.Entities.Products;
import com.GerenciadoEstoque.Entities.StockMovement;
import com.GerenciadoEstoque.Repository.ProductsRepository;
import com.GerenciadoEstoque.Repository.StockMovementRepository;

@Service
public class ReportService {

    @Autowired
    private ProductsRepository productsRepository;

    @Autowired
    private StockMovementRepository stockMovementRepository;

    // Relatório de Produtos Cadastrados
    public List<Products> generateProductReport() {
        return productsRepository.findAll();  // Retorna todos os produtos cadastrados
    }

    // Relatório de Movimentação de Estoque
    public List<StockMovement> generateStockMovementReport(Long productId) {
        return stockMovementRepository.findByProductId(productId);  // Retorna todas as movimentações de um produto específico
    }

    // Relatório de Movimentação de Estoque por Tipo (Entrada ou Saída)
    public List<StockMovement> generateStockMovementByTypeReport(String movementType) {
        return stockMovementRepository.findByMovementType(movementType);  // Retorna movimentações do tipo "Entrada" ou "Saída"
    }

    // Relatório de Movimentação de Estoque por Data (Intervalo)
    public List<StockMovement> generateStockMovementByDateReport(Date startDate, Date endDate) {
        return stockMovementRepository.findByDateBetween(startDate, endDate);  // Retorna movimentações em um intervalo de datas
    }

    // Relatório de Produtos com Estoque Baixo
    public List<Products> generateLowStockReport() {
        return productsRepository.findByQuantityLessThan(10);  // Exemplo de limite de estoque baixo (alterado 'stockQuantity' para 'quantity')
    }

    // Relatório de Vendas e Lucro (baseado no preço de venda e compra)
    public List<String> generateSalesAndProfitReport() {
        List<String> report = new ArrayList<>();
        
        List<Products> products = productsRepository.findAll();
        for (Products product : products) {
            // Verifique se todos os valores são válidos antes de calcular o lucro
            if (product.getSellPrice() != null && product.getBuyPrice() != null && product.getQuantity() != null) {
                // Cálculo do lucro
                double profit = (product.getSellPrice() - product.getBuyPrice()) * product.getQuantity();
                report.add("Produto: " + product.getName() + " - Lucro: " + profit);
            } else {
                // Caso algum valor esteja ausente ou inválido, adicione uma mensagem de erro
                report.add("Produto: " + product.getName() + " - Dados incompletos para calcular lucro.");
            }
        }

        return report;
    }
}
