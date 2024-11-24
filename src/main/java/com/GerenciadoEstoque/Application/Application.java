package com.GerenciadoEstoque.Application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EnableJpaRepositories(basePackages = "com.GerenciadoEstoque.Repository")
@SpringBootApplication(scanBasePackages = "com.GerenciadoEstoque")
@EntityScan("com.GerenciadoEstoque.Entities")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
