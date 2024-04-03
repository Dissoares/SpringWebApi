package com.api.mvc.multifuncional.SpringWebApi.Services;

import com.api.mvc.multifuncional.SpringWebApi.Repository.RelatorioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.OutputStream;
import java.util.List;
import java.util.Map;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import org.apache.poi.ss.usermodel.DateUtil;
import java.text.SimpleDateFormat;

@Service
public class RelatorioService {
    private final RelatorioRepository relatorioRepository;

    @Autowired
    public RelatorioService(RelatorioRepository relatorioRepository) {
        this.relatorioRepository = relatorioRepository;
    }

    public void gerarRelatorio(OutputStream outputStream) {

        List<Map<String, Object>> dadosDoBanco = relatorioRepository.consultarDadosParaRelatorio();
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Exemplo Relatório");


            Row headerRow = sheet.createRow(0);
            String[] headers = {" ID ",
                                " NOME ",
                                " CPF ",
                                " TELEFONE ",
                                " EMAIL ",
                                " PROFISSAO ",
                                " SALARIO ",
                                " DATA_CONTRATACAO ",
                                " DATA_DESLIGAMENTO ",
                                " ATIVO "
            };

            for (int i = 0; i < headers.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(headers[i]);
            }

            for (int i = 0; i < headers.length; i++) {
                sheet.autoSizeColumn(i);
            }

            int rowNum = 1;
            for (Map<String, Object> row : dadosDoBanco) {
                Row dataRow = sheet.createRow(rowNum++);
                int colNum = 0;
                for (Map.Entry<String, Object> entry : row.entrySet()) {
                    Cell cell = dataRow.createCell(colNum++);
                    Object value = entry.getValue();

                    if (value instanceof String) {
                        cell.setCellValue((String) value);
                    } else if (value instanceof Integer) {
                        cell.setCellValue((Integer) value);
                    } else if (value instanceof BigDecimal) {
                        cell.setCellValue(((BigDecimal) value).doubleValue());
                    } else if (value instanceof Boolean) {
                        cell.setCellValue((Boolean) value);
                    } else if (value instanceof Date) {
                       cell.setCellValue(value.toString());
                    }
                }
            }

            workbook.write(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
