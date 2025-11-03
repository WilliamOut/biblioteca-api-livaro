package com.mobile.livaroapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mobile.livaroapi.model.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {

}
