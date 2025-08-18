package com.movieflix.docs;

import com.movieflix.movie.request.MovieRequest;
import com.movieflix.movie.response.MovieResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Movie", description = "Recurso responsavel pelo gerenciamento dos filmes")
public interface MovieDocs {

    @Operation(summary = "Salvar Filme", description = "Metodo responsavel por realizar o salvamento de um novo filme",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "201", description = "Filme salvo com sucesso",
            content = @Content(schema = @Schema(implementation = MovieResponse.class)))
    ResponseEntity<MovieResponse> save (@Valid @RequestBody MovieRequest request);

    @Operation(summary = "Buscar todos os Filmes", description = "Metodo responsavel por retornar todos os filmes",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "200", description = "Retorna todos os filmes cadastrados.",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = MovieResponse.class))))
    ResponseEntity<List<MovieResponse>> findAll ();

    @Operation(summary = "Buscar filme por Id", description = "Metodo responsavel por buscar filme por Id",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "200", description = "Filme encontrado com sucesso.",
            content = @Content(schema = @Schema(implementation = MovieResponse.class)))
    @ApiResponse(responseCode = "404", description = "Filme não encontrado", content = @Content())
    ResponseEntity<MovieResponse> findById(@PathVariable Long id);

    @Operation(summary = "Alterar Filme por id", description = "Metodo responsavel por alterar filme por id",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "200", description = "Filme alterado com sucesso.",
            content = @Content(schema = @Schema(implementation = MovieResponse.class)))
    @ApiResponse(responseCode = "404", description = "Filme não encontrado", content = @Content())
    ResponseEntity<MovieResponse> update(@PathVariable Long id, @Valid @RequestBody MovieRequest request);

    @Operation(summary = "Buscar filmes por categoria", description = "Metodo responsavel por buscar filmes por cateroria",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "200", description = "Buscar filme por categoria.",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = MovieResponse.class))))
    ResponseEntity<List<MovieResponse>> findByCategory(@RequestParam Long category);

    @Operation(summary = "Deletar Filme por id", description = "Metodo responsavel por deletar filme por id",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "200", description = "Filme deletado com sucesso.", content = @Content())
    @ApiResponse(responseCode = "404", description = "Filme não encontrado", content = @Content())
    ResponseEntity<Void> deleteById(@PathVariable Long id);

}
