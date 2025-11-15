package com.mobile.livaroapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class LoginResponseDTO {

    private String status;
    private UsuarioResponseDTO usuario;

    public LoginResponseDTO() {}

    public LoginResponseDTO(String status, UsuarioResponseDTO usuario) {
        this.status = status;
        this.usuario = usuario;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public UsuarioResponseDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioResponseDTO usuario) {
        this.usuario = usuario;
    }
}
