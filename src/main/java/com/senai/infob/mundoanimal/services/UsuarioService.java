package com.senai.infob.mundoanimal.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.infob.mundoanimal.models.Usuario;
import com.senai.infob.mundoanimal.repositories.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario cadastrarUsuario(Usuario usuario, String confirmarSenha, String senha) {
        if (!senha.equals(confirmarSenha)) {
            return null;
        }

        usuarioRepository.save(usuario);
        return usuario;
    }
    public Usuario login(String email, String senha) {
        Usuario usuario = usuarioRepository.findByEmail(email);

        if (usuario == null) {
            System.out.println("Usuário não encontrado!");
            return null;
        }

        if (!usuario.getSenha().equals(senha)) {
            System.out.println("Senha incorreta!");
            return null;
        }

        return usuario;
    }

        public boolean atualizar(Usuario usuario, Integer id) {
        Usuario alu = usuarioRepository.findById(id).get();
        if (alu != null) {
            usuario .setId(id);
            usuarioRepository.save(usuario);
            return true;
        }
        return false;
    }

}