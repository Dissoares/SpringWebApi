CREATE TABLE endereco (
                          id INT AUTO_INCREMENT PRIMARY KEY,
                          rua VARCHAR(100),
                          cep VARCHAR(9),
                          numero INT,
                          cidade VARCHAR(100),
                          estado VARCHAR(100),
                          pais VARCHAR(100),
                          ativo BOOLEAN,
                          data_criacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                          data_modificacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);


