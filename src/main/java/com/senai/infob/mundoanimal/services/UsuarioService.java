package com.senai.infob.mundoanimal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.infob.mundoanimal.models.Usuario;
import com.senai.infob.mundoanimal.repositories.UsuarioRepository;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Long count(){
        return usuarioRepository.count();
    }

    //public Usuario salvar(Usuario usuario) {
        //return usuarioRepository.save(usuario);
    //}
    public Usuario salvar(Usuario usuario, String confirmarsenha, String senha) {
        return usuarioRepository.save(usuario);
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

    public Usuario cadastrarUsuario(Usuario usuario, String confirmarSenha, String senha) {
        if (!senha.equals(confirmarSenha)) {
            return null;
        }

        usuarioRepository.save(usuario);
        return usuario;
    }
    
    public boolean delete(Integer id){
        Usuario usuario = usuarioRepository.findById(id).get();
        if (usuario != null) {
            usuarioRepository.deleteById(id);
            return true;
        }
        return false;
    }

     public Usuario busca(Integer id) {
        return usuarioRepository.findById(id).get();
    }

    public List<Usuario> lista() {
        return usuarioRepository.findAll();
    }


    public Usuario atualizar(Usuario usuario, Integer id){
        Usuario e = busca(id);
        if (e != null) {
            usuario.setId(id);
            return usuarioRepository.save(usuario);
        }
        return null;
    }

    public void atualizarFotoPerfil(Integer usuarioId, String urlFoto) { 
        Usuario usuario = usuarioRepository.findById(usuarioId) 
            .orElseThrow(() -> new RuntimeException("Usuário não encontrado")); 

 
        usuario.setImagem(urlFoto); 
        usuarioRepository.save(usuario); 

} 

 
}