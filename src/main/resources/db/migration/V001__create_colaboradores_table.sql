CREATE TABLE colaborador (
                             id INT AUTO_INCREMENT PRIMARY KEY,
                             nome VARCHAR(100),
                             cpf VARCHAR(14),
                             telefone VARCHAR(20),
                             email VARCHAR(100),
                             profissao VARCHAR(100),
                             salario DECIMAL(10, 2),
                             cargo VARCHAR(100),
                             data_contratacao DATE,
                             ativo BOOLEAN,
                             data_criacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                             data_modificacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);
