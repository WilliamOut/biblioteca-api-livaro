package com.mobile.livaroapi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mobile.livaroapi.model.Emprestimo;

@Repository
public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {
    // Método que o Spring Data JPA traduz para "SELECT * FROM tb_emprestimo WHERE
    // stsentregue = false"
    List<Emprestimo> findByStsentregueFalseAndUsuario_Id(Long idUsuario);
    List<Emprestimo> findByStsentregueTrueAndUsuario_Id(Long idUsuario);
    Optional<Emprestimo> findByLivro_IdAndStsentregueFalse(Long idLivro);
}
