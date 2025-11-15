package com.mobile.livaroapi.dto;

import com.mobile.livaroapi.model.Livro;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class LivroResponseDTO {

    private Long id;
    private String nomeLivro;
    private Long idAutor;
    private String nomeAutor;

    public LivroResponseDTO () {}

    public LivroResponseDTO(Livro livro) {
        this.id = livro.getId();
        this.nomeLivro = livro.getNome();
        this.idAutor = livro.getAutor().getId();
        this.nomeAutor = livro.getAutor().getNome();
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

    public Long getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(Long idAutor) {
        this.idAutor = idAutor;
    }

    public String getNomeAutor() {
        return nomeAutor;
    }

    public void setNomeAutor(String nomeAutor) {
        this.nomeAutor = nomeAutor;
    }
}
