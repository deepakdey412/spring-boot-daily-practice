# Spring Boot Daily Practice – Day 10

## 📌 Today's Progress: Spring Data JPA & CRUD Operations  

Today I explored **Spring Data JPA** in depth and successfully implemented a full **CRUD (Create, Read, Update, Delete) operation** in my project. 🚀  

### ✅ What I Learned:
- Basics of **Spring Data JPA** and its integration with Spring Boot.
- Importance of **Entity classes** and mapping them with database tables.
- Using **JpaRepository** interface for built-in methods (like `save()`, `findAll()`, `findById()`, `deleteById()`).
- How to write **custom queries** with method naming conventions.
- Difference between **@Entity, @Table, @Id, @GeneratedValue, @Column** annotations.
- Setting up **application.properties** for MySQL database connection.  

### 🔨 What I Built:
- Created an **Entity class** (e.g., `User`).
- Created a **Repository interface** extending `JpaRepository`.
- Implemented a **Service layer** for business logic.
- Exposed **RESTful APIs** in a Controller for CRUD operations.
- Tested the APIs using **Postman**.

### 📂 CRUD Endpoints Example:
- `POST /users` → Create a new User  
- `GET /users` → Fetch all Users  
- `GET /users/{id}` → Fetch User by ID  
- `PUT /users/{id}` → Update User details  
- `DELETE /users/{id}` → Delete User by ID  

---

📖 **Next Step**: Move towards learning **Spring Security** for authentication & authorization. 🔐  

---
