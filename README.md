# Projeto de Gerenciamento de Veículos - Desafio de Estágio

Este projeto é uma API REST com operações CRUD que utiliza Spring Boot como backend e MySQL como banco de dados.
A aplicação permite a consulta, adição, atualização e remoção de Veículos de Carga e de Passeio.

1. **Clone o repositório:**

   ```bash
   git clone https://github.com/duartemarco/desafio-rpe-marco.git
    ```

2. **Instale as dependências:**

    ```bash
    mvn clean install
    ```

3. **Rode a aplicação Spring Boot:**

    ```bash
    mvn spring-boot:run
    ```

4. **Crie um usuário administrador:**

   Envie um POST para `localhost:8080/users` preenchendo seu email, senha e acesso:

    ```json
    {
       "email": "admin@email.com",
       "password": "123456789",
       "role": "ROLE_ADMINISTRATOR"
    }
    ```
   
5. **Realize login para receber token**

    Envie um POST para `localhost:8080/users/login` com o email e senha criados anteriormente:

    ```json
    {
       "email": "admin@email.com",
       "password": "123456789"
    }
    ```
   A aplicação lhe retornará seu token, que deverá ser utilizado para autenticar suas requisições:
    ```json
   {
    "token": "eyJhbGciOiJIUzI1NiIsInRIjoxNzE0NTA1YiI6ImFkbWluQGV.fRQvlsLMBGGpyh8gu7vxngPvBIwljTOdp0sKtI4O2Xg"
    }
   ```

## Endpoints

### Veículo de Carga

| Método   | URL                                              | Descrição                    |
|----------|--------------------------------------------------|------------------------------|
| `GET`    | http://localhost:8000/veiculos/carga/{id}        | Consulta um Veículo de Carga |
| `POST`   | http://localhost:8000/veiculos/carga/add         | Cadastra um Veículo de Carga |
| `PUT`    | http://localhost:8000/veiculos/carga/update/{id} | Atualiza VeículoCarga por ID |
| `DELETE` | http://localhost:8000/veiculos/carga/delete/{id} | Deleta VeículoCarga por ID   |

### Veículo de Passeio

| Método   | URL                                                | Descrição                          |
|----------|----------------------------------------------------|------------------------------------|
| `GET`    | http://localhost:8000/veiculos/passeio/{id}        | Consulta um Veículo de Passeio     |
| `POST`   | http://localhost:8000/veiculos/passeio/add         | Cadastra um Veículo de Passeio     |
| `PUT`    | http://localhost:8000/veiculos/passeio/update/{id} | Atualiza Veículo de Passeio por ID |
| `DELETE` | http://localhost:8000/veiculos/passeio/delete/{id} | Deleta Veículo de Passeio por ID   |

### Login

| Método | URL                                            | Descrição                           |
|--------|------------------------------------------------|-------------------------------------|
| `POST` | http://localhost:8000/users                    | Cadastra Usuário                    |
| `POST` | http://localhost:8000/users/login              | Realiza login e obtém Token         |
| `GET`  | http://localhost:8000/users/test               | Testa autenticação                  |
| `GET`  | http://localhost:8000/users/test/customer      | Testa autenticação de Usuário       |
| `GET`  | http://localhost:8000/users/test/administrator | Testa autenticação de Administrador |
