package com.mobile.livaroapi.validation;

import com.mobile.livaroapi.dto.EsquecerSenhaDTO;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {
    @Override
    public void initialize(PasswordMatches constraintAnnotation) {
        // Inicialização opcional
    }

    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context) {

        // 1. Converte o objeto genérico para o seu DTO específico
        final EsquecerSenhaDTO request = (EsquecerSenhaDTO) obj;

        // 2. Compara os dois campos
        boolean isValid = request.getNovaSenha() != null &&
                request.getNovaSenha().equals(request.getConfirmacaoSenha());

        // Opcional: Customizar a mensagem de erro para o campo específico
        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(context.getDefaultConstraintMessageTemplate())
                    .addPropertyNode("confirmacaoSenha")
                    .addConstraintViolation();
        }

        return isValid;
    }

}
