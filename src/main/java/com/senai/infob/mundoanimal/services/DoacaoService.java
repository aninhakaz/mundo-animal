package com.senai.infob.mundoanimal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.infob.mundoanimal.models.Doacao;
import com.senai.infob.mundoanimal.repositories.DoacaoRepository;

@Service
public class DoacaoService {
    @Autowired
    private DoacaoRepository doacaoRepository;

    public Long count(){
        return doacaoRepository.count();
    }

     public Doacao salvar(Doacao doacao) {
        return doacaoRepository.save(doacao);
    }

    
    public boolean delete(Integer id){
        Doacao doacao = doacaoRepository.findById(id).get();
        if (doacao != null) {
            doacaoRepository.deleteById(id);
            return true;
        }
        return false;
    }

     public Doacao busca(Integer id) {
        return doacaoRepository.findById(id).get();
    }

    public List<Doacao> lista() {
        return doacaoRepository.findAll();
    }


    public Doacao atualizar(Doacao doacao, Integer id){
        Doacao e = busca(id);
        if (e != null) {
            doacao.setId(id);
            return doacaoRepository.save(doacao);
        }
        return null;
    }
}
