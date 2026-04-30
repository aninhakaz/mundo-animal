package com.senai.infob.mundoanimal.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.senai.infob.mundoanimal.models.Postagem;
;
@Repository
public interface PostagemRepository extends JpaRepository<Postagem, Integer> {

    @Query(value="select * from postagem where pagina = :pagina", nativeQuery=true)
    List<Postagem> buscaPostagens(String pagina);
}