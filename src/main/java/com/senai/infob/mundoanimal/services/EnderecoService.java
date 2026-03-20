package com.senai.infob.mundoanimal.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.infob.mundoanimal.models.Endereco;
import com.senai.infob.mundoanimal.repositories.EnderecoRepository;

@Service
public class EnderecoService {
    
     @Autowired
    private EnderecoRepository enderecoRepository;


    public Endereco salvar(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }


    public Endereco buscarPorId(Integer id) {
        return enderecoRepository.findById(id).get();
    }
    
    public boolean atualizar(Endereco endereco, Integer id) {
        Endereco end = buscarPorId(id);
        if (end != null) {
            endereco.setId(id);
            enderecoRepository.save(endereco);
            return true;
        }
        return false;
    }
}