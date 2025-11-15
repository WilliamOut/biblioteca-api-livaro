package com.mobile.livaroapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class LivroRequestDTO {

    @NotBlank(message = "O nome do livro é obrigatório.")
    @Size(min = 3, max = 200, message = "O nome do livro deve ter entre 3 e 200 caracteres.")
    private String nomeLivro;

    @NotBlank(message = "O nome do autor é obrigatório.")
    private String nomeAutor;

    public LivroRequestDTO() {}

    public LivroRequestDTO(String nomeAutor) {
        this.nomeAutor = nomeAutor;
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
