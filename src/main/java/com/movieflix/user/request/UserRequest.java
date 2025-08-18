package com.movieflix.user.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserRequest(
        @Schema(type = "string", description = "nome do usuario")
        @NotBlank(message = "O nome é obrigatorio")
        String name,

        @Schema(type = "string", description = "Email do usuario")
        @NotBlank(message = "O email é obrigatorio")
        @Email
        String email,

        @Schema(type = "string", description = "Senha do usuario")
        @NotBlank(message = "O password é obrigatorio")
        String password
) {
}
