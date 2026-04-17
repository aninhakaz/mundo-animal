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

import com.senai.infob.mundoanimal.models.Endereco;
import com.senai.infob.mundoanimal.services.EnderecoService;

@RestController
@RequestMapping("/Endereco")
public class EnderecoController {
    @Autowired
    private EnderecoService enderecoService;

    @GetMapping("/count")
    public Long count() {
        return enderecoService.count();
    }
    
    @PostMapping("/salvar")
    public Endereco salvar(Endereco endereco){
        return enderecoService.salvar(endereco);
    }

    @DeleteMapping("/delete/{id}")
    public String deletar(@PathVariable Integer id){
       boolean deletou = enderecoService.delete(id);
       if(deletou){
            return "Usuário removido com sucesso";
       }
       return "Falha ao remover o usuário";
    }

    
    @GetMapping("/busca/{id}")
    public Endereco busca(@PathVariable Integer id) {
        return enderecoService.busca(id);
    }

    @GetMapping("/lista")
    public List<Endereco> lista() {
        return enderecoService.lista();
    }

    @PutMapping("/atualizar/{id}")
    public Endereco atualizar(@PathVariable Integer id,@RequestBody Endereco endereco) {
        return enderecoService.atualizar(endereco, id);
    }

}