package com.mobile.livaroapi.dto;

import com.mobile.livaroapi.model.Emprestimo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LivroReservadoResponseDTO {

    private String nome;
    private String nomeAutor;

    public LivroReservadoResponseDTO(Emprestimo dto) {
        this.nome = dto.getLivro().getNome();
        this.nomeAutor = dto.getLivro().getAutor().getNome();
    }
}
