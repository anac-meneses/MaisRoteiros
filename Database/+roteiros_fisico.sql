CREATE DATABASE roteiros;
USE roteiros;

CREATE TABLE destinos (
cidade VARCHAR(20),
pais VARCHAR(20),
idDestino INTEGER PRIMARY KEY auto_increment
);

CREATE TABLE login (
tipo_permissao VARCHAR(20),
idLogin INTEGER PRIMARY KEY auto_increment
);

CREATE TABLE cliente (
cpf VARCHAR(20) PRIMARY KEY,
telefone INTEGER,
nome VARCHAR(50),
email VARCHAR(20),
senha VARCHAR(10),
idLogin INTEGER,
FOREIGN KEY(idLogin) REFERENCES login (idLogin)
);

CREATE TABLE compra (
valor INTEGER,
idCompra INTEGER PRIMARY KEY auto_increment,
dataCompra DATETIME,
quantidade INTEGER,
cpf VARCHAR(20),
idPacote INTEGER,
FOREIGN KEY(cpf) REFERENCES cliente (cpf)
);

CREATE TABLE pacotes (
translado VARCHAR(20),
hotel VARCHAR(20),
idPacote INTEGER PRIMARY KEY auto_increment,
qtNoites VARCHAR(10),
preco INTEGER,
idDestino INTEGER,
FOREIGN KEY(idDestino) REFERENCES destinos (idDestino)
);

CREATE TABLE funcionario (
idFuncionario INTEGER PRIMARY KEY auto_increment,
nome VARCHAR(90),
cpf VARCHAR(50),
senha VARCHAR(50),
telefone INTEGER,
email VARCHAR(50),
idLogin INTEGER,
FOREIGN KEY(idLogin) REFERENCES login (idLogin)
);

ALTER TABLE compra ADD FOREIGN KEY(idPacote) REFERENCES pacotes (idPacote);

CREATE VIEW `roteiros`.`clientelogin` AS
    SELECT 
        `c`.`cpf` AS `cpf`,
        `c`.`telefone` AS `telefone`,
        `c`.`nome` AS `nome`,
        `c`.`email` AS `email`,
        `c`.`senha` AS `senha`,
        `c`.`idLogin` AS `idLogin`,
        `l`.`idLogin` AS `login`,
        `l`.`tipo_permissao` AS `tipo_permissao`
    FROM
        (`roteiros`.`cliente` `c`
        JOIN `roteiros`.`login` `l`)
    WHERE
        `c`.`idLogin` = `l`.`idLogin`;
        
CREATE VIEW `roteiros`.`compras` AS
    SELECT 
        `c`.`valor` AS `valor`,
        `c`.`dataCompra` AS `dataCompra`,
        `c`.`idCompra` AS `idCompra`,
        `c`.`quantidade` AS `quantidade`,
        `cc`.`cpf` AS `cpf`,
        `p`.`idPacote` AS `idPacote`,
        `d`.`idDestino` AS `idDestino`
    FROM
        (((`roteiros`.`compra` `c`
        JOIN `roteiros`.`pacotes` `p`)
        JOIN `roteiros`.`cliente` `cc`)
        JOIN `roteiros`.`destinos` `d`)
    WHERE
        `c`.`idPacote` = `p`.`idPacote`
            AND `p`.`idDestino` = `d`.`idDestino`
            AND `cc`.`cpf` = `c`.`cpf`;
            
CREATE VIEW `roteiros`.`destino` AS
    SELECT 
        `p`.`idPacote` AS `idPacote`,
        `p`.`translado` AS `translado`,
        `p`.`hotel` AS `hotel`,
        `p`.`qtNoites` AS `qtNoites`,
        `p`.`idDestino` AS `idDestino`,
        `p`.`preco` AS `preco`,
        `d`.`idDestino` AS `destino`,
        `d`.`pais` AS `pais`
    FROM
        (`roteiros`.`pacotes` `p`
        JOIN `roteiros`.`destinos` `d`)
    WHERE
        `d`.`idDestino` = `p`.`idDestino`;

