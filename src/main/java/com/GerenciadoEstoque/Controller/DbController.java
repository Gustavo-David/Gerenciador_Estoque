package com.GerenciadoEstoque.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.GerenciadoEstoque.Services.DbServices;

@ComponentScan
@RestController
public class DbController {

    @Autowired
    private DbServices dbServices;

    @GetMapping("/db-status") // Mapeamento para GET na URL /db-status
    public String getDatabaseStatus() {
        boolean isConnected = dbServices.isDatabaseConnected();
        return isConnected ? "Conexão com o banco de dados bem-sucedida." : "Erro ao conectar com o banco de dados.";
    }
}
