package com.mobile.livaroapi.dto;

public class UsuarioPerfilDTO {

    private String nome;
    private Long quantidadeLivrosLidos;

    public UsuarioPerfilDTO() {
    }

    public UsuarioPerfilDTO(String nome, Long quantidadeLivrosLidos) {
        this.nome = nome;
        this.quantidadeLivrosLidos = quantidadeLivrosLidos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getQuantidadeLivrosLidos() {
        return quantidadeLivrosLidos;
    }

    public void setQuantidadeLivrosLidos(Long quantidadeLivrosLidos) {
        this.quantidadeLivrosLidos = quantidadeLivrosLidos;
    }
}
