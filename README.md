<b><h1>Visão geral</h1></b>

O projeto é uma a geral aplicação back-end, utilizando os frameworks Spring Cloud (Zuul, Eureka, etc), Spring Security, Spring Boot,  Spring MVC, Spring Data, Mensageria com RabbitMQ, Maven, Junit e Mockito.<br>
Outro ponto importante que vale a pena mencionar, estou utilizando docker(dockerFile e dockercompose) nos microserviços.

<b><h1>Setup da aplicação (local)</h1></b>

<b><h1>Pré-requisito</h1></b>
Antes de rodar a aplicação é preciso garantir que o seguinte software esteja corretamente instaladas:

Docker


<b><h1>Instalação da aplicação</b></h1>  
  Primeiramente, faça o clone do repositório:
  
  https://github.com/evandroaabrem/msJava.git
  

<b><h1>Setup da aplicação com docker</b></h1>

<b><h1>Iniciando a aplicação</b></h1>


cd msJava\ms<br><br>
É preciso compilar o código e baixar as dependências do projeto:

mvn clean install

Localizar o arquivo docker-compose.yml e executar no prompt, os comandos abaixo: 
<br>docker compose build<br>
docker compose up -d<br>
docker container ps<br><br>

cd msJava\migration<br><br>
É preciso compilar o código e baixar as dependências do projeto:
mvn clean install

Finalizado esse passo, vamos iniciar a aplicação:

mvn spring-boot:run

Caso tenha aparecido a mensagem abaixo, pode fechar o processo.<br><br>
"Tomcat started on port(s): 8181 (http)"

Obs. : Siginifica que os scripts foram executados com sucesso.


Em seguida, ir no seguinte diretório:<br><br>
cd msJava\gateway<br><br>
É preciso compilar o código e baixar as dependências do projeto:

mvn clean install

Finalizado esse passo, vamos iniciar a aplicação:

mvn spring-boot:run



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



