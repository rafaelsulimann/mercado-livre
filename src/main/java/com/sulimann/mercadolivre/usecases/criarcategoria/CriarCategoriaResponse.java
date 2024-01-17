package com.sulimann.mercadolivre.usecases.criarcategoria;

import java.io.Serializable;

import com.sulimann.mercadolivre.models.Categoria;

import lombok.Getter;

@Getter
public class CriarCategoriaResponse implements Serializable{

    private static final long serialVersionUID = 1L;

    private Long id;
    private String nome;

    public CriarCategoriaResponse(Categoria categoria) {
        this.id = categoria.getId();
        this.nome = categoria.getNome();
    }

}
