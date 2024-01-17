package com.sulimann.mercadolivre.usecases.criarcategoria;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import com.sulimann.mercadolivre.models.Categoria;
import com.sulimann.mercadolivre.utils.ErrorMessage;
import com.sulimann.mercadolivre.validators.uniquevalue.UniqueValue;

import lombok.Getter;

@Getter
public class CriarCategoriaRequest implements Serializable{

    private static final long serialVersionUID = 1L;

    @NotBlank(message = ErrorMessage.CAMPO_OBRIGATORIO)
    @UniqueValue(domainClass = Categoria.class, fieldName = "nome", message = "Categoria já existente")
    private String nome;

    public Categoria toCategoria() {
        return new Categoria(this.nome);
    }

}
