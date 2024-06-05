package com.example.demo.controller;

import com.example.demo.model.Usuario;
import com.example.demo.service.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        Usuario usuario = usuarioService.findByUsername(username);
        if (usuario != null && usuarioService.validarSenha(usuario, password)) {
            return "Login bem-sucedido!";
        } else {
            return "Credenciais inválidas!";
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteByid(@PathVariable Long id) {
        usuarioService.deleteById(id);
    }

    @PutMapping("/{id}/redefinir-senha")
    public String redefinirSenha(@PathVariable Long id, @RequestParam String novaSenha) {
        Usuario usuario = usuarioService.findById(id).orElse(null);
        if (usuario != null) {
            usuarioService.redefinirSenha(usuario, novaSenha);
            return "Senha redefinida com sucesso!";
        } else {
            return "Usuário não encontrado!";
        }
    }
}
