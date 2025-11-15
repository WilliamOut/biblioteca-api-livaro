package com.mobile.livaroapi.dto;

import com.mobile.livaroapi.validation.PasswordMatches;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@PasswordMatches
public class EsquecerSenhaDTO {

    @NotBlank(message = "O email é obrigatório")
    @Email(message = "Formato de email inválido")
    private String email;

    @NotBlank(message = "A nova senha é obrigatória.")
    @Size(min = 8, message = "A nova senha deve ter no mínimo 8 caracteres.")
    private String novaSenha;

    @NotBlank(message = "A confirmação da senha é obrigatória.")
    @Size(min = 8, message = "A confirmação de senha deve ter no mínimo 8 caracteres.")
    private String confirmacaoSenha;

    public EsquecerSenhaDTO() {}

    public EsquecerSenhaDTO(String email, String novaSenha, String confirmacaoSenha) {
        this.email = email;
        this.novaSenha = novaSenha;
        this.confirmacaoSenha = confirmacaoSenha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNovaSenha() {
        return novaSenha;
    }

    public void setNovaSenha(String novaSenha) {
        this.novaSenha = novaSenha;
    }

    public String getConfirmacaoSenha() {
        return confirmacaoSenha;
    }

    public void setConfirmacaoSenha(String confirmacaoSenha) {
        this.confirmacaoSenha = confirmacaoSenha;
    }
}
