package com.GerenciadoEstoque.Services;

import java.sql.Connection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GerenciadoEstoque.DB.DbConnection;

@Service
public class DbServices {
    
    @Autowired
    Connection conn = DbConnection.getConnection();

    public boolean checkConnection() {

        if (conn == null) {
            System.out.println("Não Conectado!");
            return false;
        } else {
            System.out.println("Conectado!");
            return true;
        }
    }
}
