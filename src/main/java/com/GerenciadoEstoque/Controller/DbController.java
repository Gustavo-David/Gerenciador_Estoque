package com.GerenciadoEstoque.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/status")
public class DbController {

    public String getStatus() {
        return "DbServices";
    }
}
