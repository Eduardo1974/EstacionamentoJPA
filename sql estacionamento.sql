CREATE DATABASE estacionamento;
USE estacionamento;


CREATE TABLE municipio (
	id_municipio	INT NOT NULL AUTO_INCREMENT,
    nome			VARCHAR(50) UNIQUE,
    estado			VARCHAR(2),
    
    PRIMARY KEY(id_municipio)
);
CREATE TABLE veiculo (
	id_veiculo		INT NOT NULL AUTO_INCREMENT,
    placa			VARCHAR(9) UNIQUE,
	marca 			VARCHAR(50),
    modelo			VARCHAR(50),
    categoria		VARCHAR(50),
    id_cliente		INT,
    
    
	PRIMARY KEY(id_veiculo)
);

CREATE TABLE cliente (
	id_cliente		INT NOT NULL AUTO_INCREMENT,
    nome			VARCHAR(50),
    cpf				VARCHAR(14) UNIQUE,
    id_municipio	INT,
 
    
	PRIMARY KEY(id_cliente)
);

CREATE TABLE movimentacao (
	id_movimentacao 	INT NOT NULL AUTO_INCREMENT,
    id_veiculo			INT,
    data_hora_entrada	BIGINT,
    data_hora_saida		BIGINT,

	PRIMARY KEY(id_movimentacao)
);


ALTER TABLE veiculo ADD CONSTRAINT FK_veiculo_proprietario FOREIGN KEY (id_cliente) REFERENCES cliente (id_cliente);
ALTER TABLE cliente ADD CONSTRAINT FK_cliente_municipio FOREIGN KEY (id_municipio) REFERENCES municipio (id_municipio);
ALTER TABLE movimentacao ADD CONSTRAINT FK_veiculo_movimentacao FOREIGN KEY (id_veiculo) REFERENCES veiculo (id_veiculo);


select * from movimentacao;
select * from municipio;

SELECT 
	V.PLACA, V.MODELO, M.NOME 
FROM VEICULO V
	INNER JOIN MUNICIPIO M ON V.ID_MUNICIPIO = M.ID_MUNICIPIO 
WHERE M.NOME  = "SJC";

select * from cliente;

drop database estacionamento;