package com.api.mvc.multifuncional.SpringWebApi.Models;

import lombok.Data;

import java.util.Date;

@Data
public class Empresa {
    private Integer id;
    private String nome;
    private String razao_social;
    private String cnpj;
    private String telefone;
    private Endereco endereco;
    private Boolean ativo;
    private Date data_criacao;
    private Date data_modificacao;
}

