package com.example.demo.Controller;

import com.example.demo.Model.Usuario;
import com.example.demo.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
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

    @PostMapping("/recuperar-senha")
    public String recuperarSenha(@RequestParam String username, @RequestParam String email) {
        Usuario usuario = usuarioService.findByUsernameAndEmail(username, email);
        if (usuario != null) {
            // Aqui você implementaria a lógica para enviar um e-mail de recuperação de senha
            return "Um e-mail de recuperação de senha foi enviado para " + email;
        } else {
            return "Usuário não encontrado ou e-mail incorreto!";
        }
    }
}
