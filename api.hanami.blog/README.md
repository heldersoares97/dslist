
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

Lista todas as publicações
 - URL: /publicacoes
 - Método: GET
 - Resposta:

```
[
    {
        "publiId": 1,
        "email": "exemplo7@email.com",
        "titulo": "Título da Publicação7",
        "conteudo": "Conteúdo da publicação7",
        "data": "2024-05-23T15:58:39.856-03:00"
    },
    {
        "publiId": 2,
        "email": "exemplo1@email.com",
        "titulo": "Título da Publicação1",
        "conteudo": "Conteúdo da publicação1",
        "data": "2024-05-23T16:00:22.768-03:00"
    }
]
```