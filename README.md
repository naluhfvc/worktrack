# 📌 WorkTrack

API RESTful com Spring Boot para gerenciar **setores**, **funcionários** e **tarefas**, desenvolvida como trabalho da disciplina _Desenvolvimento Web em Camadas_ no curso de Sistemas de Informação – Unilasalle.

## 🚀 Tecnologias
- Java 17 + Spring Boot  
- JPA (Hibernate) + PostgreSQL  
- Lombok + MapStruct  
- Swagger (SpringDoc OpenAPI)

## 🔧 Funcionalidades
- CRUD completo para Setor, Funcionário e Tarefa
- Relacionamentos: Setor 1:N Funcionários, Funcionário 1:N Tarefas
- DTOs para criação, leitura e atualização parcial
- Documentação da API em: `/swagger-ui.html`

## ▶️ Como Executar Localmente

Siga os passos abaixo para rodar o projeto WorkTrack na sua máquina:

### 1. Pré-requisitos

- Java 17 instalado
- PostgreSQL (ou outro banco relacional)
- IDE (IntelliJ, Eclipse ou VS Code com suporte a Java)
- Maven

---

### 2. Clonar o Repositório

```bash
git clone https://github.com/naluhfvc/worktrack.git
cd worktrack
```

---

### 3. Configurar o Banco de Dados

Crie um banco no PostgreSQL com o nome `worktrack`.  
Depois, edite o arquivo `src/main/resources/application.properties` com suas credenciais:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/worktrack
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
springdoc.swagger-ui.path=/swagger-ui.html
```

> 💡 Em ambiente de testes, você pode usar o banco H2 in-memory alterando o driver e a URL.

---

### 4. Importar o Projeto

Abra o projeto na IDE de sua escolha como um projeto Maven e aguarde a importação das dependências.

---

### 5. Executar a Aplicação

Rode a aplicação pela classe `WorkTrackApplication.java`, que está no pacote principal:

```java
com.wtproject.worktrack.WorkTrackApplication
```

Você verá os logs do Spring Boot indicando que o servidor está rodando em `http://localhost:8080`.

---

### 6. Acessar a Documentação da API

Acesse o Swagger UI para testar a API de forma interativa:

```
http://localhost:8080/swagger-ui.html
```

---

✅ Pronto! A API está rodando localmente e pronta para ser usada.
## 👤 Autor
Ana Luiza Farias Favacho do Nascimento – Unilasalle (2025)

---
