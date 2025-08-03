# 📅 Day 3 – Validation in Spring Boot

Welcome to Day 3 of my Spring Boot learning journey!  
Today, I focused on **handling validation** in both REST APIs and Thymeleaf forms using Spring Boot's built-in support.

---

## ✅ What I Learned Today

### 🔹 1. Bean Validation (Hibernate Validator)
- Used Java Bean Validation (JSR 380) annotations for form and data validation.
- Implemented validation for request bodies in REST APIs and model attributes in Thymeleaf forms.

### 🔹 2. Common Validation Annotations
| Annotation       | Purpose                              |
|------------------|---------------------------------------|
| `@NotBlank`      | Field must not be `null` or empty     |
| `@NotNull`       | Field must not be `null`              |
| `@Size`          | Length constraints (`min`, `max`)     |
| `@Email`         | Valid email format                    |
| `@Min` / `@Max`  | Numeric range constraints             |

### 🔹 3. Handling Validation in Controllers
- Used `@Valid` annotation with `@RequestBody` or `@ModelAttribute`.
- Used `BindingResult` to capture validation errors in web forms.
- Displayed custom error messages in Thymeleaf forms.

---

## ⚙️ Dependencies Used (in `pom.xml`)

```xml
<!-- Spring Web -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>

<!-- Spring Validation (included in web starter but Hibernate Validator is used under the hood) -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-validation</artifactId>
</dependency>

