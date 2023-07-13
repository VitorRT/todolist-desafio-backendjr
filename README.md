<h1 align="center">
  TODO List Rest Api ✅
</h1>

<p align="center">
 <img src="https://img.shields.io/static/v1?label=Java&message=Spring+Boot&color=8257E5&labelColor=000000" alt="Spring Boot" />
 <img src="https://img.shields.io/static/v1?label=Tipo&message=Desafio&color=8257E5&labelColor=000000" alt="Desafio" />
</p>

API para gerenciar tarefas (CRUD) que faz parte [desse desafio](https://github.com/simplify-liferay/desafio-junior-backend-simplify) para pessoas desenvolvedoras backend júnior, que se candidatam para a Simplify.

O projeto foi elaborado [nesse vídeo](https://youtu.be/IjProDV001o).
ps: eu fiz a api do zero, porém eu acompanhei a [giuliana bezerra](https://github.com/giuliana-bezerra)

## Tecnologias
 
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring MVC](https://docs.spring.io/spring-framework/reference/web/webmvc.html)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [SpringDoc OpenAPI 3](https://springdoc.org/v2/#spring-webflux-support)
- [Mysql](https://dev.mysql.com/downloads/)
- [H2](https://h2database.com/html/main.html)

## Práticas adotadas

- SOLID, DRY, YAGNI, KISS
- API REST
- Consultas com Spring Data JPA
- Injeção de Dependências
- Tratamento de respostas de erros com um global handler
- Geração automática do Swagger com a OpenAPI 3
- Docker com: Dockerfile e Docker Compose
- Dto's de requisições e respostas
- Testes automatizados
- Banco de dados de produção e desenvolvimento (MySQL e H2)
- Versionamento com: Git flow


## Como excutar
- Clonar esse repositório
- Construir o projeto:

1º Forma - Excecutando localmente
- Executando com o `.jar`:

buildar o projeto:
```
$ ./mvnw clean package
```

executar o jar:
```
$ java -jar target/desafio-todolist-0.0.1-SNAPSHOT.jar
```

- Executando em uma IDE:

Execute o projeto em sua IDE favorita localmente, o projeto está configurado tanto para o docker, quanto para o seu computador.

2º Forma - Executando com o Docker:
- Abra o seu terminal na pasta raiz do projeto e execute o comando docker

entrando na raiz do projeto
```
$ cd todolist-desafio-backendjr
```

executando o comando docker
```
$ docker-compose up
```
<small>Lembrando: você precisa inicializar o seriviço do docker em seu computador primeiro.</small>


A API poderá ser acessada em [localhost:8080](http://localhost:8080). A documentação da API com o Swagger poderá ser visualizado em [localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

Para você acessar o banco de dados mysql pelo docker aqui estão aqui algumas intruções:
- Se logue com o usuário criado:
```
$ mysql -u user -p
```
<small>password: usertodolist</small>

- Mude para o banco de dados do projeto:
```
$ mysql use todolist
```

- Para um comando teste rode:
```
$ mysql show tables;
```

Para você acessar o banco de dados de desenvolvimento aqui estão as instruções :
 - Acesse em seu navegador a rota: [localhost:8080/h2-console](http://localhost:8080/h2-console)
 - Coloque essa url de conexão: jdbc:h2:mem:todolocal
 - Deixe o user como: sa

<small>ps: não precisa de senha, apenas coloque a url e o user 😁</small>


## API Endpoints

Base URL: /api/v1

Para fazer as requisições HTTP abaixo, foi utilizada a ferramenta [httpie](https://httpie.io):

- Criar Tarefa 
```
$ http POST :8080/api/v1/todos nome="todo 1" descricao="important todo" prioridade=1

[
  {
    "id": "3fa85f64-5717-4562-b3fc-2c963f66afa6",
    "nome": "todo 1",
    "descricao": "important todo",
    "realizado": false,
    "prioridade": 1
  }
]
```

- Listar Tarefas
```
$ http GET :8080/api/v1/todos

[
  {
    "id": "3fa85f64-5717-4562-b3fc-2c963f66afa6",
    "nome": "todo 1",
    "descricao": "important todo",
    "realizado": false,
    "prioridade": 1
  }
]
```

- Atualizar Tarefa
```
$ http PUT :8080/api/v1/todos/3fa85f64-5717-4562-b3fc-2c963f66afa6 nome="Todo 1 Up" descricao="Desc Todo 1 Up" prioridade=2 realizado=true

[
  {
    "id": "3fa85f64-5717-4562-b3fc-2c963f66afa6",
    "nome": "Todo 1 Up",
    "descricao": "Desc Todo 1 Up",
    "realizado": true,
    "prioridade": 2
  }
]
```

- Remover Tarefa
```
http DELETE :8080/api/v1/todos/3fa85f64-5717-4562-b3fc-2c963f66afa6

[ ]
```



