package com.mobile.livaroapi.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


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

    public EmprestimoRequestDTO() {}

    public EmprestimoRequestDTO(Long idUsuario, String nomeLivro, String nomeAutor, Integer prazoEmDias) {
        this.idUsuario = idUsuario;
        this.nomeLivro = nomeLivro;
        this.nomeAutor = nomeAutor;
        this.prazoEmDias = prazoEmDias;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
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

    public Integer getPrazoEmDias() {
        return prazoEmDias;
    }

    public void setPrazoEmDias(Integer prazoEmDias) {
        this.prazoEmDias = prazoEmDias;
    }
}
