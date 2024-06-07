package com.example.demo.service;

import com.example.demo.model.Funcionario;
import com.example.demo.model.Permissao;
import com.example.demo.repository.PermissaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PermissaoService {
    @Autowired
    PermissaoRepository permissaoRepository;

    public PermissaoService() {
    }

    public Permissao savePermissao(Permissao permissao) {
        return (Permissao)this.permissaoRepository.save(permissao);
    }

    public Permissao grantAccessToAll(Funcionario funcionario) {
        Permissao permissao = new Permissao();
        permissao.setLocal("ALL");
        permissao.setFuncionario(funcionario);
        return (Permissao)this.permissaoRepository.save(permissao);
    }
}
