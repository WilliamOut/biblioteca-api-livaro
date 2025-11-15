package com.mobile.livaroapi.dto;

import com.mobile.livaroapi.model.Emprestimo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class EmprestimoResponseDTO {

    private Long id;
    private Long idLivro;
    private String nomeLivro;
    private String dataEmprestimo; // Formato YYYY-MM-DD
    private String dataEntrega; // Formato YYYY-MM-DD
    private boolean stsentregue;

    public EmprestimoResponseDTO() {}

    public EmprestimoResponseDTO(Emprestimo emprestimo) {
        this.id = emprestimo.getId();
        this.idLivro = emprestimo.getLivro().getId();
        this.nomeLivro = emprestimo.getLivro().getNome();
        this.dataEmprestimo = String.format("%02d-%02d-%d",
                emprestimo.getDiainicio(),
                emprestimo.getMesinicio(),
                emprestimo.getAnoinicio());
        this.dataEntrega = String.format("%02d-%02d-%d",
                emprestimo.getDiafinal(),
                emprestimo.getMesfinal(),
                emprestimo.getAnofinal());
        this.stsentregue = emprestimo.getStsentregue();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(Long idLivro) {
        this.idLivro = idLivro;
    }

    public String getNomeLivro() {
        return nomeLivro;
    }

    public void setNomeLivro(String nomeLivro) {
        this.nomeLivro = nomeLivro;
    }

    public String getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(String dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public String getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(String dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public boolean isStsentregue() {
        return stsentregue;
    }

    public void setStsentregue(boolean stsentregue) {
        this.stsentregue = stsentregue;
    }
}
