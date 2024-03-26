CREATE DATABASE ex3
-- tabelas
CREATE TABLE produtos(
    id_produto SERIAL PRIMARY KEY NOT NULL,
    nome_produto VARCHAR(100),
    qtde INT NOT NULL,
    valor DECIMAL(7,2)
)

CREATE TABLE cliente(
    codigo_cliente INT NOT NULL,
    nome VARCHAR(20) NOT NULL,
    endereco VARCHAR (20) NOT NULL,
    cep CHAR(8) NOT NULL,
    uf CHAR(2) NOT NULL,
    cnpj CHAR(20) NOT NULL,
    ie CHAR(20) NOT NULL,
    PRIMARY KEY(codigo_cliente) 
);

CREATE TABLE vendedor(
    codigo_vendedor INT NOT NULL,
    nome_vendedor VARCHAR(20) NOT NULL,
    salario DECIMAL(7,2) NOT NULL,
    fsalarial CHAR(1) NOT NULL,
    PRIMARY KEY(codigo_vendedor)
);

CREATE TABLE cadfun(
    codfun INT NOT NULL PRIMARY KEY,
    nome VARCHAR(40) NOT NULL,
    depto CHAR(2),
    funcao CHAR(20),
    salario NUMERIC(10,2),
    filhos INT NOT NULL
);

-- SELECTS
SELECT nome_produto FROM produtos

SELECT codfun, nome, salario +250 as salarioAU FROM cadfun

SELECT funcao from cadfun

WHERE funcao = 'Analista';

SELECT salario FROM cadfun, vendedor
WHERE salario > 1700.00;

SELECT salario FROM cadfun, vendedor
WHERE salario < 1700.00;

SELECT salario FROM cadfun, vendedor
WHERE salario = 1700.00;

SELECT * from cadfun
WHERE funcao IN ('Programador', 'Analista', 'Programador')
ORDER BY funcao;

SELECT * from cadfun
WHERE (funcao ='Programador') OR ( funacao ='Analista', 'Programadora') (AND salario > 1200.00);

SELECT * cadfun
WHERE NOT((funacao = 'Analista') OR (funcao ='Programador'));

SELECT * cadfun
WHERE filhos IN (2,4) and filhos = 3;

SELECT * cadfun
WHERE filhos IN (2,4) AND (salario < 2000.00);

SELECT * cadfun
WHERE ((filhos < 2) OR (filhos > 3));

SELECT * FROM cadfun
WHERE ((filhos < 2) OR (filhos > 3)) AND(filhos !=0);

SELECT * FROM cadfun
WHERE filhos in (2,3);


-- INSERTS
INSERT INTO produtos
VALUES(DEFAULT, 'MOUSE', 10, '45.00');

INSERT INTO cliente
VALUES(1, 'mauricio', 'rua lima' '123456-7' 'RL' '987654321' 'rua L');

INSERT INTO cliente
VALUES(2, 'rodrigo', 'rua lis' '123456-8' 'RL' '987654322' 'rua X');

INSERT INTO cliente
VALUES(3, 'caetano', 'rua lau' '123456-9' 'RL' '987654323' 'rua O');

INSERT INTO cliente
VALUES(4, 'renan', 'rua lix' '123456-1' 'RL' '987654324' 'rua Y');

INSERT INTO cliente
VALUES(5, 'jonathan', 'rua lel' '123456-2' 'RL' '987654325' 'rua Z');

INSERT INTO vendedor
VALUES(1, 'ronaldo', 1680.00, 1);

INSERT INTO vendedor
VALUES(2, 'julia', 1700.00, 2);

INSERT INTO vendedor
VALUES(3, 'roni', 3200.90, 3);

INSERT INTO vendedor
VALUES(4, 'maria', 3300.90, 4);

INSERT INTO vendedor
VALUES(5, 'murilo', 3400.90, 5);

INSERT INTO cadfun
VALUES(1, 'leticia', 'QL', 'Monitorar', '21000.00', );

INSERT INTO cadfun
VALUES(2, 'luciana', 'TI', 'Programadora', '22000.00', 2);

INSERT INTO cadfun
VALUES(3, 'luciano', 'TI', 'Programador', '22000.00', 3);

INSERT INTO cadfun
VALUES(4, 'romario', 'MT', 'Manutencao', '23000.00', );
INSERT INTO cadfun
VALUES(5, 'leandro', 'MG', 'Montagem', '24000.00', 3);

INSERT INTO cadfun
VALUES(6, 'julio', 'AN', 'Analista', '25000.00', 2);

INSERT INTO cadfun
VALUES(7, 'rebeca', 'AN', 'Analista', '25000.00', 4);




