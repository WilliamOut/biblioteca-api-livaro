package com.mobile.livaroapi.service;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.mobile.livaroapi.dto.EmprestimoRequestDTO;
import com.mobile.livaroapi.model.Emprestimo;
import com.mobile.livaroapi.model.Livro;
import com.mobile.livaroapi.model.Usuarios;
import com.mobile.livaroapi.repository.EmprestimoRepository;
import com.mobile.livaroapi.repository.LivroRepository;
import com.mobile.livaroapi.repository.UsuariosRepository;

import jakarta.transaction.Transactional;

@Service
public class EmprestimoService {

    private final EmprestimoRepository emprestimoRepository;
    private final LivroRepository livroRepository;
    private final UsuariosRepository usuariosRepository;

    public EmprestimoService(EmprestimoRepository emprestimoRepository, LivroRepository livroRepository,
            UsuariosRepository usuariosRepository) {
        this.emprestimoRepository = emprestimoRepository;
        this.livroRepository = livroRepository;
        this.usuariosRepository = usuariosRepository;
    }

    @Transactional
    public Emprestimo realizarEmprestimo(EmprestimoRequestDTO dto) {
        Livro livro = livroRepository.findByNomeAndAutorNome(dto.getNomeLivro(), dto.getNomeAutor())
                .orElseThrow(() -> new IllegalStateException("Livro e/ou Autor não encontrados!"));

        Usuarios usuario = usuariosRepository.findById(dto.getIdUsuario())
                .orElseThrow(() -> new IllegalStateException("Usuário não encontrado!"));

        LocalDate dataEmprestimo = LocalDate.now();
        LocalDate dataEntrega = dataEmprestimo.plusDays(dto.getPrazoEmDias());

        Emprestimo novoEmprestimo = new Emprestimo();
        novoEmprestimo.setLivro(livro);
        novoEmprestimo.setUsuario(usuario);

        novoEmprestimo.setDiainicio(dataEmprestimo.getDayOfMonth());
        novoEmprestimo.setMesinicio(dataEmprestimo.getMonthValue());
        novoEmprestimo.setAnoinicio(dataEmprestimo.getYear());

        novoEmprestimo.setDiafinal(dataEntrega.getDayOfMonth());
        novoEmprestimo.setMesfinal(dataEntrega.getMonthValue());
        novoEmprestimo.setAnofinal(dataEntrega.getYear());

        novoEmprestimo.setStsentregue(false);

        return emprestimoRepository.save(novoEmprestimo);
    }

}
