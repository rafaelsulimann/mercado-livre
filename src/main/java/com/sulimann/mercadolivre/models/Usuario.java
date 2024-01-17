package com.sulimann.mercadolivre.models;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.Assert;
import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sulimann.mercadolivre.utils.Regex;
import com.sulimann.mercadolivre.utils.TableName;

import lombok.Getter;

@Entity
@Table(name = TableName.USUARIO)
@Getter
@Validated
public class Usuario implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String senha;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
    private LocalDateTime dataCriacao;

    public Usuario(String email, String senha) {
        Assert.hasText(email, "Email não pode ser nulo ou em branco");
        Assert.isTrue(email.matches(Regex.EMAIL), "Email precisa ser válido");
        Assert.hasText(senha, "Senha não pode ser nulo ou em branco");
        Assert.isTrue(senha.length() >= 6, "Senha precisa ter no mínimo 6 caracteres");
        Assert.isTrue(!senha.matches(Regex.BCRYPT_PATTERN), "Senha não pode estar encriptada");
        
        this.email = email;
        this.senha = new BCryptPasswordEncoder().encode(senha);
        this.dataCriacao = LocalDateTime.now();
    }

}
