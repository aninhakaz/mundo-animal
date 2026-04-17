package com.senai.infob.mundoanimal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senai.infob.mundoanimal.models.Endereco;

@Repository
public interface  EnderecoRepository extends JpaRepository<Endereco, Integer> {
    
}