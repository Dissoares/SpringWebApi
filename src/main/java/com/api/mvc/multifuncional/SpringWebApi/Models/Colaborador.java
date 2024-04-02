package com.api.mvc.multifuncional.SpringWebApi.Models;

import lombok.Data;

import java.util.Date;

@Data
public class Colaborador {
   private Integer id;
   private String nome;
   private String cpf;
   private String telefone;
   private String email;
   private Endereco endereco;
   private Empresa empresa;
   private String profissao;
   private Double salario;
   private String cargo;
   private String dataContratacao;
   private String dataDesligamento;
   private Boolean ativo;
   private Date data_criacao;
   private Date data_modificacao;
}
