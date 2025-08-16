
# Day08 – AuthenticationProvider | UserDetails | PasswordEncoder (Practice)

## 📌 What I Did Today
- Implemented **custom authentication** in Spring Security using:
  - **AuthenticationProvider** for handling custom auth logic.
  - **UserDetails & UserDetailsService** for loading user-specific data.
  - **PasswordEncoder (BCrypt)** for securely hashing and validating passwords.
- Connected the authentication flow with a database-backed user model.
- Tested role-based login with encrypted passwords.

---

## ⚡ Challenges Faced
1. **Confusion in integrating AuthenticationProvider with UserDetailsService**  
   - Initially, I was not sure how `AuthenticationProvider` interacts with `UserDetailsService` and `PasswordEncoder`.
   
2. **Password not matching during login**  
   - Encountered an issue where the raw password was not matching the encoded one.
   
3. **Spring Security configuration errors**  
   - Faced multiple errors while overriding `configure(AuthenticationManagerBuilder)` and registering beans properly.

---

## ✅ How I Tackled Them
- Revisited Spring Security flow: **UsernamePasswordAuthenticationToken → AuthenticationProvider → UserDetailsService → PasswordEncoder**.
- Carefully used `BCryptPasswordEncoder` for encoding at registration time and validating during login.
- Defined `@Bean` methods for `AuthenticationProvider` and `PasswordEncoder` inside the Security configuration class.
- Debugged step-by-step by printing authentication details and stack traces to pinpoint the issue.
- Checked official Spring Security docs + examples to clarify the correct integration approach.

---

## 🎯 Learning Outcome
- Gained a strong understanding of **how Spring Security internally authenticates users**.  
- Learned **why AuthenticationProvider is powerful** when we need custom login logic.  
- Realized the importance of **encoding passwords before saving** and consistently using the same encoder for validation.  
- Got hands-on experience with **custom UserDetails implementation**.

---

🚀 Day 08 completed successfully! Moving closer to mastering **Spring Security** 🔐
