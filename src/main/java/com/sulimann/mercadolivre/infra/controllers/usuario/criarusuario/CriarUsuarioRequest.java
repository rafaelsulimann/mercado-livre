package com.sulimann.mercadolivre.infra.controllers.usuario.criarusuario;

import com.sulimann.mercadolivre.core.constants.ErrorMessage;
import com.sulimann.mercadolivre.core.usecases.usuario.criarusuario.ICriarUsuarioRequest;
import com.sulimann.mercadolivre.domain.enums.TipoUsuario;
import com.sulimann.mercadolivre.infra.entities.UsuarioEntity;
import com.sulimann.mercadolivre.infra.utils.validators.cpforcnpj.CpfOrCnpj;
import com.sulimann.mercadolivre.infra.utils.validators.uniquevalue.UniqueValue;
import com.sulimann.mercadolivre.infra.utils.validators.validenum.ValidEnum;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class CriarUsuarioRequest implements ICriarUsuarioRequest{

  @NotBlank(message = ErrorMessage.CAMPO_OBRIGATORIO)
  private String nome;

  @NotBlank(message = ErrorMessage.CAMPO_OBRIGATORIO)
  @Email(message = "Email inválido")
  @UniqueValue(domainClass = UsuarioEntity.class, fieldName = "email", message = "Email já existente")
  private String email;

  @NotBlank(message = ErrorMessage.CAMPO_OBRIGATORIO)
  @UniqueValue(domainClass = UsuarioEntity.class, fieldName = "documento", message = "Documento já existente")
  @CpfOrCnpj(message = "Documento deve ser um CPF ou CNPJ")
  private String documento;

  @NotBlank(message = ErrorMessage.CAMPO_OBRIGATORIO)
  @ValidEnum(enumClass = TipoUsuario.class, message = "Tipo de usuário inválido")
  private String tipo;

}
