#  Desafio Itaú - API de Transações e Estatísticas

Projeto desenvolvido como solução para o desafio técnico do Itaú, utilizando Java e Spring Boot.

O objetivo da aplicação é receber transações financeiras, armazená-las em memória e fornecer estatísticas calculadas sobre as transações realizadas nos últimos 60 segundos.

---

##  Funcionalidades

### Transações

- Registrar uma nova transação
- Validar valores e datas enviadas
- Rejeitar transações com datas futuras
- Armazenamento temporário em memória

### Estatísticas

- Quantidade de transações
- Soma total dos valores
- Média das transações
- Menor valor registrado
- Maior valor registrado

### Limpeza

- Remover todas as transações registradas

---

##  Tecnologias Utilizadas

- Java
- Spring Boot
- Maven
- REST API
- DTO Pattern
- Programação Orientada a Objetos (POO)

---

##  Estrutura do Projeto

```text
src
├── controller
│   ├── TransactionController
│   └── StatisticsController
│
├── service
│   └── TransactionService
│
├── dto
│   ├── TransactionRequest
│   └── StatisticsResponse
│
└── application
```

---

##  Endpoints

### Criar Transação

```http
POST /transacao
```

### Exemplo de Requisição

```json
{
  "valor": 100.50,
  "dataHora": "2026-05-31T15:30:00"
}
```

### Respostas

| Status | Descrição |
|----------|------------|
| 201 | Transação criada |
| 400 | Dados inválidos |
| 422 | Data futura |

---

### Limpar Transações

```http
DELETE /transacao
```

### Resposta

```http
200 OK
```

---

### Consultar Estatísticas

```http
GET /estatistica
```

### Exemplo de Resposta

```json
{
  "count": 5,
  "sum": 500.00,
  "avg": 100.00,
  "min": 50.00,
  "max": 150.00
}
```

---

##  Como Executar

### Pré-requisitos

- Java 17+
- Maven 3.8+

### Clone o projeto

```bash
git clone https://github.com/matheusfideles-stack/desafio.itau.springboot.git
```

### Entre na pasta

```bash
cd desafio.itau.springboot
```

### Execute a aplicação

```bash
mvn spring-boot:run
```

A API ficará disponível em:

```text
http://localhost:8080
```

---

##  Testes

Você pode testar os endpoints utilizando:

- Postman
- Insomnia
- Thunder Client

---

##  Objetivo do Desafio

Este desafio tem como foco demonstrar conhecimentos em:

- Desenvolvimento de APIs REST
- Spring Boot
- Manipulação de coleções
- Validação de dados
- Arquitetura em camadas
- Boas práticas de programação

---

##  Autor

Desenvolvido por Matheus Fideles.

GitHub:
https://github.com/matheusfideles-stack
