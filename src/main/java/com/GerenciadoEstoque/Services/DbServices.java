package com.GerenciadoEstoque.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Component
public class DbServices {
    
    @Autowired
    private DataSource dataSource;

    public boolean isDatabaseConnected() {
        try (Connection connection = dataSource.getConnection()) {
            return connection.isValid(2); // Verifica a conexão com timeout de 2 segundos
        } catch (SQLException e) {
            return false; // Conexão falhou
        }
    }
}
