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

import com.senai.infob.mundoanimal.services.ServicosService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

import com.senai.infob.mundoanimal.models.Servicos;

@RestController
@RequestMapping("/servicos")
public class ServicosController {
    @Autowired
    private ServicosService servicosService;

    @GetMapping("/count")
    public Long count() {
        return servicosService.count();
    }
    
    @PostMapping("/salvar")
    public Servicos salvar(Servicos servicos){
        return servicosService.salvar(servicos);
    }

    @DeleteMapping("/delete/{id}")
    public String deletar(@PathVariable Integer id){
       boolean deletou = servicosService.delete(id);
       if(deletou){
            return "Usuário removido com sucesso";
       }
       return "Falha ao remover o usuário";
    }

    @GetMapping("/busca/{id}")
    public Servicos busca(@PathVariable Integer id) {
        return servicosService.busca(id);
    }

    @GetMapping("/lista")
    public List<Servicos> lista() {
        return servicosService.lista();
    }

    @PutMapping("/atualizar/{id}")
    public Servicos atualizar(@PathVariable Integer id,@RequestBody Servicos servicos) {
        return servicosService.atualizar(servicos, id);
    }

}
