package com.senai.infob.mundoanimal.services;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.senai.infob.mundoanimal.models.Postagem;
import com.senai.infob.mundoanimal.repositories.PostagemRepository;


@Service
public class PostagemService {


@Service
public class postagemService {

    private final PostagemRepository postagemRepository;


    public PostagemService(PostagemRepository postagemRepository) {
        this.postagemRepository = postagemRepository;
    }

    public Postagem salvar(Postagem postagem) {
        return postagemRepository.save(postagem);
    }

    public Boolean deletar(Integer id) {
        Optional<Postagem> postagem = postagemRepository.findById(id);

        if (postagem.isPresent()) {
            postagemRepository.deleteById(id);
            return true;
        }

        return false;
    }
}


}