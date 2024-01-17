package com.sulimann.mercadolivre.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.util.Assert;

import com.sulimann.mercadolivre.utils.TableName;

import lombok.Getter;

@Entity
@Table(name = TableName.CATEGORIA)
@Getter
public class Categoria implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    public Categoria(String nome) {
        Assert.hasText(nome, "Nome não pode ser nulo ou em branco");
        this.nome = nome;
    }
    
}
