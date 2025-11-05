package com.mobile.livaroapi.controller;

import com.mobile.livaroapi.dto.LivroListagemDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.mobile.livaroapi.dto.LivroRequestDTO;
import com.mobile.livaroapi.dto.LivroResponseDTO;
import com.mobile.livaroapi.model.Livro;
import com.mobile.livaroapi.service.LivroService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api/livros")
@Tag(name = "Livros", description = "Endpoints para gerenciamento de Livros")
public class LivroController {

    private final LivroService livroService;

    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    @Operation(summary = "Cadastrar novo livro", description = "Cria um novo livro e associa a um autor existente ou o cria.")
    @PostMapping
    public ResponseEntity<LivroResponseDTO> cadastrarLivro(@Valid @RequestBody LivroRequestDTO request) {
        Livro livroSalvo = livroService.cadastrar(request);
        LivroResponseDTO livroResponse = new LivroResponseDTO(livroSalvo);
        return new ResponseEntity<>(livroResponse, HttpStatus.CREATED);
    }

    @Operation(summary = "Listar todos os livros", description = "Lista todos os livros disponíveis na biblioteca")
    @GetMapping("listar-todos")
    public ResponseEntity<List<LivroListagemDTO>> listarTodosOsLivros() {
        List<LivroListagemDTO> listados = livroService.listarTodosOsLivros();

        if(listados.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(listados,HttpStatus.OK);
    }
}
