package com.api.mvc.multifuncional.SpringWebApi.Models;

import lombok.Data;

import java.util.Date;

@Data
public class Endereco {
    private Integer id;
    private String rua;
    private Integer numero;
    private String cep;
    private String cidade;
    private String estado;
    private String pais;
    private Boolean ativo;
    private Date data_criacao;
    private Date data_modificacao;
}
