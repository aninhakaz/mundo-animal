package com.senai.infob.mundoanimal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.infob.mundoanimal.models.Postagem;
import com.senai.infob.mundoanimal.repositories.PostagemRepository;

@Service
public class PostagemService {
    @Autowired
    private PostagemRepository postagemRepository;

    public Long count(){
        return postagemRepository.count();
    }

     public Postagem salvar(Postagem postagem) {
        return postagemRepository.save(postagem);
    }

    
    public boolean delete(Integer id){
        Postagem postagem = postagemRepository.findById(id).get();
        if (postagem != null) {
            postagemRepository.deleteById(id);
            return true;
        }
        return false;
    }

     public Postagem busca(Integer id) {
        return postagemRepository.findById(id).get();
    }

    public List<Postagem> lista() {
        return postagemRepository.findAll();
    }


    public Postagem atualizar(Postagem postagem, Integer id){
        Postagem e = busca(id);
        if (e != null) {
            postagem.setId(id);
            return postagemRepository.save(postagem);
        }
        return null;
    }
}