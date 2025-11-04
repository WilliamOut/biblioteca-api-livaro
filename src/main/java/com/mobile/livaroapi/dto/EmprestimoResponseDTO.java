package com.mobile.livaroapi.dto;

import com.mobile.livaroapi.model.Emprestimo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmprestimoResponseDTO {

    private Long id;
    private Long idLivro;
    private String nomeLivro;
    private String dataEmprestimo; // Formato YYYY-MM-DD
    private String dataEntrega; // Formato YYYY-MM-DD
    private boolean stsentregue;

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
}
