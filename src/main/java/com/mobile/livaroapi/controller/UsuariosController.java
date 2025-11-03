package com.mobile.livaroapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mobile.livaroapi.dto.EsquecerSenhaDTO;
import com.mobile.livaroapi.dto.LoginRequestDTO;
import com.mobile.livaroapi.dto.LoginResponseDTO;
import com.mobile.livaroapi.dto.UsuarioResponseDTO;
import com.mobile.livaroapi.dto.UsuariosRequestDTO;
import com.mobile.livaroapi.model.Usuarios;
import com.mobile.livaroapi.service.UsuariosService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/usuarios")
@Tag(name = "Usuários", description = "Endpoints para gerenciamento de Usuários")
public class UsuariosController {

    private final UsuariosService usuariosService;

    public UsuariosController(UsuariosService usuariosService) {
        this.usuariosService = usuariosService;
    }

    @Operation(summary = "Cadastrar novo usuário", description = "Cria uma nova conta com validação de campos e e-mail único.")
    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> cadastrarUsuario(@Valid @RequestBody UsuariosRequestDTO dto) {
        try {
            Usuarios usuarioSalvo = usuariosService.cadastrar(dto);
            UsuarioResponseDTO usuarioResposta = new UsuarioResponseDTO(usuarioSalvo);
            return new ResponseEntity<>(usuarioResposta, HttpStatus.CREATED);
        } catch (IllegalStateException e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @Operation(summary = "Login de usuário", description = "Autentica o usuário e retorna o objeto Usuario.")
    @PostMapping("/login") // Rota final: /api/usuarios/login
    public ResponseEntity<LoginResponseDTO> loginUsuario(@Valid @RequestBody LoginRequestDTO dto) {
        try {
            Usuarios usuarioLogado = usuariosService.fazerLogin(dto);
            UsuarioResponseDTO usuarioResposta = new UsuarioResponseDTO(usuarioLogado);
            LoginResponseDTO responseDTO = new LoginResponseDTO("Logado!", usuarioResposta);
            return new ResponseEntity<>(responseDTO, HttpStatus.OK);
        } catch (IllegalStateException e) {
            return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED); // 401 Unauthorized
        }
    }

    @Operation(summary = "Redefinir senha por email", description = "Atualiza a senha do usuário, exigindo nova senha e confirmação.")
    @PutMapping("/esqueci-senha") // Rota final: /api/usuarios/esqueci-senha
    public ResponseEntity<UsuarioResponseDTO> redefinirSenha(@Valid @RequestBody EsquecerSenhaDTO request) {
        try {
            Usuarios usuarioAtualizado = usuariosService.atualizarSenhaPorEmail(request);

            // Mapeia para o DTO de Saída (seguro, sem expor a senha)
            UsuarioResponseDTO responseDTO = new UsuarioResponseDTO(usuarioAtualizado);

            return new ResponseEntity<>(responseDTO, HttpStatus.OK);

        } catch (IllegalStateException e) {
            // Trata exceções do Service (Usuário não encontrado)
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

}
