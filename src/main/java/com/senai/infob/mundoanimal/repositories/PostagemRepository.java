package com.senai.infob.mundoanimal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senai.infob.mundoanimal.models.Postagem;
;
@Repository
public interface PostagemRepository extends JpaRepository<Postagem, Integer> {

    
}