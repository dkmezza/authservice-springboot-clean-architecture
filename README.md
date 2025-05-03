# AuthService - Spring Boot Clean Architecture

A lightweight **Authentication Microservice** built with **Spring Boot 3**, **JWT**, and **PostgreSQL**, following a modular **clean architecture** for scalability and maintainability.

---

## 🔧 Tech Stack

- **Java 17**
- **Spring Boot 3.4.5**
- **Spring Security (JWT)**
- **PostgreSQL**
- **Maven**
- **Lombok**
- **MapStruct** (optional)
- **Clean Architecture Pattern**

---

## 🗂️ Project Structure

```
src/main/java/com/mezza/authservice/
│
├── application       # Business logic interfaces
│   └── service
│       └── impl      # AuthServiceImpl lives here
│
├── domain            # Core domain models like User, Role
│
├── infrastructure    # Configurations and external concerns
│   ├── config
│   └── security
│
├── repository        # JPA Repositories (UserRepository, RoleRepository)
│
├── web               # Controllers and request/response models
│
└── AuthserviceApplication.java
```

---

## ⚙️ Setup Instructions

### 1. Clone the repo
```bash
git clone https://github.com/dkmezza/authservice-springboot-clean-architecture.git
cd authservice-springboot-clean-architecture
```

### 2. Configure the database

Update `application.yml` or `application.properties`:

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

### 3. Run the app
```bash
./mvnw spring-boot:run
```

---

## 🔐 API Endpoints

| Method | Endpoint           | Description              |
|--------|--------------------|--------------------------|
| POST   | `/auth/register`   | Register a new user      |
| POST   | `/auth/login`      | Login and receive JWT    |

> Add your `Authorization: Bearer <token>` to access protected endpoints.

---

## 📦 To Do Next

- [ ] Add refresh tokens
- [ ] Add role-based authorization
- [ ] Dockerize the service
- [ ] Add unit & integration tests
- [ ] Set up CI/CD via GitHub Actions

---

## 📄 License

MIT

---

## ✨ Author

**David Mezza** — Backend Developer | Spring Boot Enthusiast
