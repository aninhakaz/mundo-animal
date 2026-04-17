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

     public Usuario salvar(Usuario usuario) {
        return usuarioRepository.save(usuario);
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
}