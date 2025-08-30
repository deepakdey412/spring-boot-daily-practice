# Spring Security Practice

![Spring Security Architecture](diagram/Spring Security Architecture.png)

This project demonstrates the core components and flow of **Spring Security** in a Spring Boot application.

---

## Components in Simple Words

- **Client/Browser** – Sends requests (login, API calls).  
- **Spring Security Filter Chain** – Series of filters that intercept requests for security checks.  
- **Authentication Manager** – Validates credentials (username/password, JWT, etc.).  
- **Authorization Filter** – Checks user permissions for resources.  
- **CSRF Filter** – Prevents fake requests from other sites.  
- **UserDetailsService** – Loads user info from the database for authentication.  
- **SecurityContextHolder** – Stores authenticated user info for the current request.  
- **CsrfTokenRepository** – Generates and validates CSRF tokens.  
- **User Entity** – Database entity storing user info and roles.  

---

## CSRF & Session ID (used in MVC design only)

- CSRF tokens and Session IDs are used together for **MVC applications** to maintain security during state-changing requests (POST, PUT, DELETE).  
- Session ID tracks the logged-in user across requests.  
- CSRF token ensures the request is intentional and not forged.  
- **REST APIs or stateless applications** usually do not use Session or CSRF; instead, **JWT tokens** are used for authentication and authorization.

---
