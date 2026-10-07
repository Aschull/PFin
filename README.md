# PFin - Personal Finance Tracker 💰

API REST desenvolvida em Java e Spring Boot para gestão e acompanhamento de finanças pessoais (receitas, despesas e saldo mensal).

O projeto foi construído utilizando os princípios de **Arquitetura Hexagonal (Ports & Adapters)** para garantir o desacoplamento das regras de negócio em relação a frameworks e detalhes de infraestrutura.

---

# Arquitetura Hexagonal

src/main/java/com/example/PFin/
├── domain/                          <-- CORE (Lógica de Negócio pura, zero Spring)
│    ├── model/
│    │    ├── Transaction.java       // Objeto de domínio imutável
│    │    ├── TransactionType.java   // Enum: EARNING, EXPENSE
│    │    └── MonthlySummary.java    // Value Object para o saldo/resumo
│    ├── ports/
│    │    ├── in/                    // Casos de Uso que a API/CLI chama
│    │    │    ├── CreateTransactionUseCase.java
│    │    │    ├── ListTransactionsUseCase.java
│    │    │    └── GetMonthlySummaryUseCase.java
│    │    └── out/                   // Contratos para persistência/sistemas externos
│    │         └── TransactionRepositoryPort.java
│    └── service/                    // Implementação dos Casos de Uso (regras do negócio)
│         └── TransactionDomainService.java
│
├── infrastructure/                  <-- ADAPTADORES (Frameworks, DB, Web)
│    ├── adapters/
│    │    ├── in/web/                // Adaptador de Entrada (REST API)
│    │    │    ├── TransactionController.java
│    │    │    ├── dto/              // Records de entrada/saída (Request/Response)
│    │    │    └── mapper/           // Mapeia DTO <-> Domain
│    │    └── out/persistence/       // Adaptador de Saída (Spring Data JPA)
│    │         ├── TransactionEntity.java       // Entidade JPA com @Entity
│    │         ├── SpringDataTransactionRepo.java // Interface JpaRepository
│    │         └── TransactionPersistenceAdapter.java // Implementa TransactionRepositoryPort
│    └── config/                     // Injeção de dependências e Beans do Spring
│         └── BeanConfiguration.java
│
└── PFinApplication.java

# 🛠️ Tecnologias Utilizadas
 - Java 21
 - Spring Boot 3 (Spring Web, Spring Data JPA, Validation)
 - H2 Database (Banco de dados em memória para desenvolvimento)
 - Gradle (Gerenciador de dependências e build)
 - Git (Controlo de versão)

# 🚀 Como Executar o Projeto

# Pré-requisitos
 - Java 21 instalado
 - Git
 - ./gradlew bootRun

# A aplicação estará disponível em http://localhost:8080.

# 📌 Endpoints da API

 - POST/api/transactions - Regista uma nova transação (Receita ou Despesa)
 - GET/api/transactions - Lista as transações registadas
 - GET/api/transactions/summary - Retorna o resumo do saldo e totais
 - DELETE/api/transactions/{id} - Remove uma transação por ID🗄️ 

# Acesso ao Banco de Dados (Console H2)
 - URL: http://localhost:8080/h2-consoleJDBC
 - URL: jdbc:h2:mem:financetrackerdbUser: saPassword: (deixar em branco)

<ElicitationsGroup message="Quer criar o primeiro pacote do Core (Domain) para começarmos a codificar a regra de negócio?">
  <Elicitation label="Criar a classe Transaction no pacote domain/model" query="Pode mostrar como implementar a classe Transaction.java pura no pacote domain/model?"/>
  <Elicitation label="Criar as interfaces de Portas (ports/in e ports/out)" query="Como criar as interfaces de portas de entrada e saída na arquitetura hexagonal?"/>
</ElicitationsGroup>
