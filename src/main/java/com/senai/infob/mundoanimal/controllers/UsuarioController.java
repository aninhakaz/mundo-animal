package com.senai.infob.mundoanimal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.senai.infob.mundoanimal.models.Usuario;
import com.senai.infob.mundoanimal.services.UsuarioService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    public UsuarioService usuarioService;

    @PostMapping("/login")
    public Usuario login(@RequestParam String email, @RequestParam String senha) {
        return usuarioService.login(email,senha);
    }
@PostMapping("/cadastro")
    public Usuario cadastro(@RequestBody Usuario usuario,@RequestParam String confirmarSenha, @RequestParam String senha) {
        return usuarioService.cadastrarUsuario(usuario, confirmarSenha, senha);
}

    @PutMapping("/atualizar/{id}")
    public Usuario atualizar(@PathVariable Integer id, @RequestBody Usuario usuario) {
        if(usuarioService.atualizar(usuario, id)) {
            return usuario;
        }
        return null;
    }
}