package com.mobile.livaroapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tb_emprestimo")
public class Emprestimo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer diainicio;

    @Column(nullable = false)
    private Integer mesinicio;

    @Column(nullable = false)
    private Integer anoinicio;

    @Column(nullable = false)
    private Integer diafinal;

    @Column(nullable = false)
    private Integer mesfinal;

    @Column(nullable = false)
    private Integer anofinal;

    @Column(nullable = false)
    private Boolean stsentregue;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuarios usuario;

    @ManyToOne
    @JoinColumn(name = "livro_id")
    private Livro livro;

    public Emprestimo() {}

    public Emprestimo(Long id, Integer diainicio, Integer mesinicio, Integer anoinicio, Integer diafinal, Integer mesfinal, Integer anofinal, Boolean stsentregue) {
        this.id = id;
        this.diainicio = diainicio;
        this.mesinicio = mesinicio;
        this.anoinicio = anoinicio;
        this.diafinal = diafinal;
        this.mesfinal = mesfinal;
        this.anofinal = anofinal;
        this.stsentregue = stsentregue;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getDiainicio() {
        return diainicio;
    }

    public void setDiainicio(Integer diainicio) {
        this.diainicio = diainicio;
    }

    public Integer getMesinicio() {
        return mesinicio;
    }

    public void setMesinicio(Integer mesinicio) {
        this.mesinicio = mesinicio;
    }

    public Integer getAnoinicio() {
        return anoinicio;
    }

    public void setAnoinicio(Integer anoinicio) {
        this.anoinicio = anoinicio;
    }

    public Integer getDiafinal() {
        return diafinal;
    }

    public void setDiafinal(Integer diafinal) {
        this.diafinal = diafinal;
    }

    public Integer getMesfinal() {
        return mesfinal;
    }

    public void setMesfinal(Integer mesfinal) {
        this.mesfinal = mesfinal;
    }

    public Integer getAnofinal() {
        return anofinal;
    }

    public void setAnofinal(Integer anofinal) {
        this.anofinal = anofinal;
    }

    public Boolean getStsentregue() {
        return stsentregue;
    }

    public void setStsentregue(Boolean stsentregue) {
        this.stsentregue = stsentregue;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }
}
