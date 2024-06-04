package com.example.demo.service;

import com.example.demo.model.Usuario;
import com.example.demo.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    

    public Usuario findByUsername(String username) {
        return usuarioRepository.findByUsername(username);
    }

    public boolean validarSenha(Usuario usuario, String senha) {
        return passwordEncoder.matches(senha, usuario.getPassword());
    }

    public Usuario findByUsernameAndEmail(String username, String email) {
        return usuarioRepository.findByUsernameAndEmail(username, email);
    }
    
    
    public void deleteById(Long id) {
    	usuarioRepository.deleteById(id);
    }
    
}
