# PROCESSO SELETIVO SEPLAG - EDITAL 01/2026 ENGENHEIRO DE COMPUTAÇÃO
# DADOS DE INSCRIÇÃO

N° Inscrição: 16386 <br>
Gabriel Henrique Ferreira Alves <br>
CPF: 019.825.091-63 <br>
E-mail: gabrielhf257@gmail.com <br>
Vaga: Engenheiro da Computação - Back-end <br>

# PROGRAMAS NECESSARIOS PARA EXECUÇÃO DO PROJETO

- Java JDK 21 <br>
- Maven 3.9+ <br>
- MySQL 8+ <br>
- GIT (Opcional, somente para clonar o repositório) <br>
- IDE Java (Utilizri VS code) <br>

# PARA EXECUTAR O PROJETO EM SEU COMPUTADOR (COM OS PROGRAMAS JÁ INSTALADOS)

1. Crie o banco de dados no MySQL (Recomendado colocar o nome de music_api); <br>
2. Configure o arquivo "application.properties" localizado em /src/main/java/com/example/demo/resources dessa forma abaixo:
    spring.datasource.url=jdbc:mysql://localhost:3306/music_api
    spring.datasource.username=SEU_USUARIO
    spring.datasource.password=SUA_SENHA

    api.security.token.secret=CHAVE_SECRETA_COM_32_OU_MAIS_CARACTERES
    api.security.token.expiration-minutes=5 <br>
3. Abra o terminal na IDE e digite "./mvnw spring-boot:run" a aplicação sera iniciada; <br>
4. Acesse o Swagger atraves do link "http://localhost:8080/swagger-ui.html"; <br>

# TESTES/ FUNCIONAMENTO DA APLICAÇÃO

1. Autenticação:
    - Para que o swagger UI consiga fazer todos os GET e POST que a API permite você tem que fazer a autenticação com o usuário e senha para gerar o token de autorização;<br>
    - Com o swagger UI aberto execute o endpoint "POST /v1/auth/login" clique em try it out e coloque no body o código: <br>
    {"username": "admin","password": "admin"}, se aparecer o código 200 ou 201 é porque deu certo, se aparecer outro diferente alguma coisa deu errado;
    - Com o token gerado, copie ele e va em "Authorize" e coloque "Bearer + 'O token copiado' ", pronto acesso autorizado.

2. Artista:
    - Para adicionar um novo cantor/ banda acesse "POST /v1/artists" clique em try it out e coloque no body o código: <br>
    {"name": "nome do cantor/ banda", "type": "Tipo, se é cantor/ banda"} e execute, se aparecer o código 200 ou 201 é porque deu certo, se aparecer outro diferente alguma coisa deu errado;
    - Para ver o artistas criados, va em "GET /v1/artist" clique em try it out depois clique em executar, logo abaixo vai ser listados os artistas criados.

3. Album:
    - Para adicionar um novo album, acesse "POST /v1/albums" clique em try it out e coloque no body o código: <br>
    {"title": "nome do album","releaseDate": "data de lançamento do album","artistId": id do artista já criado} e execute, se aparecer o código 200 ou 201 é porque deu certo, se aparecer outro diferente alguma coisa deu errado;
    - Para ver os albums criados, va em "GET /v1/albums" clique em try it out depois em executar, logo abaixo vai aparecer todos os albums criados.

4. Testes Unitários: 
    - Testes unitários se encontra dentro da pasta de "test" no caminho /src/main/resources/test/java/com/example/demo, só abrir na IDE com as extensões de JAVA instalado e ir clicando em run em cada arquivo criado la.


