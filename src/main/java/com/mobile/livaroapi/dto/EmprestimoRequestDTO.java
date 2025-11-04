package com.mobile.livaroapi.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmprestimoRequestDTO {

    @NotNull(message = "O ID do usuário é obrigatório.")
    private Long idUsuario;

    @NotBlank(message = "O nome do livro é obrigatório.")
    private String nomeLivro;

    @NotBlank(message = "O nome do autor é obrigatório.")
    private String nomeAutor;

    @NotNull(message = "O prazo de empréstimo (em dias) é obrigatório.")
    @Min(value = 3, message = "O prazo mínimo de empréstimo é 3 dias.")
    private Integer prazoEmDias;
}
