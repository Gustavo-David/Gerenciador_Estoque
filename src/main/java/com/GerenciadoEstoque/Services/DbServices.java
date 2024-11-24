package com.GerenciadoEstoque.Services;

import java.sql.Connection;

import org.springframework.stereotype.Service;

import com.GerenciadoEstoque.DB.DbConnection;

@Service
public class DbServices {

    public boolean isDatabaseConnected() {
        try (Connection connection = DbConnection.getConnection()) {
            return connection != null && !connection.isClosed();
        } catch (Exception e) {
            return false; // Conexão falhou
        }
    }
}
