package com.movieflix.user.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserRequest(
        @NotBlank(message = "O nome é obrigatorio")
        String name,

        @NotBlank(message = "O email é obrigatorio")
        @Email
        String email,

        @NotBlank(message = "O password é obrigatorio")
        String password
) {
}
