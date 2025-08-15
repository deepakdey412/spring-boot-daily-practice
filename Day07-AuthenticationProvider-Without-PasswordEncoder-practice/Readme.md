# Day 07 – AuthenticationProvider (Without PasswordEncoder) Practice

---

## 📌 What I Did Today
- Implemented **AuthenticationProvider** in Spring Boot for custom authentication logic.
- Created a simple login system **without** using `PasswordEncoder`.
- Connected authentication logic with **Spring Security** flow.
- Used **UserRepo** to fetch user details from the database using `findByUsername`.
- Added logic to compare the plain text password from the request with the stored password in DB.
- Tested API endpoints (`/register` and `/login`) using **Postman**.

---

## 📚 What I Learned
- How `AuthenticationProvider` works in the **Spring Security authentication process**.
- Role of `UsernamePasswordAuthenticationToken` in handling login credentials.
- Difference between **default Spring Security authentication** and **custom authentication**.
- How to manually validate a user’s credentials without encryption.
- Importance of fetching user details using repository methods like `findByUsername`.

---

## 🎯 Tomorrow’s Plan
- Implement **Password Encryption** using `BCryptPasswordEncoder`.
- Learn and practice how to:
  - Encode passwords before storing in the database.
  - Match raw passwords with encoded passwords during login.
- Update the existing login system to follow **secure authentication** best practices.

---

## 🛠 Tech Stack Used
- Java 17
- Spring Boot 3.x
- Spring Security
- Spring Data JPA
- MySQL
- Postman (API testing)

---

## 🚀 How to Run This Project
1. Clone this repository:
   ```bash
   git clone https://github.com/YourUsername/Day07-AuthenticationProvider-Without-PasswordEncoder-practice.git
