package com.mobile.livaroapi.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UniqueElements;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuariosRequestDTO {

    @NotBlank(message = "O nome é obrigatório")
    private String nome;

    @NotBlank(message = "O e-mail é obrigatório")
    @Email(message = "Formato de e-mail inválido")
    @Size(max = 200, message = "O e-mail não pode exceder 200 caracteres.")
    private String email;


    @NotBlank(message = "A senha não pode ser vazia.")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @Size(min = 8, message = "A senha deve ter no mínimo 8 caracteres")
    private String senha;
}
