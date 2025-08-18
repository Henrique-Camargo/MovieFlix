package com.movieflix.docs;

import com.movieflix.category.request.CategoryRequest;
import com.movieflix.category.response.CategoryResponseDTO;
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

@Tag(name = "Category", description = "Recurso responsavel pelo gerenciamento das categorias")
public interface CategoryDocs {

    @Operation(summary = "Salvar Categoria", description = "Metodo responsavel por realizar o salvamento de uma nova categoria",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "201", description = "categoria salva com sucesso",
            content = @Content(schema = @Schema(implementation = CategoryResponseDTO.class)))
    ResponseEntity<CategoryResponseDTO> save (@Valid @RequestBody CategoryRequest request);

    @Operation(summary = "Buscar todas as categorias", description = "Metodo responsavel por retornar todas as categorias",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "200", description = "Retorna todas as categorias cadastradas.",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = CategoryResponseDTO.class))))
    ResponseEntity<List<CategoryResponseDTO>> findAll ();

    @Operation(summary = "Buscar categoria por Id", description = "Metodo responsavel por buscar categoria por Id",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "200", description = "categoria encontrado com sucesso.",
            content = @Content(schema = @Schema(implementation = CategoryResponseDTO.class)))
    @ApiResponse(responseCode = "404", description = "categoria não encontrado", content = @Content())
    ResponseEntity<CategoryResponseDTO> find(@PathVariable Long id);

    @Operation(summary = "Deletar categoria por id", description = "Metodo responsavel por deletar categoria por id",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "200", description = "categoria deletado com sucesso.", content = @Content())
    @ApiResponse(responseCode = "404", description = "categoria não encontrado", content = @Content())
    ResponseEntity<Void> delete(@PathVariable Long id);

}
