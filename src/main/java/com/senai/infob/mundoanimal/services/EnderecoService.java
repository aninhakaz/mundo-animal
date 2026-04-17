package com.senai.infob.mundoanimal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.infob.mundoanimal.models.Endereco;
import com.senai.infob.mundoanimal.repositories.EnderecoRepository;

@Service
public class EnderecoService {
    @Autowired
    private EnderecoRepository enderecoRepository;

    public Long count(){
        return enderecoRepository.count();
    }

     public Endereco salvar(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

    
    public boolean delete(Integer id){
        Endereco endereco = enderecoRepository.findById(id).get();
        if (endereco != null) {
            enderecoRepository.deleteById(id);
            return true;
        }
        return false;
    }

     public Endereco busca(Integer id) {
        return enderecoRepository.findById(id).get();
    }

    public List<Endereco> lista() {
        return enderecoRepository.findAll();
    }


    public Endereco atualizar(Endereco endereco, Integer id){
        Endereco e = busca(id);
        if (e != null) {
            endereco.setId(id);
            return enderecoRepository.save(endereco);
        }
        return null;
    }
}