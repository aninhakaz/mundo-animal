package com.senai.infob.mundoanimal.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.infob.mundoanimal.models.Doacao;
import com.senai.infob.mundoanimal.services.DoacaoService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/doacao")
public class DoacaoController {
    @Autowired
    private DoacaoService doacaoService;

    @GetMapping("/count")
    public Long count() {
        return doacaoService.count();
    }
    
    @PostMapping("/salvar")
    public Doacao salvar(Doacao doacao){
        return doacaoService.salvar(doacao);
    }

    @DeleteMapping("/delete/{id}")
    public String deletar(@PathVariable Integer id){
       boolean deletou = doacaoService.delete(id);
       if(deletou){
            return "Usuário removido com sucesso";
       }
       return "Falha ao remover o usuário";
    }

    
    @GetMapping("/busca/{id}")
    public Doacao busca(@PathVariable Integer id) {
        return doacaoService.busca(id);
    }

    @GetMapping("/lista")
    public List<Doacao> lista() {
        return doacaoService.lista();
    }

    @PutMapping("/atualizar/{id}")
    public Doacao atualizar(@PathVariable Integer id,@RequestBody Doacao doacao) {
        return doacaoService.atualizar(doacao, id);
    }

}