package com.senai.infob.mundoanimal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senai.infob.mundoanimal.models.Doacao;

@Repository
public interface  DoacaoRepository extends JpaRepository<Doacao, Integer> {
    
}