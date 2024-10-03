CREATE TABLE PRODUTO (
    produto_id BIGINT PRIMARY KEY,
    data_inclusao TIMESTAMP(6) NOT NULL,
    descricao CHARACTER VARYING(255) NOT NULL,
    nome CHARACTER VARYING(255) NOT NULL,
    valor NUMERIC(38, 2) NOT NULL
);