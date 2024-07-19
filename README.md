<h1 align="center" style="font-weight: bold;">Gonçalves Ferros - Backend 💻</h1>

<p align="center">
 <a href="#tech">Tecnologias</a> • 
 <a href="#started">Começando</a> • 
 <a href="#routes">API Endpoints</a> •
 <a href="#contribute">Contribuir</a>
</p>

<p align="center">
    <b>Uma API simples e eficiente que atende as necessidades do site com o mesmo nome.</b>
</p>

<h2 id="technologies">⚙ Tecnologias</h2>

- Java
- Spring-Boot
- PostgreSQL
- JWT

<h2 id="started">🚀 Começando</h2>

<h3>Pré-Requisitos</h3>

- [Java JDK 17](https://www.oracle.com/br/java/technologies/downloads/)
- [Maven 3.x.x +](https://maven.apache.org/download.cgi)
- [PostgreSQL 16+](https://www.postgresql.org/download/)
- [Git 2](https://github.com)

<h3>Clonando</h3>

Como clonar o projeto:

```bash
git clone git@github.com:vitorzg/backend-goncalvesferro.git
```

Caso não tenha configurado sua chave SSH, [Clique Aqui !](https://dev.to/fernandakipper/introducao-ao-ssh-12j5)

<h3>Rodando o Projeto</h3>

Primeiro instale as dependências do Maven

```bash
mvn install
```

Configure as "aplication.properties" caso estejam em branco

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/NOME_BASE_DE_DADOS
spring.datasource.username=SEU_USUÁRIO
spring.datasource.password=SUA_SENHA
api.security.token.secret=SUA_CHAVE_SERETA
```

Com tudo correto agora basta rodar o ultimo comando

```bash
mvn spring-boot:run
```

Pronto o Projeto estará rodando.

<h2 id="routes">📍 API Endpoints</h2>

Here you can list the main routes of your API, and what are their expected request bodies.
​
| Rotas               | Descrição            | Role                         
|----------------------|---------------------|--------------------------------
| <kbd>GET /api/user</kbd>     | Puxa todos os usuários existentes | ADMIN
| <kbd>GET /api/user/{id}</kbd>     | Puxa apenas dos detalhes de um usuário | ADMIN
| <kbd>POST /api/auth/register</kbd>     | Adiciona um novo usuário a base de dados | ADMIN
| <kbd>POST /api/auth/login</kbd>     | Logar em uma conta | USER
| <kbd>PUT /api/user</kbd>     | Editar os dados de um usuário | ADMIN 
| <kbd>DELETE /api/user</kbd>     | Deletar um usuário | ADMIN 
| <kbd>GET /api/products</kbd>     | Recceber todos os produtos | USER 
| <kbd>POST /api/products</kbd>     | Adicionar um produto | USER 
| <kbd>GET /api/products/{id}</kbd>     | Recceber um produto | USER 
| <kbd>PUT /api/products/{id}</kbd>     | Alterar um produto | USER 
| <kbd>DELETE /api/products/{id}</kbd>     | Deletar um produto | USER 
| <kbd>GET /api/chapas</kbd>     | Recceber todas as chapas | USER 
| <kbd>POST /api/chapas</kbd>     | Adicionar uma chapa | USER 
| <kbd>GET /api/chapas/{id}</kbd>     | Recceber uma chapa | USER 
| <kbd>PUT /api/chapas/{id}</kbd>     | Alterar uma chapa | USER 
| <kbd>DELETE /api/chapas/{id}</kbd>     | Deletar uma chapa | USER 

<!-- <h3 id="get-auth-detail">GET /authenticate</h3>

**RESPONSE**
```json
{
  "name": "Fernanda Kipper",
  "age": 20,
  "email": "her-email@gmail.com"
}
```

<h3 id="post-auth-detail">POST /authenticate</h3>

**REQUEST**
```json
{
  "username": "fernandakipper",
  "password": "4444444"
}
```

**RESPONSE**
```json
{
  "token": "OwoMRHsaQwyAgVoc3OXmL1JhMVUYXGGBbCTK0GBgiYitwQwjf0gVoBmkbuyy0pSi"
}
``` -->

<h2 id="contribute">📫 Contribuir</h2>



1. `git clone git@github.com:vitorzg/backend-goncalvesferro.git`
2. `git checkout -b feature/YOUR_NAME`
3. Siga os padrões de commit
4. Abra um Pull Request explicando o problema resolvido ou a funcionalidade desenvolvida, se existir, anexe uma captura de tela das modificações visuais e aguarde a revisão!
