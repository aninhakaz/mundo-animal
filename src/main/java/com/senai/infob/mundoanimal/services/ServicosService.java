package com.senai.infob.mundoanimal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.senai.infob.mundoanimal.models.Servicos;
import com.senai.infob.mundoanimal.repositories.ServicosRepository;

public class ServicosService {
     @Autowired
    private ServicosRepository servicosRepository;

    public Long count(){
        return servicosRepository.count();
    }

     public Servicos salvar(Servicos servicos) {
        return servicosRepository.save(servicos);
    }

    
    public boolean delete(Integer id){
        Servicos servicos = servicosRepository.findById(id).get();
        if (servicos != null) {
            servicosRepository.deleteById(id);
            return true;
        }
        return false;
    }

     public Servicos busca(Integer id) {
        return servicosRepository.findById(id).get();
    }

    public List<Servicos> lista() {
        return servicosRepository.findAll();
    }


    public Servicos atualizar(Servicos servicos, Integer id){
        Servicos e = busca(id);
        if (e != null) {
            servicos.setId(id);
            return servicosRepository.save(servicos);
        }
        return null;
    }
}
