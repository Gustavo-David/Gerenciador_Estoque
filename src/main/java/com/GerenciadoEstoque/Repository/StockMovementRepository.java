package com.GerenciadoEstoque.Repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.GerenciadoEstoque.Entities.StockMovement;

// Repositório para a entidade StockMovement
@Repository
public interface StockMovementRepository extends JpaRepository<StockMovement, Long> {

    // Método para buscar todas as movimentações de um produto específico
    List<StockMovement> findByProductId(Long productId);

    // Método para buscar todas as movimentações de estoque de um tipo específico (Entrada ou Saída)
    List<StockMovement> findByMovementType(String movementType);

    // Método para buscar todas as movimentações de estoque dentro de um período específico
    List<StockMovement> findByDateBetween(Date startDate, Date endDate);

    // Você pode adicionar mais métodos conforme necessário, por exemplo, por tipo de movimento ou por data.
    
}
