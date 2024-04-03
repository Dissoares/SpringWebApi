package com.api.mvc.multifuncional.SpringWebApi.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class RelatorioRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public RelatorioRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Map<String, Object>> consultarDadosParaRelatorio() {
        String consultaSQL = "SELECT col.ID," +
                "col.NOME," +
                "col.CPF," +
                "col.TELEFONE," +
                "col.EMAIL," +
                "col.PROFISSAO," +
                "col.SALARIO," +
                "col.DATA_CONTRATACAO," +
                "col.DATA_DESLIGAMENTO," +
                "col.ATIVO " +
                "FROM colaborador col " +
                "INNER JOIN endereco ON col.ENDERECO_FK = endereco.ID " +
                "INNER JOIN empresa ON col.EMPRESA_FK = empresa.ID " +
                "INNER JOIN endereco en ON empresa.ENDERECO_FK = en.ID " +
                "WHERE col.ATIVO = 1 " +
                "ORDER BY col.ID DESC";

        return jdbcTemplate.queryForList(consultaSQL);
    }
}
