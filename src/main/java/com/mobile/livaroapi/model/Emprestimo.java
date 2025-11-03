package com.mobile.livaroapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

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
}
