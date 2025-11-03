package com.mobile.livaroapi.service;

import org.springframework.stereotype.Service;

import com.mobile.livaroapi.dto.EsquecerSenhaDTO;
import com.mobile.livaroapi.dto.LoginRequestDTO;
import com.mobile.livaroapi.dto.UsuariosRequestDTO;
import com.mobile.livaroapi.model.Usuarios;
import com.mobile.livaroapi.repository.UsuariosRepository;

@Service
public class UsuariosService {

    private final UsuariosRepository usuariosRepository;

    public UsuariosService(UsuariosRepository usuariosRepository) {
        this.usuariosRepository = usuariosRepository;
    }

    /**
     * Cadastra um novo usuário após verificar a unicidade do e-mail.
     * 
     * @param request DTO com os dados do usuário.
     * @return A entidade Usuario salva.
     * @throws IllegalStateException se o e-mail já estiver em uso.
     */
    public Usuarios cadastrar(UsuariosRequestDTO dto) {
        if (usuariosRepository.existsByEmail(dto.getEmail())) {
            throw new IllegalStateException("O email já está em uso");
        }

        Usuarios novoUsuario = new Usuarios();
        novoUsuario.setNome(dto.getNome());
        novoUsuario.setEmail(dto.getEmail());
        novoUsuario.setSenha(dto.getSenha());

        return usuariosRepository.save(novoUsuario);
    }

    /**
     * Tenta autenticar o usuário com email e senha em texto puro.
     * 
     * @param request DTO de Login.
     * @return A entidade Usuario logada.
     * @throws IllegalStateException se as credenciais forem inválidas.
     */
    public Usuarios fazerLogin(LoginRequestDTO dto) {
        Usuarios usuario = usuariosRepository.findByEmail(dto.getEmail());

        if (usuario == null) {
            // Se não encontrou, lança erro de credenciais inválidas.
            throw new IllegalStateException("Credenciais inválidas. Tente novamente");
        }

        if (!usuario.getSenha().equals(dto.getSenha())) {
            // Se a senha não coincide, lança erro de credenciais inválidas.
            throw new IllegalStateException("Credenciais inválidas. Tente novamente");
        }

        return usuario;
    }

    public Usuarios atualizarSenhaPorEmail(EsquecerSenhaDTO request) {

        // 1. Busca o usuário pelo e-mail
        // Nota: findByEmail deve retornar Optional<Usuarios> ou você deve checar null
        Usuarios usuario = usuariosRepository.findByEmail(request.getEmail());

        if (usuario == null) {
            throw new IllegalStateException("O link de redefinição expirou ou é inválido.");
        }

        usuario.setSenha(request.getNovaSenha());

        return usuariosRepository.save(usuario);
    }
}
