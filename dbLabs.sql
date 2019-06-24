##########################################################################
#-------São Paulo(2019)
#-------Trabalho de Laboratorio de Banco de Dados
#-------TrocaJogos - Sistema de troca de jogos em mídia fisica para consoles
#-------Vitor de Barros Loureiro - RA: 1110481623049
#-------Andrei Duarte de Lima - RA: 1110481822046
#-------Felipe Nascimento Gomes - RA: 1525409

#-------Criação do BD
CREATE DATABASE dbLabs;
USE dbLabs;

#-------Criação das Tabelas
CREATE TABLE Jogo (
jogId int4,
jogNome varchar(30),
jogAvaliacao varchar(10),
jogOpiniao varchar(400),
jogDescricao varchar(400),
jogFoto varchar(100),
usuIdProprietario int4,
jogEmprestavel boolean,
jogTrocavel boolean
);

CREATE TABLE Usuario (
usuId int4,
usuNome varchar(30),
usuLogin varchar(20),
usuSenha varchar(30),
usuApelido varchar(30),
usuEmail varchar(50),
usuDataNascimento varchar(24),
usuFoto varchar(100)
);

CREATE TABLE Troca (
trcId int4,
trcAceiteInicial varchar(30), -- entender real necessidade
trcAceiteFinal varchar(30), -- entender real necessidade
trcDataTroca varchar(30),
usuIdSolicitante int4, -- quem solicita a troca
usuIdCedente int4 -- quem aceita ou rejeita a troca
);
-- criar trigger para atualizar o registro na tabela jogo
CREATE TABLE Troca_Jogos ( -- associativa que mapeia a troca e os jogos envolvidos
tcjId int4,
trcId int4,
jogIdSolicitante int4, -- id do jogo solicitado na proposta
jogIdSolicitado int4 -- id do jogo a ser enviado na troca pelo jogo solicitado
);

CREATE TABLE Amigo (
amgId int4,
usuIdAmigoSolicitante int4, -- nada mais do que o codigo do outro usuario
usuIdAmigoSolicitado int4, 
amgNome varchar(30),
amgDataInicio varchar(24) -- controlar pedidos de amizade atraves de amzDataInicio = null
);

CREATE TABLE Emprestimo (
empId int4,
jogIdJogoEmprestado int4, -- fk do jogo a ser emprestado
empDataEmprestimo varchar(24),
empDataDevolucao varchar(24),
empDataDevolucaoEfetiva varchar(24), -- para encontrar emprestimos em aberto, empDataDevolucaoEfetiva = null
usuIdSolicitante int4, -- fk usuario
usuIdCedente int4 -- fk usuario
);

CREATE TABLE Dialogo (
dlgId int4,
dlgRemetente varchar(30), -- fk usuario
dlgDestinatario varchar(30), -- fk usuario
dlgDescricao varchar(300),
dlgTroca varchar(100)
);

CREATE TABLE Roles (
rldId int4,
rldRole varchar(30)
);

CREATE TABLE UserRole (
urlId int4,
roldId int4,
usuId int4
);

CREATE TABLE Desejo (
dsjId int4,
dsjIdUsuario int4,
dsjNomeJogo varchar(30),
dsjDataRegistroDesejo varchar(30),
dsjDescricaoJogo varchar(255)
);

#-------Criação de PKs
ALTER TABLE Jogo ADD CONSTRAINT pk_jogo PRIMARY KEY (jogId);
ALTER TABLE Usuario ADD CONSTRAINT pk_usuario PRIMARY KEY (usuId);
ALTER TABLE Troca ADD CONSTRAINT pk_troca PRIMARY KEY (trcId);
ALTER TABLE Troca_jogos ADD CONSTRAINT pk_troca_jogos PRIMARY KEY (tcjId);
ALTER TABLE Amigo ADD CONSTRAINT pk_amizade PRIMARY KEY (amgId);
ALTER TABLE Emprestimo ADD CONSTRAINT pk_emprestimo PRIMARY KEY (empId);
ALTER TABLE Dialogo ADD CONSTRAINT pk_dialogo PRIMARY KEY (dlgId);
ALTER TABLE Roles ADD CONSTRAINT pk_role PRIMARY KEY (rldId);
ALTER TABLE Desejo ADD CONSTRAINT pl_desejo PRIMARY KEY (djsId);

#-------Criação de FKs
ALTER TABLE Amigo
	ADD CONSTRAINT fk_usuario_amizade
	FOREIGN KEY(usuIdAmigoSolicitante, usuIdAmigoSolicitado) REFERENCES Usuario(usuId);

ALTER TABLE Jogo
	ADD CONSTRAINT fk_jogo_usuario
    FOREIGN KEY(usuIdProprietario) REFERENCES Usuario(usuId);
    
ALTER TABLE Troca
		ADD CONSTRAINT fk_troca_usuarios
        FOREIGN KEY(usuIdSiolicitante, usuIdCedente) REFERENCES Usuario(usuId);
       
ALTER TABLE Troca_Jogos
		ADD CONSTRAINT fk_troca_jogos
        FOREIGN KEY (jogIdSolicitante, jogIdSolicitado) REFERENCES Jogo(jogId);

ALTER TABLE Amigo
	ADD CONSTRAINT fk_amizade
    FOREIGN KEY (usuIdAmigoSolicitante, usuIdAmigoSolicitado) REFERENCES Usuario(usuId);
    
ALTER TABLE Emprestimo
		ADD CONSTRAINT fk_emprestimo_jogo
        FOREIGN KEY(jogIdJogoEmprestado) REFERENCES Jogo(jogId);

ALTER TABLE Emprestimo
		ADD CONSTRAINT fk_emprestimo_usuario
        FOREIGN KEY(usuIdSolicitante, usuIdCedente) REFERENCES Usuario(usuId);
        
ALTER TABLE Dialogo
		ADD CONSTRAINT fk_dialogo_usuario
        FOREIGN KEY(dlgRemetente, dlgDestinatario) REFERENCES Usuario(usuId);
        
ALTER TABLE Desejo
		ADD CONSTRAINT fk_desejo_usuario
        FOREIGN KEY (dsjIdUsuario) REFERENCES Usuario(usuId);

ALTER TABLE UserRole
		ADD CONSTRAINT fk_user_role
        FOREIGN KEY () REFERENCES Usuario(usuId);
        
#-------Criação de Procedures (inclui procedure de relatorio)
#-------PR1_Lista_Usuarios
DROP PROCEDURE IF EXISTS PR1_Lista_Usuarios;
DELIMITER $$
CREATE PROCEDURE PR1_Lista_Usuarios()
BEGIN

DECLARE fim INTEGER DEFAULT 0;
DECLARE id INT4;
DECLARE nome VARCHAR(30);
DECLARE login VARCHAR(20);
DECLARE apelido VARCHAR(30);
DECLARE email VARCHAR(50);
DECLARE foto VARCHAR(100);

#-------Cursor
DECLARE c1 CURSOR FOR SELECT usuId, usuNome, usuLogin, usuApelido, usuEmail, usuFoto FROM Usuario;
DECLARE CONTINUE HANDLER FOR NOT FOUND SET fim = 1;

DROP TABLE IF EXISTS temp_usuario;
CREATE TEMPORARY TABLE temp_usuario (
usuId int4, 
usuNome varchar(30), 
usuLogin varchar(20), 
usuApelido varchar(30), 
usuEmail varchar(50), 
usuFoto varchar(100));

OPEN c1;
laco: LOOP

FETCH c1 INTO id, nome, login, apelido, email, foto;
	IF fim = 0 THEN
		INSERT INTO temp_usuario VALUES (id, nome, login, apelido, email, foto);
	ELSEIF fim = 1 THEN
		LEAVE laco;
	END IF;

END LOOP laco;
CLOSE c1;

SELECT *
FROM temp_usuario;
	
END $$
DELIMITER ;

#-------PR2_Lista_Jogos
DROP PROCEDURE IF EXISTS PR2_Lista_Jogos;
DELIMITER $$
CREATE PROCEDURE PR2_Lista_Jogos(IN idProprietario INT4)
BEGIN

DECLARE fim INTEGER DEFAULT 0;
DECLARE id INT4;
DECLARE nome VARCHAR(30);
DECLARE avaliacao VARCHAR(10);
DECLARE opiniao VARCHAR(400);
DECLARE descricao VARCHAR(400);
DECLARE foto VARCHAR(100);
DECLARE proprietario INT4;
DECLARE emprestavel BOOLEAN;
DECLARE trocavel BOOLEAN;

#-------Cursor
DECLARE c2 CURSOR FOR SELECT jogId, jogNome, jogAvaliacao, jogOpiniao, jogDescricao, jogFoto, usuIdProprietario, jogEmprestavel, jogTrocavel 
FROM Jogo
WHERE usuIdProprietario = idProprietario;
DECLARE CONTINUE HANDLER FOR NOT FOUND SET fim = 1;

DROP TABLE IF EXISTS temp_jogos;
CREATE TEMPORARY TABLE temp_jogos (
id INT4,
fim INTEGER DEFAULT 0,
nome VARCHAR(30),
avaliacao VARCHAR(10),
opiniao VARCHAR(400),
descricao VARCHAR(400),
foto VARCHAR(100),
proprietario INT4,
emprestavel BOOLEAN,
trocavel BOOLEAN);

OPEN c2;
laco: LOOP

FETCH c2 INTO id, nome, avaliacao, opiniao, descricao, foto, proprietario, emprestavel, trocavel;
	IF fim = 0 THEN
		INSERT INTO temp_jogos VALUES (id, nome, avaliacao, opiniao, descricao, foto, proprietario, emprestavel, trocavel);
	ELSEIF fim = 1 THEN
		LEAVE laco;
	END IF;

END LOOP laco;
CLOSE c2;

SELECT *
FROM temp_jogos;
	
END $$
DELIMITER ;


#-------Criação de Triggers
#-------TR1_Impede_Jogo_Sem_Dono
DELIMITER $$
DROP TRIGGER IF EXISTS dbLabs.TR1;
USE dbLabs;
CREATE TRIGGER dbLabs.TR1 BEFORE INSERT ON dbLabs.Jogo
FOR EACH ROW
BEGIN
SET @valid = (SELECT usuId FROM Usuario WHERE usuId = NEW.usuIdProprietario);
	IF @valid IS NULL THEN
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = "ERRO AO INSERIR - Jogo sem Proprietário. Verifique ou entre em contato com o ADM.";
	END IF;
END$$
DELIMITER ;

#-------TR2_Impede_Jogo_Sem_Dono
DELIMITER $$
DROP TRIGGER IF EXISTS dbLabs.TR2;
USE dbLabs;
CREATE TRIGGER dbLabs.TR2 BEFORE UPDATE ON dbLabs.Jogo
FOR EACH ROW
BEGIN
SET @valid = (SELECT usuId FROM Usuario WHERE usuId = NEW.usuIdProprietario);
	IF @valid IS NULL THEN
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = "ERRO AO ATUALIZAR - Jogo sem Proprietário. Verifique ou entre em contato com o ADM.";
	END IF;
END$$
DELIMITER ;
