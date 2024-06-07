
package com.example.demo.controller;

import com.example.demo.model.Funcionario;
import com.example.demo.model.Permissao;
import com.example.demo.service.FuncionarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/funcionario"})
public class FuncionarioController {
    @Autowired
    FuncionarioService funcionarioService;

    public FuncionarioController() {
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Funcionario funcionario) {
        this.funcionarioService.create(funcionario);
    }

    @GetMapping({"/{id}/permissoes"})
    public List<Permissao> getPermissoes(@PathVariable Long id) {
        return this.funcionarioService.getPermissoesByProfessorId(id);
    }
}