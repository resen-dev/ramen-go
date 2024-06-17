# RamenGo 🍜

### Objetivo
O projeto Ramengo tem como objetivo listar proteínas e caldos, permitindo a realização de pedidos escolhendo uma proteína e um caldo.

### Tecnologias Utilizadas

- **Java**: versão 21
- **Spring Boot**: versão 3.3.0
- **Flyway**: para gerenciar migrações de banco de dados
- **PostgreSQL**: banco de dados rodando em um container Docker


### Estrutura do Projeto

O projeto segue boas práticas de programação, segregando suas funções nas camadas:

- **Controller**: Recebe requisições HTTP, delega as ações necessárias para os serviços e retorna respostas ao cliente.
- **Service**: Contém a lógica de negócios da aplicação, implementando regras específicas e coordenando a execução das operações solicitadas pelo cliente.
- **Repository**: Abstrai o acesso aos dados, realizando operações de persistência no banco de dados e oferecendo métodos para consultar e manipular informações.

### Funcionalidades Adicionais

- **Global Exception Handler**: com mensagens de erro customizadas
- **Interceptor**: para filtrar as requisições e checar a presença do api-token correto no header da request
- **Spring Security**: para desabilitar o CORS da aplicação

### Execução do Projeto

#### Pré-requisitos
- Docker instalado

#### Instruções
- Execute o seguinte comando para iniciar o container do PostgreSQL:

   ```sh
   docker run --name ramengo-postgres -e POSTGRES_DB=ramengo -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=topsecret -p 5432:5432 -d postgres
   
#### Configuração Dinâmica
Os valores abaixo no application.yml podem ser definidos como variáveis de ambiente para que o projeto tenha configurações dinâmicas de acordo com o ambiente de desenvolvimento:

```yaml
api:
  key:
    header: x-api-key
    value: ZtVdh8XQ2U8pWI2gmZ7f796Vh8GllXoN7mr0djNf
