# Day 06 – Spring Security Custom Configuration

## 📅 Date
14 August 2025

## 📌 Overview
Today, I worked on customizing Spring Security configuration for a Spring Boot application instead of relying on the default settings. This included creating my own security rules, configuring URL access permissions, and defining authentication mechanisms.

---

## 🛠️ What I Did Today
1. **Created a Spring Security Configuration Class**
   - Used `@Configuration` and `@EnableWebSecurity` annotations.
   - Implemented `SecurityFilterChain` bean to define custom security rules.
   - Disabled default `formLogin()` and configured my own login endpoints.

2. **Custom Authentication Rules**
   - Configured which endpoints should be **public** and which should be **secured**.
   - Added `permitAll()` for specific routes.
   - Secured other routes using `authenticated()`.

3. **Configured CSRF and Session**
   - Learned about CSRF protection and when to disable it.
   - Understood session management basics with Spring Security.

4. **Business Logic Implementation**
   - Created a controller with sample endpoints to test security rules.
   - Verified login flow and endpoint restrictions using Postman and browser.

---

## 📂 Files Created / Updated
- `SecurityConfig.java` – Custom Spring Security configuration.
- `UserController.java` – Test endpoints for authentication and authorization.
- `application.properties` – Security-related properties.

---

## 📚 Key Learnings
- How to replace Spring Security’s default behavior with custom configurations.
- Understanding `SecurityFilterChain` and its role in securing the application.
- Role of CSRF in web security and why it matters.
- How `permitAll()` and `authenticated()` control access to endpoints.

---

## ▶️ How to Run the Project
1. Clone this repository.
2. Open in your preferred IDE (IntelliJ, Eclipse, etc.).
3. Make sure you have MySQL running (if connected to DB) or use in-memory DB.
4. Run the Spring Boot application.
5. Test secured and public endpoints via browser or Postman.

---


