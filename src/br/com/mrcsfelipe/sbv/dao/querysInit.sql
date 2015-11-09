#Nome do banco lp2a2
#Alterar a classe DAO


CREATE SEQUENCE seq_cliente;
CREATE SEQUENCE seq_produto;


CREATE TABLE cliente (

	id_cliente INTEGER DEFAULT NEXTVAL('seq_cliente') PRIMARY KEY,
	nome  VARCHAR(100),
	cpf VARCHAR(100),
	login VARCHAR(100),
	senha VARCHAR(100),
);
CREATE TABLE produto(
	
	id_produto INTEGER DEFAULT NEXTVAL('seq_produto') PRIMARY KEY,
	nome VARCHAR(100),
	data_fabricacao DATE,
	marca VARCHAR(100),
	modelo VARCHAR(100),
	preco REAL,
	qtd_estoque INTEGER
);

CREATE TABLE venda(
	id_venda BIGSERIAL PRIMARY KEY,
	data_venda DATE,
	produto_id INTEGER REFERENCES produto(id_produto),
	cliente_id INTEGER REFERENCES cliente(id_cliente)
);