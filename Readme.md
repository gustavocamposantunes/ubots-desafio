# 📞 Ubots - Desafio Técnico

Este projeto foi desenvolvido como solução para o desafio técnico da vaga de Desenvolvedor(a) na Ubots.  
O objetivo é criar um sistema para distribuir solicitações de atendimento para diferentes times, respeitando a capacidade de cada atendente e gerenciando filas de espera.

---

## 🚀 Tecnologias Utilizadas
- **Java 17**
- **Spring Boot 3.2.5**
- **Springdoc OpenAPI (Swagger UI)**
- **JUnit 5** para testes unitários
- **Maven** como gerenciador de dependências

---

## 📋 Funcionalidades
- Distribuição de solicitações para times específicos:
  - **Cartões**
  - **Empréstimos**
  - **Outros Assuntos**
- Limite de **3 atendimentos simultâneos por atendente**
- Fila de espera quando todos os atendentes do time estão ocupados
- Consulta em tempo real de atendimentos ativos e fila
- Finalização de atendimento, liberando o atendente
- Escolha manual do **time** na solicitação
- Indicação de solicitação como **favorita** (campo opcional)

---

## 📂 Estrutura do Projeto
# 📞 Ubots - Desafio Técnico

Este projeto foi desenvolvido como solução para o desafio técnico da vaga de Desenvolvedor(a) na Ubots.  
O objetivo é criar um sistema para distribuir solicitações de atendimento para diferentes times, respeitando a capacidade de cada atendente e gerenciando filas de espera.

---

## 🚀 Tecnologias Utilizadas
- **Java 17**
- **Spring Boot 3.2.5**
- **Springdoc OpenAPI (Swagger UI)**
- **JUnit 5** para testes unitários
- **Maven** como gerenciador de dependências

---

## 📋 Funcionalidades
- Distribuição de solicitações para times específicos:
  - **Cartões**
  - **Empréstimos**
  - **Outros Assuntos**
- Limite de **3 atendimentos simultâneos por atendente**
- Fila de espera quando todos os atendentes do time estão ocupados
- Consulta em tempo real de atendimentos ativos e fila
- Finalização de atendimento, liberando o atendente
- Escolha manual do **time** na solicitação
- Indicação de solicitação como **favorita** (campo opcional)

---

## 📂 Estrutura do Projeto
# 📞 Ubots - Desafio Técnico

Este projeto foi desenvolvido como solução para o desafio técnico da vaga de Desenvolvedor(a) na Ubots.  
O objetivo é criar um sistema para distribuir solicitações de atendimento para diferentes times, respeitando a capacidade de cada atendente e gerenciando filas de espera.

---

## 🚀 Tecnologias Utilizadas
- **Java 17**
- **Spring Boot 3.2.5**
- **Springdoc OpenAPI (Swagger UI)**
- **JUnit 5** para testes unitários
- **Maven** como gerenciador de dependências

---

## 📋 Funcionalidades
- Distribuição de solicitações para times específicos:
  - **Cartões**
  - **Empréstimos**
  - **Outros Assuntos**
- Limite de **3 atendimentos simultâneos por atendente**
- Fila de espera quando todos os atendentes do time estão ocupados
- Consulta em tempo real de atendimentos ativos e fila
- Finalização de atendimento, liberando o atendente
- Escolha manual do **time** na solicitação
- Indicação de solicitação como **favorita** (campo opcional)

---

## 📂 Estrutura do Projeto
````
src/
├── main/java/com/ubots
│ ├── UbotsApplication.java # Classe principal
│ ├── controller/ # Controllers REST
│ ├── dto/ # Objetos de transferência de dados (DTOs)
│ ├── model/ # Modelos de domínio
│ └── service/ # Lógica de distribuição
└── test/java/com/ubots # Testes unitários
````

## 3️⃣ Executar o projeto

````
mvn spring-boot:run
````

A aplicação estará disponível em:
````
http://localhost:8080
````

## 📖 Documentação da API
Acesse a documentação interativa do Swagger em:
````
http://localhost:8080/swagger-ui/index.html
````

Endpoints principais

* POST /solicitacoes → Cria uma solicitação e a distribui para o time
* GET /solicitacoes/status → Lista atendentes e fila em tempo real
* DELETE /solicitacoes/finalizar → Finaliza um atendimento (recebe DTO com time e atendente)

# 🧪 Executar Testes Unitários
Para rodar todos os testes:
````
mvn test
````

# 📌 Exemplo de Solicitação no Swagger
````
{
  "cliente": "Maria",
  "assunto": "Problemas com cartão",
  "time": "Cartões",
  "favorito": true
}
````

## ✨ Autor

* Desenvolvido por Gustavo Antunes
* 📧 Email: gustavocamposantunes@gmail.com
* 💼 [LinkedIn](https://www.linkedin.com/in/gustavo-antunes-347853163/)