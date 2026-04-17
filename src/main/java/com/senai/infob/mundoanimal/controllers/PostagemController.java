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
import org.springframework.web.bind.annotation.RestController;

import com.senai.infob.mundoanimal.models.Postagem;
import com.senai.infob.mundoanimal.services.PostagemService;



@RestController
@RequestMapping("/postagem")
public class PostagemController {
    @Autowired
    private PostagemService postagemService;

    @GetMapping("/count")
    public Long count() {
        return postagemService.count();
    }
    
    @PostMapping("/salvar")
    public Postagem salvar(Postagem postagem){
        return postagemService.salvar(postagem);
    }

    @DeleteMapping("/delete/{id}")
    public String deletar(@PathVariable Integer id){
       boolean deletou = postagemService.delete(id);
       if(deletou){
            return "Usuário removido com sucesso";
       }
       return "Falha ao remover o usuário";
    }

    @GetMapping("/busca/{id}")
    public Postagem busca(@PathVariable Integer id) {
        return postagemService.busca(id);
    }

    @GetMapping("/lista")
    public List<Postagem> lista() {
        return postagemService.lista();
    }

    @PutMapping("/atualizar/{id}")
    public Postagem atualizar(@PathVariable Integer id,@RequestBody Postagem postagem) {
        return postagemService.atualizar(postagem, id);
    }

}