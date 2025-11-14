package com.mobile.livaroapi.dto;

import com.mobile.livaroapi.model.Livro;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LivroListagemDTO {

    private Long id;
    private String nome;
    private String nomeAutor;

    public LivroListagemDTO(Livro dto) {
        this.id = dto.getId();
        this.nome = dto.getNome();
        this.nomeAutor = dto.getAutor().getNome();
    }
}
