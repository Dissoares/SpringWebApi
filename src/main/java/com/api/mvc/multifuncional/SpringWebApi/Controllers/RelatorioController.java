package com.api.mvc.multifuncional.SpringWebApi.Controllers;

import com.api.mvc.multifuncional.SpringWebApi.Services.RelatorioService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

@RestController
public class RelatorioController {

    @Autowired
    private RelatorioService relatorioService;

    @GetMapping("/relatorio/stream")
    public ResponseEntity<StreamingResponseBody> gerarRelatorioStream(HttpServletResponse response) {
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment; filename=relatorio.xlsx");

        StreamingResponseBody stream = outputStream -> {
            relatorioService.gerarRelatorio(outputStream);
        };

        return new ResponseEntity<>(stream, HttpStatus.OK);
    }
}
