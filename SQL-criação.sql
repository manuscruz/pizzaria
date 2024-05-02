USE Pizzaria;

-- Criar tabela Clientes
CREATE TABLE IF NOT EXISTS Clientes (
    idCliente BIGINT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(50),
    telefone VARCHAR(100),
    endereco VARCHAR(200),
    login VARCHAR(30),
    senha VARCHAR(30)
);

-- Criar tabela Fornada
CREATE TABLE IF NOT EXISTS Fornada (
    idFornada TINYINT PRIMARY KEY AUTO_INCREMENT,
    numFornada TINYINT,
    qtdPizzas TINYINT
);

-- Criar tabela Pedido
CREATE TABLE IF NOT EXISTS Pedido (
    idPedido BIGINT PRIMARY KEY AUTO_INCREMENT,
    IdClente BIGINT,
    IdFornada TINYINT,
    dataHora TIMESTAMP,
    FOREIGN KEY (IdClente) REFERENCES Clientes(idCliente),
    FOREIGN KEY (IdFornada) REFERENCES Fornada(idFornada)
);

-- Criar tabela Tamanho
CREATE TABLE IF NOT EXISTS Tamanho (
    Idtamanho TINYINT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(50),
    desconto FLOAT
);

-- Criar tabela Pizza
CREATE TABLE IF NOT EXISTS Pizza (
    idPizza INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(50),
    precoBase FLOAT,
    personalizada BOOLEAN
);

-- Criar tabela PizzaPedida
CREATE TABLE IF NOT EXISTS PizzaPedida (
    IdPizzaPedida BIGINT PRIMARY KEY AUTO_INCREMENT,
    IdPedido BIGINT,
    idPizza INT,
    idTamanho TINYINT,
    quantidade TINYINT,
    FOREIGN KEY (IdPedido) REFERENCES Pedido(idPedido),
    FOREIGN KEY (idPizza) REFERENCES Pizza(idPizza),
    FOREIGN KEY (idTamanho) REFERENCES Tamanho(Idtamanho)
);

-- Criar tabela Bebida
CREATE TABLE IF NOT EXISTS Bebida (
    idBebida INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(50),
    preco FLOAT
);

-- Criar tabela BebidaPedida
CREATE TABLE IF NOT EXISTS BebidaPedida (
    idPedido BIGINT,
    idBebida INT,
    quantidade TINYINT,
    FOREIGN KEY (idPedido) REFERENCES Pedido(idPedido),
    FOREIGN KEY (idBebida) REFERENCES Bebida(idBebida)
);

-- Criar tabela Ingredientes
CREATE TABLE IF NOT EXISTS Ingredientes (
    IdIngredientes INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(50),
    preco FLOAT
);


-- Criar tabela PizzaPedida_has_Ingredientes
CREATE TABLE IF NOT EXISTS PizzaPedida_has_Ingredientes (
    IdPizzaPedida BIGINT,
    idIngredientes INT,
    FOREIGN KEY (IdPizzaPedida) REFERENCES PizzaPedida(IdPizzaPedida),
    FOREIGN KEY (idIngredientes) REFERENCES Ingredientes(idIngredientes)
);