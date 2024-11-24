package com.GerenciadoEstoque.DTO;
import java.math.BigDecimal;

public class SalesReport {
    private String productName;
    private BigDecimal profit;

    // Construtor
    public SalesReport(String productName, BigDecimal profit) {
        this.productName = productName;
        this.profit = profit;
    }

    // Getters e Setters
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getProfit() {
        return profit;
    }

    public void setProfit(BigDecimal profit) {
        this.profit = profit;
    }

    @Override
    public String toString() {
        return "SalesReport{" +
               "productName='" + productName + '\'' +
               ", profit=" + profit +
               '}';
    }
}
