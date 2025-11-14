package com.mobile.livaroapi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mobile.livaroapi.model.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {
    Optional<Livro> findByNomeAndAutorNome(String nomeLivro, String nomeAutor);

    List<Livro> findByNomeContainingIgnoreCaseOrAutorNomeContainingIgnoreCase(String nomeLivro,
            String nomeAutor);
}
