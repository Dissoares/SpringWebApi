CREATE TABLE empresa (
                         id INT AUTO_INCREMENT PRIMARY KEY,
                         nome VARCHAR(100),
                         cnpj VARCHAR(18),
                         telefone VARCHAR(20),
                         endereco_id INT,
                         ativo BOOLEAN,
                         data_criacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                         data_modificacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                         FOREIGN KEY (endereco_id) REFERENCES endereco(id)
);

ALTER TABLE colaborador
    ADD empresa_id INT,
ADD FOREIGN KEY (empresa_id) REFERENCES empresa(id);