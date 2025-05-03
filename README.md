# AuthService – Spring Boot Clean Architecture

A lightweight **Authentication Microservice** built with **Spring Boot 3.4.5**, **JWT**, and **PostgreSQL**, following a modular **Clean Architecture** for scalability, testability, and maintainability.

---

## 🔧 Tech Stack

- **Java 17**
- **Spring Boot 3.4.5**
- **Spring Security (JWT-based)**
- **PostgreSQL**
- **Swagger / OpenAPI 3** (`springdoc-openapi-starter-webmvc-ui:2.3.0`)
- **Lombok**
- **MapStruct** (optional)
- **Maven**
- **Clean Architecture Pattern**

---

## 🗂️ Project Structure

```
src/main/java/com/mezza/authservice/
│
├── application       # Interfaces for use cases (e.g., AuthService)
│   └── service
│       └── impl      # Business logic implementations
│
├── domain            # Core models (User, Role, etc.)
│
├── infrastructure    # Configuration & external services
│   ├── config
│   └── security      # JWT filter, security config, etc.
│
├── repository        # JPA Repositories (UserRepository, etc.)
│
├── web               # REST Controllers & DTOs
│
└── AuthserviceApplication.java
```

---

## ⚙️ Setup Instructions

### 1. Clone the Repo

```bash
git clone https://github.com/dkmezza/authservice-springboot-clean-architecture.git
cd authservice-springboot-clean-architecture
```

### 2. Configure the Database

Edit `src/main/resources/application.yml`:

```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/auth_db
    username: postgres
    password: your_password

  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
```

### 3. Run the App

```bash
./mvnw spring-boot:run
```

---

## 📚 Swagger API Docs

> Available at: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

Make sure the following paths are whitelisted in `SecurityConfig`:

```java
.requestMatchers("/v3/api-docs/**", "/swagger-ui/**", "/swagger-ui.html").permitAll()
```

---

## 🔐 API Endpoints

| Method | Route                   | Description                       |
|--------|-------------------------|-----------------------------------|
| POST   | `/auth/register`        | Register new user                 |
| POST   | `/auth/login`           | Login and get tokens              |
| POST   | `/auth/logout`          | Logout and invalidate tokens      |
| POST   | `/auth/refresh`         | Get new access token from refresh |
| GET    | `/auth/me`              | Get current authenticated user    |
| PUT    | `/auth/profile`         | Update user profile               |
| POST   | `/auth/change-password` | Change user password              |

> ✅ Add `Authorization: Bearer <JWT>` in headers for protected endpoints.

---

## 🚀 Upcoming Enhancements

- [ ] Add role-based authorization
- [ ] Dockerize the service
- [ ] Add unit & integration tests
- [ ] CI/CD with GitHub Actions

---

## 📄 License

MIT

---

## 👨‍💻 Author

**David Mezza** — Backend Engineer | Spring Boot Enthusiast  
[GitHub](https://github.com/dkmezza)
