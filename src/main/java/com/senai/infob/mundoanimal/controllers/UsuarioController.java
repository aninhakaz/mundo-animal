package com.senai.infob.mundoanimal.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.senai.infob.mundoanimal.models.Usuario;
import com.senai.infob.mundoanimal.services.UsuarioService;




@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/count")
    public Long count() {
        return usuarioService.count();
    }
    
    @PostMapping("/login")
    public Usuario login(@RequestParam String email,@RequestParam String senha) {
        return usuarioService.login(email, senha);
    }

    @PostMapping("/cadastro")
   public Usuario cadastro(@RequestBody Usuario usuario, @RequestParam String confirmarSenha, @RequestParam String senha) {

            return usuarioService.cadastrarUsuario(usuario, confirmarSenha, senha);
   }
    

    @DeleteMapping("/delete/{id}")
    public String deletar(@PathVariable Integer id){
       boolean deletou = usuarioService.delete(id);
       if(deletou){
            return "Usuário removido com sucesso";
       }
       return "Falha ao remover o usuário";
    }

    @GetMapping("/busca/{id}")
    public Usuario busca(@PathVariable Integer id) {
        return usuarioService.busca(id);
    }

    @GetMapping("/lista")
    public List<Usuario> lista() {
        return usuarioService.lista();
    }

    @PutMapping("/atualizar/{id}")
    public Usuario atualizar(@PathVariable Integer id,@RequestBody Usuario usuario) {
        return usuarioService.atualizar(usuario, id);
    }

}