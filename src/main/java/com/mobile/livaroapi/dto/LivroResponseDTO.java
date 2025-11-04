package com.mobile.livaroapi.dto;

import com.mobile.livaroapi.model.Livro;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LivroResponseDTO {

    private Long id;
    private String nome;
    private Long idAutor;
    private String nomeAutor;

    public LivroResponseDTO(Livro livro) {
        this.id = livro.getId();
        this.nome = livro.getNome();
        this.idAutor = livro.getAutor().getId();
        this.nomeAutor = livro.getAutor().getNome();
    }
}
