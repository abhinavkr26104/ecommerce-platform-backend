# Ecommerce Platform Backend

A scalable e-commerce backend built with **Spring Boot**, **Spring Data JPA**, and **MySQL**. The application exposes RESTful APIs for product management, inventory tracking, and shopping cart operations.

## Features

- Product CRUD Operations
- Inventory Management
- Shopping Cart APIs
- RESTful Architecture
- Database Integration using Spring Data JPA
- Layered Architecture (Controller-Service-Repository)
- Exception Handling
- DTO-based API Design
- CORS Configuration for Frontend Integration

## Tech Stack

- Java
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- REST APIs

## Project Structure

```text
src/main/java
├── controller/
├── service/
├── repository/
├── model/
├── dto/
├── exception/
└── EcommerceApplication.java
```

## Getting Started

### Prerequisites

- Java 17+
- Maven
- MySQL

### Installation

```bash
git clone https://github.com/abhinavkr26104/ecommerce-platform-backend.git

cd ecommerce-platform-backend
```

### Configure Database

Update:

```properties
src/main/resources/application.properties
```

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/ecommerce_db
spring.datasource.username=root
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### Run Application

```bash
mvn spring-boot:run
```

Server runs on:

```text
http://localhost:8080
```

## API Endpoints

### Products

```http
GET    /products
GET    /products/{id}
POST   /products
PUT    /products/{id}
DELETE /products/{id}
```

### Cart

```http
GET    /cart
POST   /cart/add
DELETE /cart/remove/{id}
```

### Inventory

```http
GET    /inventory
PUT    /inventory/{id}
```

## Frontend Repository

Frontend:

https://github.com/abhinavkr26104/ecommerce-platform-frontend

## Future Enhancements

- JWT Authentication
- Role-Based Authorization
- Order Management
- Payment Gateway Integration
- Wishlist Functionality
- Product Reviews & Ratings
- Search & Filtering APIs
- Docker Deployment
- Redis Caching

## Author

**Abhinav Kumar Singh**

- GitHub: https://github.com/abhinavkr26104
- LinkedIn: https://www.linkedin.com/in/abhinav26104/

---

ICPC Asia West Regionalist '25 | LeetCode Knight | Codeforces Specialist | 6★ Problem Solving (HackerRank)
