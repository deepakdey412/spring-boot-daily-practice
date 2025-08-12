# 📅 Day 05 – Spring Security Practice

## 📌 Overview
On **Day 05**, I started learning **Spring Security** and built a small project to understand:
- How Spring Security works
- Basics of authentication
- What CSRF is and why it is important
- How Session ID is related to CSRF protection

---

## 🛠 Project Details
**Project Name:** `springSecurityPractice`  
**Tech Stack:**  
- Java 17
- Spring Boot 3.x
- Spring Security
- REST API
- Maven

**Endpoints:**
| Method | Endpoint       | Description                              |
|--------|----------------|------------------------------------------|
| GET    | `/product`     | Get all products                         |
| POST   | `/product`     | Add a product (Requires CSRF token)      |
| GET    | `/csrf`        | Get CSRF token for the current session   |

---

## 🔍 What I Learned Today

### 1️⃣ **Spring Security Basics**
- How to set up Spring Security with default username/password in `application.properties`.
- How Spring Security automatically applies CSRF protection for **state-changing requests** (`POST`, `PUT`, `DELETE`).

### 2️⃣ **CSRF (Cross-Site Request Forgery)**
- **Definition:** An attack where a malicious site tricks your browser into sending a request to another site where you are already logged in.
- **How it works:** Browser automatically sends session cookies with the forged request → server thinks the request is from you.
- **Protection method:** Use a **CSRF token** – a unique, unpredictable value tied to your session.

### 3️⃣ **Session ID**
- When you log in or access the server, Spring creates a **Session ID** and stores it in a cookie.
- CSRF token is linked to this session — if the session changes, the token changes.
- Without a valid token and session ID, the request is rejected.

---

## 🛡 Why CSRF is Important
- **Prevents Unauthorized Actions:** Stops attackers from performing actions on your behalf using your session.
- **Session-bound Security:** Token is valid only for one active session.
- **Protects State-Changing APIs:** Ensures only trusted and intentional requests are processed.

---

## 📂 Example Flow (Using Postman)
1. **Step 1:** Call `GET /product/csrf` → Copy the token and `JSESSIONID`.
2. **Step 2:** For `POST` or `DELETE` requests:
   - Add `X-CSRF-TOKEN` header with the copied token.
   - Add `Cookie` header with `JSESSIONID=<your-session-id>`.
3. **Step 3:** Make the request → Spring Security will validate the token.

---

## 📝 Conclusion
Today’s session helped me understand **why CSRF protection is critical** in real-world web apps.  
Without it, attackers could trick users into performing actions they didn’t intend to.  
Now I know how to generate, fetch, and use CSRF tokens in a Spring Boot application.

---

