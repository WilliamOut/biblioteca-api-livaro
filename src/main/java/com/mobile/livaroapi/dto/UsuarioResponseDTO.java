package com.mobile.livaroapi.dto;

import com.mobile.livaroapi.model.Usuarios;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioResponseDTO {

    private Long id;
    private String nome;
    private String email;

    // Construtor utilitário para mapear da Entidade para o DTO
    public UsuarioResponseDTO(Usuarios usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
    }
}
