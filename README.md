# 📦 API de Clientes --- Spring Boot

Projeto de **API REST** desenvolvido em **Spring Boot**, com foco em
**boas práticas**, **organização em camadas** e **padrões de projeto**,
voltado para **portfólio, estágio e vagas júnior**.

------------------------------------------------------------------------

## 🎯 Objetivo

Demonstrar conhecimentos em: - Arquitetura de APIs REST - Separação de
responsabilidades - Uso de DTOs e Mappers - Persistência com Spring Data
JPA - Integração com APIs externas

------------------------------------------------------------------------

## 🚀 Tecnologias Utilizadas

-   Java
-   Spring Boot
-   Spring Web MVC
-   Spring Data JPA
-   H2 Database (em memória)
-   Spring Cloud OpenFeign
-   Maven
-   Swagger / OpenAPI

------------------------------------------------------------------------

## 🏗️ Arquitetura

O projeto segue uma estrutura em camadas:

-   **controller**: exposição dos endpoints REST
-   **dto**: controle dos dados de entrada e saída
-   **mapper**: conversão entre DTOs e entidades
-   **model**: entidades JPA
-   **services**: regras de negócio

Essa abordagem garante código limpo, organizado e fácil de manter.

------------------------------------------------------------------------

## 📌 Funcionalidades

-   Cadastro de clientes
-   Listagem de clientes
-   Busca por ID
-   Atualização de dados
-   Remoção de clientes
-   Integração com serviço externo para consulta de endereço via CEP
-   Documentação automática com Swagger

------------------------------------------------------------------------

## ▶️ Como Executar

``` bash
git clone https://github.com/seu-usuario/padroes-de-projeto.git
cd padroes-de-projeto
./mvnw spring-boot:run
```

------------------------------------------------------------------------

## 📘 Documentação

Swagger disponível em:

    http://localhost:8080/swagger-ui.html

------------------------------------------------------------------------

## 🗄️ Banco de Dados

Banco H2 em memória:

    http://localhost:8080/h2-console
    JDBC URL: jdbc:h2:mem:testdb
    User: sa
    Password: (vazio)

------------------------------------------------------------------------

## 👨‍💻 Observações

Projeto desenvolvido com fins educacionais, demonstrando domínio dos
fundamentos do ecossistema Spring e boas práticas de desenvolvimento
backend.
