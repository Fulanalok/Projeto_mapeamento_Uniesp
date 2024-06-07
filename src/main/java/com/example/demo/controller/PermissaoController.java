package com.example.demo.controller;

import com.example.demo.model.Funcionario;
import com.example.demo.model.Permissao;
import com.example.demo.service.PermissaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/permissoes"})
public class PermissaoController {
    @Autowired
    PermissaoService permissaoService;

    public PermissaoController() {
    }

    @PostMapping
    public Permissao createPermissao(@RequestBody Permissao permissao) {
        return this.permissaoService.savePermissao(permissao);
    }

    @PostMapping({"/grantAccessAll"})
    public Permissao grantAccessToAll(@RequestBody Funcionario funcionario) {
        return this.permissaoService.grantAccessToAll(funcionario);
    }
}