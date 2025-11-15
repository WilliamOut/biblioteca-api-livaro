package com.mobile.livaroapi.dto;

import com.mobile.livaroapi.model.Livro;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class LivroListagemDTO {

    private Long id;
    private String nomeLivro;
    private String nomeAutor;

    public LivroListagemDTO(Livro dto) {
        this.id = dto.getId();
        this.nomeLivro = dto.getNome();
        this.nomeAutor = dto.getAutor().getNome();
    }

    public LivroListagemDTO() {}

    public LivroListagemDTO(Long id, String nomeLivro, String nomeAutor) {
        this.id = id;
        this.nomeLivro = nomeLivro;
        this.nomeAutor = nomeAutor;
    }

    public String getNomeAutor() {
        return nomeAutor;
    }

    public void setNomeAutor(String nomeAutor) {
        this.nomeAutor = nomeAutor;
    }

    public String getNomeLivro() {
        return nomeLivro;
    }

    public void setNomeLivro(String nomeLivro) {
        this.nomeLivro = nomeLivro;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
