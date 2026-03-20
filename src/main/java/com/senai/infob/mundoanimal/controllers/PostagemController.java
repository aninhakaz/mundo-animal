package com.senai.infob.mundoanimal.controllers;

import com.senai.infob.mundoanimal.services.PostagemService;
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



@RestController
@RequestMapping("/postagem")
public class PostagemController {
    
    
    private final PostagemService postagemService;

    PostagemController(PostagemService postagemService) {
        this.postagemService = postagemService;
    }

    @PostMapping("/salvar")
    public Postagem salvar(@RequestBody Postagem postagem) {
        return postagemService.salvar(postagem);
    }

    @DeleteMapping("/delete/{id}")
    public String deletar(@PathVariable Integer id) {
        boolean deletou = postagemService.deletar(id);
        if (deletou) {
            return "=Removido com sucesso";
    }
    return "Falha ao remover";
    }

}