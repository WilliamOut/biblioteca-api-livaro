package com.mobile.livaroapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LivroRequestDTO {

    @NotBlank(message = "O nome do livro é obrigatório.")
    @Size(min = 3, max = 200, message = "O nome do livro deve ter entre 3 e 200 caracteres.")
    private String nome;

    @NotBlank(message = "O nome do autor é obrigatório.")
    private String nomeAutor;
}
