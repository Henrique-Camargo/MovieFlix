# 🎬 MovieFlix

Aplicação desenvolvida em **Java 17** com **Spring Boot 3.5.4** para cadastro e gerenciamento de um catálogo de filmes.  
O projeto conta com autenticação JWT, persistência em PostgreSQL, controle de versão do banco com Flyway e documentação da API via Swagger.

---

## 🚀 Tecnologias Utilizadas

- Spring Boot 3.5.4  
- Spring Data JPA  
- Spring Security + JWT  
- Spring Validation  
- Swagger (SpringDoc OpenAPI)  
- PostgreSQL  
- Flyway  
- Docker Compose  
- Lombok  

---

## 📖 Funcionalidades

- Cadastro, listagem, atualização e exclusão de filmes 🎥
- Cadastro, listagem e exclusão de categorias📌
- Cadastro, listagem e exclusão de streamings🍿
- Autenticação e autorização com **JWT** 🔐  
- Validação de dados no cadastro ✅  
- Controle de versão do banco com **Flyway** 🗂️  
- Documentação automática da API com **Swagger** 📚  

---

## ⚙️ Como Executar o Projeto

### 1️⃣ Clonar o repositório
```bash
git clone https://github.com/seu-usuario/MovieFlix.git
cd MovieFlix
```
###2️⃣ Configurar o banco de dados
Crie um banco no PostgreSQL e ajuste o application.yml:

spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/movieflix
    username: seu_usuario
    password: sua_senha
  jpa:
    hibernate:
      ddl-auto: validate
    show-sql: true

###3️⃣ Executar com Docker (opcional)
docker compose up -d

###4️⃣ Rodar o projeto
./mvnw spring-boot:run

📖 Documentação da API

Após rodar o projeto, a documentação estará disponível em:

👉 http://localhost:8080/swagger-ui.html

✅ Próximos Passos

Criar integração com frontend (React/Angular)
Adicionar testes de integração mais robustos

🧑‍💻 Autor
Feito por Henrique Camargo 👋
🔗 [LinkedIn](https://www.linkedin.com/in/henriquecamargo-dev/) | [GitHub](https://github.com/Henrique-Camargo)
---
