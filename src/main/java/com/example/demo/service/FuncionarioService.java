package com.example.demo.service;

import com.example.demo.model.Funcionario;
import com.example.demo.model.Permissao;
import com.example.demo.repository.FuncionarioRepository;
import com.example.demo.repository.PermissaoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class FuncionarioService {
    @Autowired
    FuncionarioRepository professorRepository;
    @Autowired
    PermissaoRepository permissaoRepository;

    public FuncionarioService() {
    }

    public void create(Funcionario funcionario) {
        this.professorRepository.save(funcionario);
    }

    public List<Permissao> getPermissoesByProfessorId(Long funcionarioId) {
        return this.permissaoRepository.findByProfessorId(funcionarioId);
    }
}
