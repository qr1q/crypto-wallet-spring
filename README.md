<div align="center">
  <h1>Crypto Wallet Simulator</h1>

  <p>
    <strong>Минимальный, но полностью рабочий REST API для симуляции крипто-кошелька</strong><br>
    Spring Boot 4 · Java 25 · PostgreSQL · JPA/Hibernate
  </p>

  <p>
    <img src="https://img.shields.io/badge/Java-25-orange?style=flat-square&logo=openjdk&logoColor=white" alt="Java 25">
    <img src="https://img.shields.io/badge/Spring%20Boot-4.0.3-brightgreen?style=flat-square&logo=spring&logoColor=white" alt="Spring Boot">
    <img src="https://img.shields.io/badge/PostgreSQL-18-336791?style=flat-square&logo=postgresql&logoColor=white" alt="PostgreSQL">
    <img src="https://img.shields.io/badge/Maven-3.9-blue?style=flat-square&logo=apachemaven&logoColor=white" alt="Maven">
    <img src="https://img.shields.io/badge/Lombok-1.18.34-blueviolet?style=flat-square" alt="Lombok">
  </p>
</div>

## О проекте

Простой backend-сервис для демонстрации работы с финтех-логикой:  
создание крипто-кошельков, хранение баланса, базовые операции через REST API.

Создан в рамках самообучения для позиции **Junior Java Developer** в направлении fintech / backend.

### Основные возможности
- Подключение к реальной PostgreSQL базе через HikariCP
- Автоматическое создание и обновление схемы (Hibernate `ddl-auto: update`)
- REST API с CRUD-операциями для сущности Wallet
- Spring Data JPA репозиторий без boilerplate-кода
- Минимальная структура слоёв (entity → repository → controller)

### Технологический стек
- Java 25 (Temurin)
- Spring Boot 4.0.3
- Spring Data JPA + Hibernate
- PostgreSQL 18
- Maven
- Lombok
- HikariCP (connection pooling)

## Быстрый старт

### Требования
- Java 25+
- Maven 3.9+
- PostgreSQL 16+ (рекомендуется 18)
- Git

### Установка и запуск

1. Клонируйте репозиторий
   ```bash
   git clone https://github.com/qr1q/crypto-wallet-spring.git
   cd crypto-wallet-spring/crypto-wallet
   ```

2. Настройте подключение к базе данных  
   Откройте `src/main/resources/application.yml` и укажите свои параметры:

   ```yaml
   spring:
     datasource:
       url: jdbc:postgresql://localhost:5432/crypto_wallet_db
       username: postgres
       # password: ваш_пароль_от_postgres
   ```

   База данных должна быть создана заранее (например, через pgAdmin или команду `createdb crypto_wallet_db`).

3. Запустите приложение
   ```bash
   mvn clean spring-boot:run
   ```

   Приложение стартует на: **http://localhost:8081**

### Примеры запросов

#### POST /api/wallets — Создать кошелёк

```bash
curl -X POST http://localhost:8081/api/wallets \
  -H "Content-Type: application/json" \
  -d '{
        "currency": "USDT",
        "balance": 1500.00,
        "userId": 1
      }'
```

Ожидаемый ответ (201 Created):
```json
{
  "id": 1,
  "currency": "USDT",
  "balance": 1500.00,
  "userId": 1
}
```

#### GET /api/wallets/{id} — Получить кошелёк

```bash
curl http://localhost:8081/api/wallets/1
```

Ожидаемый ответ (200 OK):
```json
{
  "id": 1,
  "currency": "USDT",
  "balance": 1500.00,
  "userId": 1
}
```

## Структура проекта

```
crypto-wallet/
├── src/
│   ├── main/
│   │   ├── java/com/example/crypto_wallet/
│   │   │   ├── entity/
│   │   │   │   └── Wallet.java
│   │   │   ├── repository/
│   │   │   │   └── WalletRepository.java
│   │   │   ├── controller/
│   │   │   │   └── WalletController.java
│   │   │   └── CryptoWalletApplication.java
│   │   └── resources/
│   │       └── application.yml
│   └── test/
├── pom.xml
└── README.md
```

## Планы развития (Roadmap)

- Добавить валидацию входных данных (@Valid, @Positive, @NotNull)
- Вынести бизнес-логику в сервисный слой (WalletService)
- Реализовать операции deposit / withdraw с проверкой баланса
- Добавить обработку ошибок (@ControllerAdvice + custom exceptions)
- Написать интеграционные и юнит-тесты (JUnit 5 + Mockito)
- Подключить Swagger / OpenAPI для автоматической документации API
- Добавить Docker + docker-compose
- Реализовать базовую авторизацию (Spring Security + JWT)


## Автор

**Katerina**  
Junior Java Developer  
[LinkedIn] www.linkedin.com/in/katerina-tropashko-7b0112295
[Telegram] https://t.me/tropkaaa
