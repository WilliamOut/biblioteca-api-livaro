package com.mobile.livaroapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mobile.livaroapi.model.Autor;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {
    // metodo seguro Optional para lidar com null
    Optional<Autor> findByNome(String nome);
}
