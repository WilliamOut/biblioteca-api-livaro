package com.mobile.livaroapi.service;

import com.mobile.livaroapi.dto.LivroListagemDTO;
import com.mobile.livaroapi.dto.LivroReservadoResponseDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mobile.livaroapi.dto.LivroRequestDTO;
import com.mobile.livaroapi.model.Autor;
import com.mobile.livaroapi.model.Livro;
import com.mobile.livaroapi.repository.AutorRepository;
import com.mobile.livaroapi.repository.LivroRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LivroService {

    private final LivroRepository livroRepository;
    private final AutorRepository autorRepository;

    public LivroService(LivroRepository livroRepository, AutorRepository autorRepository) {
        this.livroRepository = livroRepository;
        this.autorRepository = autorRepository;
    }

    @Transactional
    public Livro cadastrar(LivroRequestDTO dto) {

        Autor autor = autorRepository.findByNome(dto.getNomeAutor())
                .orElseGet(() -> {

                    Autor novoAutor = new Autor();
                    novoAutor.setNome(dto.getNomeAutor());
                    return autorRepository.save(novoAutor);

                });

        Livro novoLivro = new Livro();
        novoLivro.setNome(dto.getNome());
        novoLivro.setAutor(autor);

        return livroRepository.save(novoLivro);
    }

    @Transactional(readOnly = true)
    public List<LivroListagemDTO> listarTodosOsLivros() {
        return livroRepository.findAll().stream()
                .map(LivroListagemDTO::new)
                .collect(Collectors.toList());
    }
}
