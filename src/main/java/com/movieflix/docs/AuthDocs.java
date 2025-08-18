package com.movieflix.docs;

import com.movieflix.user.request.LoginRequest;
import com.movieflix.user.request.UserRequest;
import com.movieflix.user.response.LoginResponse;
import com.movieflix.user.response.UserResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface AuthDocs {

    @Operation(summary = "Salvar usuario", description = "Metodo responsavel por realizar o salvamento de um novo usuario",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "200", description = "Usuario salvo com sucesso",
            content = @Content(schema = @Schema(implementation = UserResponse.class)))
    ResponseEntity<UserResponse> register(@RequestBody UserRequest request);

    @Operation(summary = "Logar com usuario cadastrado", description = "Metodo responsavel por Logar o usuario",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "200", description = "usuario logado com sucesso",
            content = @Content(schema = @Schema(implementation = UserResponse.class)))
    @ApiResponse(responseCode = "404", description = "usuario não encontrado", content = @Content())
    ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request);
}
