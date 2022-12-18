CREATE DATABASE aop2;
USE aop2;
SET CHARACTER SET utf8;


CREATE TABLE clientes(
id INT NOT NULL auto_increment,
cpf VARCHAR(20) NOT NULL unique,
nome VARCHAR(80) NOT NULL,
endereco VARCHAR(150) NOT NULL,
telefone VARCHAR(30) NOT NULL,
cod_pais VARCHAR(5) NOT NULL,

PRIMARY KEY(id)
) DEFAULT charset = utf8;


INSERT INTO clientes
(cpf, nome, endereco, telefone, cod_pais)
values
('172.374.057-80','Antônia Priscila Ferreira','Rua São José 395 - Centro - Fundão - ES','2798728-5851','55'),
('312.463.787-95','Melissa Laís Brito','Rua São José 746 - Centro - Fundão - ES','2798640-5463','55'),
('791.165.747-53','Cristiane Sophie Mirella Nunes','Estrada Principal, s/n - Poço Dantas - Vargem Alta - ES','2898617-4855','55'),
('591.254.254-80','Carlos Eduardo Rodrigo Noah Porto','Travessa Parsonidas Carvalho - Velha Marabá - Marabá - PA','9499247-9515','55'),
('903.174.314-39','Heitor Davi Filipe Caldeira','Rua João Paulo Barbosa 997,  - Distrito de Ameixas - Ameixas - PE','8199178-3309','55');


CREATE TABLE aviao (
id INT AUTO_INCREMENT NOT NULL,
modelo INT,
fabricante VARCHAR(50),
tipo VARCHAR(50),
capacidade VARCHAR(50),

PRIMARY KEY(id)
)DEFAULT charset = utf8;

INSERT INTO aviao (`modelo`, `fabricante`, `tipo`, `capacidade`)
VALUES (777, "Boeing", "bimotor turbofan", 550);
INSERT INTO aviao (`modelo`, `fabricante`, `tipo`, `capacidade`)
VALUES (737, "Boeing", "bimotor turbofan", 215);
INSERT INTO aviao (`modelo`, `fabricante`, `tipo`, `capacidade`)
VALUES (320, "Airbus", "bimotor turbofan", 220);
INSERT INTO aviao (`modelo`, `fabricante`, `tipo`, `capacidade`)
VALUES (350, "Airbus", "bimotor turbofan", 440);
INSERT INTO aviao (`modelo`, `fabricante`, `tipo`, `capacidade`)
VALUES (757, "Boeing", "bimotor turbofan", 295);

CREATE TABLE aeroporto (
id INT AUTO_INCREMENT NOT NULL,
cod VARCHAR(5) NOT NULL,
nome VARCHAR(100),
endereco VARCHAR(100),

PRIMARY KEY(id)
)DEFAULT charset = utf8;

INSERT INTO aeroporto
(cod, nome , endereco)
VALUES
('GRU', 'Guarulhos','Rod. Hélio Smidt, Aeroporto, Guarulhos - SP, 07190-100'),
('CGH', 'Congonhas ','Av. Washington Luís, Vila Congonhas, São Paulo - SP, 04626-911'),
('FLN', 'Aeroporto Internacional de Florianópolis - Hercílio Luz','Rod. Ac. ao Aeroporto, Carianos, Florianópolis - SC, 88047-902'),
('ATL', 'Aeroporto Internacional de Atlanta Hartsfield-Jackson','6000 N Terminal Pkwy, Atlanta, GA 30320, United States'),
('DFW', 'Dallas/Fort Worth International Airport', '2400 Aviation Dr, DFW Airport, TX 75261, United States');



CREATE TABLE voo (
id INT AUTO_INCREMENT NOT NULL,
companhia VARCHAR(100),
horario TIME,
destino VARCHAR(100),
num INT,
cod INT,

PRIMARY KEY(id),
FOREIGN KEY(cod) REFERENCES aviao(id),
FOREIGN KEY(num) REFERENCES aeroporto(id)
)DEFAULT charset = utf8;

INSERT INTO voo
(companhia, horario, destino, num, cod)
VALUES
('GOL','15:30:00 ','São Paulo', 1, 1),
('TAM','10:00:00','São Paulo', 2, 2),
('AZUL','18:45:00','Florianópolis', 3, 3),
('AIR FRANCE','21:15:00','Atlanta', 4, 4),
('EMIRATES','01:00:00','Dallas', 5, 5);

CREATE TABLE passagem (
id INT NOT NULL auto_increment,
preco DECIMAL(10,2),
poltrona char(5),
classe VARCHAR(20),
data_passagem DATE,
cod_cliente INT,
cod_voo INT,
cod_aviao INT,

PRIMARY KEY(id),
FOREIGN KEY(cod_cliente) REFERENCES clientes(id),
FOREIGN KEY(cod_voo) REFERENCES voo(id),
FOREIGN KEY(cod_aviao) REFERENCES aviao(id)
)DEFAULT charset = utf8;


INSERT INTO passagem
(preco, poltrona, classe, data_passagem, cod_cliente, cod_voo, cod_aviao)
VALUES
(255.25, 'A1','Primeira Classe','2022-01-15', 1, 1, 1),
(121.88,'H24','Econômica','2022-02-05', 2, 2, 2),
(453.60,'B10','Executiva','2022-03-22', 3, 3, 3),
(1255.10,'A5','Executiva','2022-04-15', 4, 4, 4),
(3200.00,'C70','Econômica','2022-05-11', 5, 5, 5);


CREATE VIEW vw_ticket AS
SELECT clientes.id AS ID, clientes.nome AS Nome, clientes.cpf AS CPF, clientes.telefone AS Telefone,
		passagem.classe AS Classe, passagem.preco AS Preco, passagem.poltrona AS Poltrona, passagem.data_passagem AS Data,
		voo.horario ,voo.companhia AS Companhia, voo.destino AS Destino,
        aviao.fabricante AS Fabricante, aviao.tipo AS Modelo, aviao.capacidade AS Capacidade
FROM clientes
JOIN passagem ON clientes.id = passagem.cod_cliente
JOIN voo ON passagem.cod_voo = voo.id
JOIN aviao ON passagem.cod_aviao = aviao.id;


CREATE TABLE clientes_log (
id_log INT NOT NULL auto_increment,
usuario_log char(100) NOT NULL,
old_cpf VARCHAR(20) NOT NULL,
old_nome VARCHAR(80) NOT NULL,
old_endereco VARCHAR(150) NOT NULL,
old_telefone VARCHAR(30) NOT NULL,
old_ddd VARCHAR(5) NOT NULL,
data_log DATETIME NOT NULL,

PRIMARY KEY(id_log)
);

CREATE TRIGGER trigger_clientes_historico AFTER UPDATE ON clientes
FOR EACH ROW
INSERT INTO clientes_log 
(usuario_log, old_cpf, old_nome, old_endereco, old_telefone, old_ddd, data_log)
VALUES (USER(), new.cpf, new.nome, new.endereco, new.telefone, new.cod_pais, current_TIME());


CREATE FUNCTION nome_cpf (nome_nm VARCHAR(50), cpf_nm VARCHAR(20))
RETURNS VARCHAR(70) deterministic
RETURN CONCAT(nome_nm, ' ', cpf_nm);
SELECT id, nome_cpf(nome, cpf)
FROM clientes;

DELIMITER $$
CREATE PROCEDURE procedure_clientes (
p_cpf VARCHAR(20),
p_cliente VARCHAR(80),
p_endereco VARCHAR(150),
p_telefone VARCHAR(30),
p_cod_pais VARCHAR(5))

BEGIN
INSERT INTO clientes (cpf, nome, endereco, telefone, cod_pais)
VALUES (p_cpf, p_cliente, p_endereco, p_telefone, p_cod_pais);
COMMIT;
END; $$
DELIMITER ;

CALL procedure_clientes('864.985.352-21','Rodrigo Babisque','Rua Projetada - Vargem Alta - ES', '2796524-4355', '55');

SELECT * FROM clientes;