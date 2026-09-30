CREATE TABLE usuario (
    id INT PRIMARY KEY AUTO_INCREMENT,
    usuario VARCHAR(50) NOT NULL UNIQUE,
    senha VARCHAR(255) NOT NULL
);

INSERT INTO usuario (usuario, senha) VALUES ('cardoso','123456');

CREATE TABLE cliente (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    telefone VARCHAR(20),
    email VARCHAR(100),
    data_nascimento DATE
);

CREATE TABLE funcionario (
    id INT PRIMARY KEY AUTO_INCREMENT,
    codigo VARCHAR(20) NOT NULL UNIQUE,
    nome VARCHAR(100) NOT NULL,
    ativo BOOLEAN NOT NULL DEFAULT TRUE
);

CREATE TABLE veiculo (
    id INT PRIMARY KEY AUTO_INCREMENT,
    placa VARCHAR(10) NOT NULL UNIQUE,
    chassi VARCHAR(30),
    km INT,
    cliente_fk INT NOT NULL,
    CONSTRAINT fk_veiculo_cliente FOREIGN KEY (cliente_fk)
        REFERENCES cliente(id)
);

CREATE TABLE orcamento (
    id INT PRIMARY KEY AUTO_INCREMENT,
    data_criacao TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    data_entrada DATE,
    data_saida DATE,
    relato_cliente TEXT,
    total DECIMAL(10,2) NOT NULL DEFAULT 0.00,
    status VARCHAR(20) NOT NULL DEFAULT 'ABERTO',
    veiculo_fk INT NOT NULL,
    funcionario_fk INT NOT NULL,
    CONSTRAINT fk_orcamento_veiculo
        FOREIGN KEY (veiculo_fk) REFERENCES veiculo(id),
    CONSTRAINT fk_orcamento_funcionario
        FOREIGN KEY (funcionario_fk) REFERENCES funcionario(id)
);

CREATE TABLE peca (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE item_orcamento (
    id INT PRIMARY KEY AUTO_INCREMENT,
    quantidade INT NOT NULL,
    preco_unitario DECIMAL(10,2) NOT NULL,
    preco_final DECIMAL(10,2) NOT NULL,
    descricao VARCHAR(255),
    orcamento_fk INT NOT NULL,
    peca_fk INT,
    CONSTRAINT fk_item_orcamento FOREIGN KEY (orcamento_fk)
        REFERENCES orcamento(id),
    CONSTRAINT fk_item_peca FOREIGN KEY (peca_fk)
        REFERENCES peca(id)
);

INSERT INTO cliente (nome, telefone, email, data_nascimento)
VALUES ('João da Silva', '11999999999', 'joao@email.com', '1995-05-10');

INSERT INTO funcionario (codigo, nome, ativo)
VALUES ('HOM64', 'João Mecânico', TRUE);

INSERT INTO veiculo (placa, chassi, km, cliente_fk)
VALUES ('ABC1234', '123456789', 50000, 1);

INSERT INTO orcamento (data_entrada, data_saida, relato_cliente, total, status, veiculo_fk, funcionario_fk)
VALUES ('2026-09-05', NULL, 'Veículo apresentando problema no motor.', 100.00, 'ABERTO', 1, 1);

INSERT INTO cliente (nome, telefone, email, data_nascimento)
VALUES ('João', '11999999699', 'teste@email.com', '1995-05-10');

INSERT INTO veiculo (placa, chassi, km, cliente_fk)
VALUES ('ABC6234', '123456789', 50000, 2);

INSERT INTO orcamento (data_entrada, data_saida, relato_cliente, total, status, veiculo_fk, funcionario_fk)
VALUES ('2026-09-05', NULL, 'Veículo apresentando problema no motor.', 100.00, 'ABERTO', 2, 1);