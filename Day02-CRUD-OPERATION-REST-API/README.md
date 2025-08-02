# 🚀 Day 02 - CRUD Operation REST API with Spring Boot

This project is part of my **Spring Boot Daily Practice Series**. On Day 2, I built a simple CRUD REST API using Spring Boot which performs basic operations (Create, Read, Delete) on a `UserModel` entity.

## 📁 Project Structure

- **Controller Layer**: Handles HTTP requests and routes them to the service layer.
- **Service Layer**: Contains the business logic and connects to the repository layer.
- **Model Layer**: Defines the `UserModel` entity.
- **Repository Layer** (Not shown here but assumed): Connects with the database using Spring Data JPA.

---

## 📌 Features Implemented

| Endpoint                     | Method   | Description                         |
|-----------------------------|----------|-------------------------------------|
| `/api/save`                 | POST     | Save a new user                     |
| `/api/printAllUser`         | GET      | Retrieve all users                  |
| `/api/getbyid/{id}`         | GET      | Retrieve a user by ID               |
| `/api/deleteByid/{id}`      | DELETE   | Delete a user by ID                 |
| `/api/deleteAll`            | DELETE   | Delete all users                    |

---

## 📦 Dependencies Used

| Dependency                   | Purpose                                          |
|-----------------------------|--------------------------------------------------|
| `spring-boot-starter-web`   | To build RESTful web applications                |
| `spring-boot-starter-data-jpa` | To interact with the database using JPA       |
| `mysql-connector-java` | For the database (H2 or MySQL as used)     |
| `lombok` *(optional)*        | To reduce boilerplate code (if used)             |
| `spring-boot-devtools`      | For hot reloading during development             |

---

## 🛠 How to Run the Project

1. Clone the repo:
   ```bash
   git clone https://github.com/deepakdey412/spring-boot-daily-practice.git
