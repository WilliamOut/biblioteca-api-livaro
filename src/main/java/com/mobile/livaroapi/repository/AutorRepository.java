package com.mobile.livaroapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mobile.livaroapi.model.Autor;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {

}
