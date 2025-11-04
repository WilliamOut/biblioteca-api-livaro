package com.mobile.livaroapi.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mobile.livaroapi.dto.EmprestimoRequestDTO;
import com.mobile.livaroapi.dto.EmprestimoResponseDTO;
import com.mobile.livaroapi.dto.LivroReservadoResponseDTO;
import com.mobile.livaroapi.model.Emprestimo;
import com.mobile.livaroapi.service.EmprestimoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("api/emprestimo")
@Tag(name = "Empréstimos", description = "Endpoints para gerenciamento de Empréstimos/Reservas")
public class EmprestimoController {

    private final EmprestimoService emprestimoService;

    public EmprestimoController(EmprestimoService emprestimoService) {
        this.emprestimoService = emprestimoService;
    }

    @Operation(summary = "Realizar empréstimo/reserva de livro", description = "Cria um novo registro de empréstimo e calcula a data de devolução.")
    @PostMapping
    public ResponseEntity<EmprestimoResponseDTO> realizarEmprestimo(@Valid @RequestBody EmprestimoRequestDTO request) {
        Emprestimo novoEmprestimo = emprestimoService.realizarEmprestimo(request);
        EmprestimoResponseDTO response = new EmprestimoResponseDTO(novoEmprestimo);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @Operation(summary = "Listar livros reservados (emprestados)", description = "Retorna uma lista de todos os livros atualmente emprestados, com nome e autor.")
    @GetMapping("/reservados/{idUsuario}")
    public ResponseEntity<List<LivroReservadoResponseDTO>> listarReservados(@PathVariable Long idUsuario) {
        List<LivroReservadoResponseDTO> reservados = emprestimoService.listarLivrosReservados(idUsuario);

        if (reservados.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(reservados, HttpStatus.OK);
    }
}
