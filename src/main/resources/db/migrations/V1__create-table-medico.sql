CREATE TABLE medicos (
    id BIGSERIAL NOT NULL,
    nome VARCHAR(100) NOT NULL,
    especialidade VARCHAR(100) NOT NULL,
    crm VARCHAR(100) NOT NULL UNIQUE,
    telefone VARCHAR(100),
    email VARCHAR(100) NOT NULL UNIQUE,
    rua VARCHAR(100) NOT NULL,
    numero VARCHAR(100),
    complemento VARCHAR(100),
    bairro VARCHAR(100) NOT NULL,
    cidade VARCHAR(100) NOT NULL,
    estado VARCHAR(100) NOT NULL,
    cep VARCHAR(100) NOT NULL UNIQUE,

    PRIMARY KEY (id)
)

