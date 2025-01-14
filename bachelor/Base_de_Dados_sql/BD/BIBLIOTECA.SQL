DROP TABLE IF EXISTS FUNCIONARIO,NUM_TELEFONE_FUNC,CLIENTE,NUM_TELEFONE_CLIENTE,ATENDIDO_POR,
ARTIGO,AREA_CIENTIFICA,SALA_DE_ESTUDO,CADEIRA,EVENTO,PISO,ASSISTIDO,RECOMENDADO_POR_CADEIRA,
USADO_POR_EVENTO, RESPONSAVEL_PELO_EVENTO;

CREATE TABLE
FUNCIONARIO
(
  NumMec  BIGint PRIMARY KEY,
  Nome    VARCHAR(128) NOT NULL,
  Email   VARCHAR(64) NOT NULL,
  Sexo    ENUM('F', 'M') NOT NULL,
  TrabFaz VARCHAR(64) NOT NULL,
  DataNasc DATE NOT NULL,
  MRua VARCHAR(128) NOT NULL,
  MNum INT NOT NULL,
  MAndar INT DEFAULT NULL,
  MLocalidade VARCHAR(128) NOT NULL,
  MCodPostal VARCHAR(8) NOT NULL,
  Limpeza int DEFAULT NULL,
  DataHora datetime default NULL

);

CREATE TABLE
NUM_TELEFONE_FUNC
(
  NumMec bigint not NULL,
  Telefone bigINT NOT NULL,
  PRIMARY KEY(NumMec,Telefone)
);

CREATE TABLE
CLIENTE
(
  NumMec  BIGint prIMARY KEy,
  Nome    VARCHAR(128) NOT NULL,
  Email   VARCHAR(64) NOT NULL,
  Sexo    ENUM('F', 'M') NOT NULL,
  DataNasc DATE NOT NULL,
  MRua VARCHAR(128) NOT NULL,
  MNum INT NOT NULL,
  MAndar INT DEFAULT NULL,
  MLocalidade VARCHAR(128) NOT NULL,
  MCodPostal VARCHAR(8) NOT NULL,
  FimMulta date DEFAULT NULL,
  Departamento VARCHAR(64) NOT NULL,
  Reservou int DEFAULT NULL,
  Inicio time default NULL,
  Fim time default NULL
);

CREATE TABLE
NUM_TELEFONE_CLIENTE
(
  NumMec BIGint NOT NULL,
  Telefone bigINT NOT NULL,
  PRIMARY KEY(NumMec,Telefone)
);
 
CREATE TABLE
ATENDIDO_POR
(
  Cliente BIGINT NOT NULL,
  Funcionario BIGINT NOT NULL,
  PRIMARY KEY(Cliente,Funcionario),
  Tipo ENUM('Requisição de artigo', 'Devolução de artigo', 'Inscrição em evento') NOT NULL,
  DataHora DATETIME NOT NULL
  );

CREATE TABLE
ARTIGO
(
  Codigo int PRIMARY KEY AUTO_INCREMENT,
  Titulo VARCHAR(128) DEFAULT NULL,
  Autor VARCHAR(128) DEFAULT NULL,
  NumPaginas INT DEFAULT NULL,
  Volume INT DEFAULT NULL,
  Tipo ENUM('Enciclopédia', 'Livro didático','Jornal','Dicionário','Tese de Doutoramento',
            'Dissertação de Mestrado','Calculadora') not NULL,
  Disponibilidade eNUM('SIM','NÃO') NOT NULL,
  Localizacao INT DEFAULT '1',
  Estante int default NULL,
  Seccao INt DEFAULT NULL,
  Requisitado BIGINT DEFAULT NULL,
  DataHora DATETIME DEFAULT NULL
);

CREATE TABLE
AREA_CIENTIFICA
(
  Artigo int NOT NULL,
  Area VARCHAR(128) NOT NULL,
  PRIMARY KEY (Artigo, Area)
);

CREATE TABLE
SALA_DE_ESTUDO
(
  Codigo int PRIMARY KEY AUTO_INCREMENT,
  Capacidade INT NOT NULL,
  NumPCs INT NOT NULL,
  LimiteTempo TIME NOT NULL,
  Localizado INT NOT NULL,
  Especificamente VARCHAR(128) DEFAULT NULL
);

CREATE TABLE
CADEIRA
(
  Codigo int PRIMARY KEY AUTO_INCREMENT,
  Nome VARCHAR(128) NOT NULL,
  Departamento VARCHAR(128) NOT NULL,
  Regente BIGint NOT NULL,
  DataInicio date not NULL
);

CREATE TABLE
EVENTO
(
  Codigo int PRIMARY KEY AUTO_INCREMENT,
  Capacidade INT NOT NULL,
  DataHora DATETIME NOT NULL,
  Tipo ENUM('Palestra','Seminário','Exposição','Visita de estudo') NOT NULL,
  Decorre INT NOT NULL,
  Duracao time not NULL,
  RazaoEspecifica VARCHAR(128) DEFAULT NULL,
  CadeiraAssociada int Default NULL,
  TemaReferido VARCHAR(128) DEFAULT NULL
);

CREATE TABLE
PISO
(
  Num int PRIMARY KEY AUTO_INCREMENT,
  NumEspacoLeitura INT DEFAULT NULL
);

CREATE TABLE
AREAS_PISO
( 
Piso INT NOT NULL,
Area VARCHAR(128) DEFAULT NULL
);

  
CREATE TABLE
INSCRICAO
(
  Cliente BIGINT NOT NULL,
  Evento INT NOT NULL,
  NumEntrada INT Not NULL,
  PRIMARY KEY(Cliente,Evento)
);

CREATE TABLE
RECOMENDADO_POR_CADEIRA
(
  Artigo INT NOT NULL,
  Cadeira int NOT NULL,
  GrauObrigatoriadade ENUM('Leitura Obrigatoria','Leitura Complementar') not NULL,
  Temas VARCHAR(128) DEFAULT NULL,
  PRIMARY KEY(Artigo,Cadeira)
);

CREATE TABLE
USADO_POR_EVENTO
(
  Artigo INT NOT NULL,
  Evento INT NOT NULL,
  Justificacao TEXT DEFAULT 'Sem justificacoes a dar.',
  PRIMARY KEY(Artigo,Evento)
);

CREATE TABLE
RESPONSAVEL_PELO_EVENTO
(
  Evento INT NOT NULL,
  Funcionario BIGINT NOT NULL,
  Funcao ENUM('Orador','Fotografo','Ajudante','Tradutor','Coordenador de eventos') NOT NULL,
  PRIMARY KEY(Evento,Funcionario)
);


ALTER TABLE NUM_TELEFONE_FUNC ADD FOREIGN KEY(NumMec) REFERENCES FUNCIONARIO(NumMec) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE NUM_TELEFONE_CLIENTE ADD FOREIGN KEY(NumMec) REFERENCES CLIENTE(NumMec) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE AREA_CIENTIFICA ADD FOREIGN KEY(Artigo) REFERENCES ARTIGO(Codigo) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE AREAS_PISO ADD FOREIGN KEY(Piso) REFERENCES PISO(Num) ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE FUNCIONARIO ADD FOREIGN KEY(Limpeza) REFERENCES PISO(Num) on update CASCADE ON DELETE CASCADE;
alter table CLIENTE ADD FOREIGN KEY (Reservou) REFERENCES SALA_DE_ESTUDO(Codigo) on update CASCADE ON DELETE CASCADE;
alter table ATENDIDO_POR ADD FOREIGN KEY (Cliente) REFERENCES CLIENTE(NumMec) on update CASCADE ON DELETE CASCADE;
alter table ATENDIDO_POR ADD FOREIGN KEY (Funcionario) REFERENCES FUNCIONARIO(NumMec) on update CASCADE ON DELETE CASCADE;
ALTER TABLE ARTIGO ADD FOREIGN KEY (Localizacao) REFERENCES PISO(Num) ON UPDATE CASCADE ON DELETE SET DEFAULT;
aLTER TABLE ARTIGO ADD FOREIGN KEY (Requisitado) REFERENCES CLIENTE(NumMec) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE SALA_DE_ESTUDO ADD FOreign key (Localizado) REFERENCES PISO(Num) ON DELETE CASCADE on update CASCADE;
ALTER TABLE CADEIRA ADD FOREIGN KEY(Regente) REFERENCES FUNCIONARIO(NumMec) on update CASCADE ON DELETE CASCADE;
ALTER TABLE EVENTO ADD FOREIGN KEY(Decorre) REFERENCES SALA_DE_ESTUDO(Codigo) on update CASCADE ON DELETE CASCADE;
ALTER TABLE EVENTO ADD FOREIGN KEY(CadeiraAssociada) REFERENCES CADEIRA(Codigo) on update CASCADE ON DELETE CASCADE;
ALTER TABLE INSCRICAO ADD FOREIGN KEY(Cliente) REFERENCES CLIENTE(NumMec) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE INSCRICAO ADD FOREIGN KEY(Evento) REFERENCES EVENTO(Codigo) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE RECOMENDADO_POR_CADEIRA ADD FOREIGN KEY(Artigo) REFERENCES ARTIGO(Codigo) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE RECOMENDADO_POR_CADEIRA ADD FOREIGN KEY(Cadeira) REFERENCES CADEIRA(Codigo) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE USADO_POR_EVENTO ADD FOREIGN KEY(Evento) REFERENCES EVENTO(Codigo) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE USADO_POR_EVENTO ADD FOREIGN KEY(Artigo) REFERENCES ARTIGO(Codigo) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE RESPONSAVEL_PELO_EVENTO ADD FOREIGN KEY(Funcionario) REFERENCES FUNCIONARIO(NumMec) on update CASCADE ON DELETE CASCADE;
ALTER TABLE RESPONSAVEL_PELO_EVENTO ADD FOREIGN KEY(Evento) REFERENCES EVENTO(Codigo) on update CASCADE ON DELETE CASCADE;


INSERT INTO CLIENTE(NumMec,Nome,Email,Sexo,DataNasc,MRua,MNum,MAndar,MLocalidade,MCodPostal,Departamento)
VALUES	
	('4954236157', 'Miguel', '4954236157@gmail.com', 'M', '2000-05-09','Rua das Flores','5',NULL,
    'Porto','5569-226','Matemática'),
    ('4954236158', 'Joana', '4954236158@gmail.com', 'F', '1998-09-08','Rua 5 de Outubro','98',NULL,
    'Porto','5569-569','Física'),
    ('4954236159', 'João', '4954236159@gmail.com', 'M', '2000-12-04','Rua da Alegria','60','2',
    'Porto','5569-260','Ciências de Computadores'),
    ('4954236167', 'António', '4954236167@gmail.com', 'M', '2001-07-09','Rua Candido dos Reis','61',NULL,
    'Porto','5569-275','Matemática'),
    ('4954236168', 'Ana', '4954236168@gmail.com', 'F', '2003-10-03','Rua das Flores','10',NULL,
    'Porto','5569-226','Química'),
    ('4954236169', 'Helena', '4954236169@gmail.com', 'F', '1999-01-03','Rua Lages de Cima','16',NULL,
    'Coimbra','5458-589','Matemática'),  
     ('4954236179', 'Teresa', '4954236179@gmail.com', 'F', '2001-01-04','Rua de Paredes','6',NULL,
    'Porto','4425-533','Matemática'),
     ('4954236180', 'Leonardo', '4954236180@gmail.com', 'M', '1999-07-03','Rua Ilha de Moçambique','92','6',
    'Porto','4485-416','Física'),
     ('4954236181', 'Joaquim', '4954236181@gmail.com', 'M', '1998-09-23','Rua Bento Carqueja','65',NULL,
    'Porto','4350-061','Ciências de Computadores'),
     ('4954236182', 'Guilherme', '4954236182@gmail.com', 'M', '2003-06-24','Rua da Formiga','59',NULL,
    'Porto','5358-559','Matemática');
   
INSERT INTO FUNCIONARIO(NumMec,Nome,Email,Sexo,TrabFaz,DataNasc,MRua,MNum,MAndar,MLocalidade,MCodPostal)
VALUES	
	('8615768878', 'Madalena', '8615768878@gmail.com', 'F','Professor', '1998-12-30','Rua das Flores','7',NULL,
    'Porto','5569-226'),
    ('8615768879', 'Maria', '8615768879@gmail.com', 'F', 'Auxiliar da Biblioteca','1998-11-29','Rua Nova do Casal','98',NULL,
    'Porto','5469-561'),
    ('8615768880', 'Pedro', '8615768880@gmail.com', 'M', 'Auxiliar da Biblioteca','1990-12-04','Rua da Alegria','60','2',
    'Porto','5589-548'),
    ('8615768881', 'Filipe', '8615768881@gmail.com', 'M', 'Segurança','1970-07-09','Rua Jacinto Freire de Andrade','61','8',
    'Beja','5856-275'),
    ('8615768882', 'Filipa', '8615768882@gmail.com', 'F','Professor', '1980-08-09','Rua de Portugal','61',NULL,
    'Faro','5589-261'),
    ('8615768883', 'Tiago', '8615768883@gmail.com', 'M', 'Professor','1985-10-03','Rua Bairro dos Pescadores','10',NULL,
    'Albufeira','8200-129'),
    ('8615768884', 'Manuel', '8615768884@gmail.com', 'M','Professor', '1969-01-03','Rua Lages de Cima','16','50',
    'Coimbra','5458-589'),
    ('8615768885', 'Cátia', '8615768885@gmail.com', 'F', 'Professor','1987-04-03','Rua de Santo António','36',NULL,
    'Vila Real','5000-596'),
    ('8615768886', 'Dinis', '8615768886@gmail.com', 'M', 'Segurança','1995-04-30','Rua de São Cristóvão','465',NULL,
    'Évora','7000-661'),
    ('8615768887', 'Duarte', '8615768887@gmail.com', 'M','Segurança', '1998-03-23','Rua Marceliano de Araújo','58','2',
    'Braga','5971-054');

INSERT PISO(NumEspacoLeitura)
VALUES
('2'),
('4'),
('3'),
('4'),
('3'),
('4'),
('3'),
(NULL)('Trabalhos universitários'),
(NULL);
  
INSERT INTO AREAS_PISO(Piso,Area)
VALUES
('1','Receção'),
('2','Matemática'),
('3','Matemática'),
('3','Ciências de Computadores'),
('4','Física'),
('5','Química'),
('6','Biologia'),
('7','Geologias'),
('8','Trabalhos universitários');

Insert INTO ARTIGO(Titulo,Autor,NumPaginas,Volume,Tipo,Disponibilidade,Localizacao)    
VALUES 
  ('Digital Signal Processing: A Computer-Based Approach','McGraw-Hill', '972',NULL,
 'Livro didático','SIM','2'),
  ('Digital signal processing : principles, algorithms, and applications','Proakis, John G.',
 NULL, NULL,'Livro didático','SIM','2'),
  ('A first course in database systems','Ullman, Jeffrey D., 1942-','470', NULL,
'Livro didático','SIM','3'),
  ('Fundamentals of database systems','Elmasri, Ramez','1030',NULL,
  'Livro didático','SIM','3'),
  ('Geosciences and the sustainable development goals','Joel C. Gill, Martin Smith',
  '474',NULL,'Livro didático','SIM','7'),
  ('Renewable energy forecasting : extreme quantiles, data privacy and monetization',
  'Gonçalves, Carla Sofia da Silva','135',NULL,NULL,'Tese de Doutoramento',
  'SIM','8'),
  (NULL,NULL,NULL,NULL,NULL,'Calculadora','SIM','1'),
  (NULL,NULL,NULL,NULL,NULL,'Calculadora','SIM','1'),
  (NULL,NULL,NULL,NULL,NULL,'Calculadora','SIM','1'),
  (NULL,NULL,NULL,NULL,NULL,'Calculadora','SIM','1'),
  (NULL,NULL,NULL,NULL,NULL,'Calculadora','SIM','1'),
  (NULL,NULL,NULL,NULL,NULL,'Calculadora','SIM','1'),
  (NULL,NULL,NULL,NULL,NULL,'Calculadora','SIM','1'),
  (NULL,NULL,NULL,NULL,NULL,'Calculadora','SIM','1'),
  (NULL,NULL,NULL,NULL,NULL,'Calculadora','SIM','1');
INSERT SALA_DE_ESTUDO(Capacidade,NumPCs,LimiteTempo,Localizado)                 
VALUES
('30','6','01:30:00','1'),
('10','3','01:00:00','1'),
('45','10','02:30:00','2'),
('20','6','03:30:00','3'),
('30','7','02:00:00','1'),
('30','10','01:30:00','1');

INSERT CADEIRA(Nome,Departamento, Regente, DataInicio)
VALUES
('Análise e Processamento Digital de Sinal','Matemática', '8615768878','2020-05-20'),
('Lógica e Fundamentos','Matemática', '8615768884','2021-05-20'),
('Bases de Dados','Ciências de Computadores', '8615768888','2019-05-20');
 
INSERT EVENTO(Capacidade, DataHora, Tipo, Decorre)
values 
('26','2022-01-08 14:00:00','Quaterniões','1'),
('35','2021-05-06 15:00:00', 'Matemática tem Magia!','2');

insert AREA_CIENTIFICA(Artigo,Area)
VALUES
('1','Matemática'),
('1','Ciências de Computadores'),
('2','Matemática'),
('2','Ciências de Computadores'),   
('3','Ciências de Computadores'),  
('4','Ciências de Computadores'),  
('5','Geologia'),  
('6','Ciências de Computadores'); 

INSERT NUM_TELEFONE_FUNC(NumMec,Telefone)
VALUES
('8615768878','965231589'),
('8615768879','957624856'),
('8615768879','227669916'),
('8615768880','956789231'),
('8615768881','965587423'),
('8615768882','912365899'),
('8615768883','915846356'),
('8615768884','987413658'),
('8615768885','226879798'),
('8615768886','236649897'),
('8615768886','959816876'),
('8615768887','998741265');
   
INSERT NUM_TELEFONE_CLIENTE(NumMec,Telefone)
VALUES
('4954236157','965238989'),
('4954236157','965489846'),
('4954236158','215684335'),
('4954236159','925998444')
('4954236167','956684335'),
('4954236168','985566884'),
('4954236169','987654321'),
('4954236179','955216678'),
('4954236180','984115565'),
('4954236181','944457777'),
('4954236182','215684815'),
('4954236182','974516582');

INSERT ATENDIDO_POR(Cliente,Funcionario,Tipo,DataHora)
VALUES
('4954236157','8615768886','Requisição de artigo','2021-06-05 14:36:56'),
('4954236167','8615768883','Requisição de artigo','2021-07-05 12:36:46'),
('4954236182','8615768881','Requisição de artigo','2021-07-05 22:24:50'),
('4954236158','8615768887','Requisição de artigo','2021-06-04 14:32:17'),
('4954236169','8615768886','Devolução de artigo','2021-06-04 09:35:56'),
('4954236180','8615768884','Inscrição em evento','2021-06-04 08:25:15'),
('4954236168','8615768885','Inscrição em evento','2021-06-04 07:18:25');

INSERT INSCRICAO(Cliente,Evento,NumEntrada)
VALUES
('4954236180','1','1'),
('4954236180','2','1'),
('4954236168','2','2');

INSERT RECOMENDADO_POR_CADEIRA(Artigo,Cadeira,GrauObrigatoriadade,Temas)
VALUES
('1','1','Leitura Obrigatoria','Processamento de sinais - Técnicas digitais'),
('2','1','Leitura Complementar','Processamento de sinais - Técnicas digitais'),
('3','3','Leitura Obrigatoria', 'Sistemas de gestão de bases de dados'),
('4','3','Leitura Complementar','Gestão de bases de dados'),
('6','2','Leitura Complementar', NULL);

INSERT USADO_POR_EVENTO(Evento,Artigo,Justificacao)
VALUES
('1','1',NULL),
('2','5','Para ler umas passagens.'),
('2','6',NULL);

INSERT RESPONSAVEL_PELO_EVENTO(Funcionario,Evento,Funcao)
VALUES
('8615768878','1','Orador'),
('8615768882','1','Ajudante'),
('8615768882','2','Orador'),
('8615768883','2','Coordenador de eventos');
