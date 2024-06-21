# Documentação da API do Blog Hanami

Esta é uma API simples de Blog que permite aos usuários criar publicações de blog. A API é construída com Spring Boot e usa um banco de dados MySQL para persistência de dados.

## Tabela de Conteúdos

- [Visão Geral](#)
- [Primeiros Passos](#primeiros-passos)
  - [Pré-requisitos](#pré-requisitos)
  - [Instalação](#instalação)
- [Uso](#uso)
  - [Endpoints da API](#endpoints-da-api)

## Primeiros Passos

### Pré-requisitos

Certifique-se de ter o seguinte instalado no seu sistema:

- Java 17 ou superior
- MySQL 8.0 ou superior

## Instalação

1. Clone o repositório:

```bash
  git clone https://github.com/Hanami-Staff/SQUAD-02.git
```

2. Atualize o arquivo application.properties com as credenciais do seu banco de dados.

3. Inicie o projeto.

## Uso

Ao executar a aplicação será iniciada e estará acessível em http://localhost:8080.

### Endpoints da API

Criar uma Nova Publicação

- URL: /publicacoes
- Método: POST
- Corpo da Requisição:

```
{
  "email": "usuario@exemplo.com",
  "titulo": "Título da publicação",
  "conteudo": "Conteúdo da publicação"
}
```

- Resposta:

```
{
  "publiId": 1,
  "email": "usuario@exemplo.com",
  "titulo": "Título da publicação",
  "conteudo": "Conteúdo da publicação",
  "data": "2024-05-21T13:54:38.626+00:00"
}
```

Listar todas as Publicações

- URL: /publicacoes
- Método: GET
- Resposta:

```
{
  "publiId": 1,
  "email": "usuario@exemplo.com",
  "titulo": "Título da publicação",
  "conteudo": "Conteúdo da publicação",
  "data": "2024-05-21T13:54:38.626+00:00"
},
{
  "publiId": 2,
  "email": "exemplo2@email.com",
  "titulo": "Título da Publicação2",
  "conteudo": "Conteúdo da publicação2",
  "data": "2024-05-23T16:00:22.768-03:00"
}
```

Listar uma Publicação por ID

- URL: /publicacoes/{id}
- Método: GET
- Resposta:

```
{
  "publiId": 1,
  "email": "usuario@exemplo.com",
  "titulo": "Título da publicação",
  "conteudo": "Conteúdo da publicação",
  "data": "2024-05-21T13:54:38.626+00:00"
}
```

Excluir Publicação como um usuário

- URL:  /publicacoes/{id}
- Método: Delete

Editar uma Publicação

- URL: /publicacoes/{id}
- Método: PUT
- Corpo da Requisição:

```
{
  "email": "usuario@exemplo.com",
  "titulo": "Título da publicação",
  "conteudo": "Teste de atualização"
}
```

- Resposta:

```
{
  "publiId": 1,
  "email": "usuario@exemplo.com",
  "titulo": "Título da publicação",
  "conteudo": "Teste de atualização",
  "data": "2024-05-21T13:54:38.626+00:00"
}
```


Criar um comentário no ID de publicação

- URL: /publicacoes/4/comentarios
- Método: POST
- Corpo da Requisição:

```
{
    "content": "Este é um comentário de exemplo."
}
```

- Resposta:

```
{
    "id": 1,
    "content": "Este é um comentário de exemplo.",
    "publicacao": {
        "publiId": 4,
        "email": "exemplo7@email.com",
        "titulo": "Título da Publicação7",
        "conteudo": "Conteúdo da publicação7",
        "data": "2024-05-25T00:28:09.788-03:00"
    },
    "date": "2024-06-11T20:02:41.750-03:00"
}
```

Listar comentarios de uma publicação


- URL: /publicacoes/1/comentarios
- Método: GET

- Resposta:

```

    {
        "id": 1,
        "content": "Este é um comentário de exemplo.",
        "publicacao": {
            "publiId": 1,
            "email": "exemplo7@email.com",
            "titulo": "Título da Publicação7",
            "conteudo": "Conteúdo da publicação7",
            "data": "2024-06-19T10:37:40.213-03:00"
        },
        "date": "2024-06-19T10:40:00.691-03:00"
    },
    {
        "id": 2,
        "content": "Este é um comentário de exemplo.",
        "publicacao": {
            "publiId": 1,
            "email": "exemplo7@email.com",
            "titulo": "Título da Publicação7",
            "conteudo": "Conteúdo da publicação7",
            "data": "2024-06-19T10:37:40.213-03:00"
        },
        "date": "2024-06-19T10:45:15.225-03:00"
    },
    {
        "id": 3,
        "content": "Este é um comentário.",
        "publicacao": {
            "publiId": 1,
            "email": "exemplo7@email.com",
            "titulo": "Título da Publicação7",
            "conteudo": "Conteúdo da publicação7",
            "data": "2024-06-19T10:37:40.213-03:00"
        },
        "date": "2024-06-19T10:46:41.758-03:00"
    },
    {
        "id": 4,
        "content": "Este é um comentário exemplo 2.",
        "publicacao": {
            "publiId": 1,
            "email": "exemplo7@email.com",
            "titulo": "Título da Publicação7",
            "conteudo": "Conteúdo da publicação7",
            "data": "2024-06-19T10:37:40.213-03:00"
        },
        "date": "2024-06-20T20:12:35.826-03:00"
    }

```

Ver detalhes de um comentario específico

- URL: /publicacoes/comentario/4
- Método: GET

- Resposta:

```
{
    "id": 4,
    "content": "Este é um comentário exemplo 2.",
    "publicacao": {
        "publiId": 1,
        "email": "exemplo7@email.com",
        "titulo": "Título da Publicação7",
        "conteudo": "Conteúdo da publicação7",
        "data": "2024-06-19T10:37:40.213-03:00"
    },
    "date": "2024-06-20T20:12:35.826-03:00"
}
```