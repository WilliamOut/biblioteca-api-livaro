package com.mobile.livaroapi.dto;

import com.mobile.livaroapi.model.Emprestimo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class LivroReservadoResponseDTO {

    private Long id;
    private String nomeLivro;
    private String nomeAutor;

    public LivroReservadoResponseDTO() {}
    public LivroReservadoResponseDTO(Emprestimo dto) {
        this.id = dto.getId();
        this.nomeLivro = dto.getLivro().getNome();
        this.nomeAutor = dto.getLivro().getAutor().getNome();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeLivro() {
        return nomeLivro;
    }

    public void setNomeLivro(String nomeLivro) {
        this.nomeLivro = nomeLivro;
    }

    public String getNomeAutor() {
        return nomeAutor;
    }

    public void setNomeAutor(String nomeAutor) {
        this.nomeAutor = nomeAutor;
    }
}
