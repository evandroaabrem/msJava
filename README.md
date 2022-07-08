<b><h1>Visão geral</h1></b>

O projeto é uma a geral</h1><plicação back-end, utilizando os frameworks Spring Cloud (Zuul, Eureka, etc), Spring Security, Spring Boot,  Spring MVC, Spring Data, Mensageria com RabbitMQ, Maven, Junit e Mockito.</h1>

<b><h1>Setup da aplicação (local)</h1></b>

<b><h1>Pré-requisito</h1></b>
Antes de rodar a aplicação é preciso garantir que as seguintes dependências estejam corretamente instaladas:

Java 11<br>
PostgreSQL


<b><h1>Instalação da aplicação</b></h1>  
  Primeiramente, faça o clone do repositório:
  
  https://github.com/evandroaabrem/msJava.git
  
  
  Feito isso, acesse o projeto:

cd msJava\gateway<br><br>
É preciso compilar o código e baixar as dependências do projeto:

mvn clean package

Finalizado esse passo, vamos iniciar a aplicação:

mvn spring-boot:run


cd msJava\eurekaServer<br><br>
É preciso compilar o código e baixar as dependências do projeto:

mvn clean package

Finalizado esse passo, vamos iniciar a aplicação:

mvn spring-boot:run


cd msJava\backEnd\integracao<br><br>
É preciso compilar o código e baixar as dependências do projeto:

mvn clean package

Finalizado esse passo, vamos iniciar a aplicação:

mvn spring-boot:run

cd msJava\backEnd\otimaWeb<br><br>
É preciso compilar o código e baixar as dependências do projeto:

mvn clean package

Finalizado esse passo, vamos iniciar a aplicação:

mvn spring-boot:run


cd msJava\backEnd\mensageria<br><br>
É preciso compilar o código e baixar as dependências do projeto:

mvn clean package

Finalizado esse passo, vamos iniciar a aplicação:

mvn spring-boot:run

<b><h1>Setup da aplicação com docker</b></h1>

<b><h1>Preparando ambiente</b></h1>

Criar e executar container do Posgres <br>

docker run -d --name postgres -e POSTGRES_DB=postgres -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=postgres -p 5432:5432 postgres
<br><br>

Criar e executar container do Mensageria com RabbitMQ <br>
docker run -d -p 15672:15672 -p 5672:5672 --name rabbitmq rabbitmq:3-management
<br><br>
<b><h1>Setup Script</b></h1>

CREATE TABLE perfil (
	id int NOT NULL,
	nome varchar(20) NULL,
	CONSTRAINT PK_perfil PRIMARY KEY (id)
);

INSERT INTO perfil
(id, nome)
VALUES(1, 'ROLE_USER');
INSERT INTO perfil
(id, nome)
VALUES(2, 'ROLE_ADMIN');

CREATE TABLE usuario (
	id int NOT NULL,
	email varchar(100),
	nome varchar(100),
	senha varchar(100),
	username varchar(100),
	CONSTRAINT PK_usuario PRIMARY KEY (id)
);

INSERT INTO usuario
(id, email, nome, senha, username)
VALUES(1, 'teste@teste.org.br', 'teste', '$2a$10$uFB4L1KjCrWri.DhJM933eec6McjcJn13Ek8uILd2mLN.7ZBGqnOG', 'teste');

CREATE TABLE usuario_perfil (
	usuario_id int NOT NULL,
	perfil_id int NOT NULL,
	CONSTRAINT PK_usuario_perfil PRIMARY KEY (usuario_id,perfil_id)
);

ALTER TABLE usuario_perfil ADD CONSTRAINT FK22cgfn0obntlvqyfn33pyk24d FOREIGN KEY (perfil_id) REFERENCES perfil(id);
ALTER TABLE usuario_perfil ADD CONSTRAINT FKnrjqnbylalt4ykxbcef24f57w FOREIGN KEY (usuario_id) REFERENCES usuario(id);

INSERT INTO usuario_perfil
(usuario_id, perfil_id)
VALUES(1, 1);
INSERT INTO usuario_perfil
(usuario_id, perfil_id)
VALUES(1, 2);

CREATE TABLE poste (
	id int NULL,
	bairro varchar(100),
	identificacao varchar(100),
	CONSTRAINT PK__usuario_perfil PRIMARY KEY (id)
);

INSERT INTO poste
(id, bairro, identificacao)
VALUES(1, 'weweew', 'weewew');
INSERT INTO poste
(id, bairro, identificacao)
VALUES(2, 'weweew', 'weewew');
INSERT INTO poste
(id, bairro, identificacao)
VALUES(3, 'Centro', '-123');
INSERT INTO poste
(id, bairro, identificacao)
VALUES(4, 'Mooca', 'viviii');
INSERT INTO poste
(id, bairro, identificacao)
VALUES(5, 'Indianóplis', '2');


<b><h1>APIs</b></h1>

Segue abaixo as APIs disponíveis no projeto:<br>

http://localhost:8080/api-auth/login<br>

Espera atributos para serem critérios de busca no body da requisição, exemplo:<br>
Body : { "username":"teste", "password":"123456"}<br><br>

localhost:8080/otimaweb/api-poste?page={page}&size={size}<br>
<i>Header</i><br>
    Authorization : Bearer XXXXXXXXXXX

localhost:8080/integracao/api-integracao/{CEP}<br>
<i>Header</i><br>
    Authorization : Bearer XXXXXXXXXXX


localhost:8080/mensageria/api-mensageria
<i>Header</i><br>
    Authorization : Bearer XXXXXXXXXXX
Body : { "cpf": "4545"}



