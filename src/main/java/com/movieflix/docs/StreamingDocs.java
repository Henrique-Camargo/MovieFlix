package com.movieflix.docs;

import com.movieflix.streaming.request.StreamingRequest;
import com.movieflix.streaming.response.StreamingResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Tag(name = "Streaming", description = "Recurso responsavel pelo gerenciamento dos streamings")
public interface StreamingDocs {

    @Operation(summary = "Salvar streaming", description = "Metodo responsavel por realizar o salvamento de um novo streaming",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "201", description = "streaming salva com sucesso",
            content = @Content(schema = @Schema(implementation = StreamingResponse.class)))
    ResponseEntity<StreamingResponse> save (@Valid @RequestBody StreamingRequest request);

    @Operation(summary = "Buscar todos os streaming", description = "Metodo responsavel por retornar todos os streamings",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "200", description = "Retorna todos os streamings.",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = StreamingResponse.class))))
    ResponseEntity<List<StreamingResponse>> findAll ();

    @Operation(summary = "Buscar streaming por Id", description = "Metodo responsavel por buscar streaming por Id",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "200", description = "streaming encontrado com sucesso.",
            content = @Content(schema = @Schema(implementation = StreamingResponse.class)))
    @ApiResponse(responseCode = "404", description = "streaming não encontrado", content = @Content())
    ResponseEntity<StreamingResponse> findById(@PathVariable Long id);

    @Operation(summary = "Deletar streaming por id", description = "Metodo responsavel por deletar streaming por id",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "200", description = "streaming deletado com sucesso.", content = @Content())
    @ApiResponse(responseCode = "404", description = "streaming não encontrado", content = @Content())
    ResponseEntity<Void> deleteById(@PathVariable Long id);

}
