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
```
# Spring Boot Validation: REST API vs MVC (Thymeleaf)

Validation in Spring Boot ensures that **incoming data is correct, safe, and consistent** before processing. It is implemented using **Java Bean Validation (JSR-380)** and works differently for **REST APIs** and **MVC applications**.

---

## 1. Validation in REST APIs

* **Controller type:** `@RestController`
* **Response type:** JSON (for frontend frameworks like React, Angular, Vue)
* **How it works:**

  1. Client sends a JSON request.
  2. Controller method parameter annotated with `@Valid` triggers validation.
  3. If validation fails, Spring throws `MethodArgumentNotValidException`.
  4. `@RestControllerAdvice` + `@ExceptionHandler` catches the exception.
  5. Errors are returned as JSON.

**Example:**

```java
@RestController
@RequestMapping("/users")
public class UserController {
    @PostMapping
    public ResponseEntity<String> createUser(@Valid @RequestBody UserDTO user) {
        return ResponseEntity.ok("User created successfully!");
    }
}

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationErrors(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors()
                .forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
```

**Sample JSON Response:**

```json
{
  "email": "Invalid email format",
  "password": "Password must be at least 8 characters"
}
```

---

## 2. Validation in MVC (Thymeleaf)

* **Controller type:** `@Controller`
* **Response type:** HTML page (server-rendered)
* **How it works:**

  1. Client submits form data.
  2. Controller method parameter annotated with `@Valid` triggers validation.
  3. `BindingResult` checks for errors **before processing the data**.
  4. If errors exist, controller returns the same view with error messages bound to the model.

**Example:**

```java
@Controller
@RequestMapping("/users")
public class UserController {

    @GetMapping("/register")
    public String showForm(UserDTO userDTO) {
        return "register"; // Thymeleaf template
    }

    @PostMapping("/register")
    public String submitForm(@Valid UserDTO userDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "register"; // redisplay form with errors
        }
        return "redirect:/success";
    }
}
```

**Thymeleaf template:**

```html
<form th:action="@{/users/register}" th:object="${userDTO}" method="post">
    <input type="text" th:field="*{name}" />
    <div th:if="${#fields.hasErrors('name')}" th:errors="*{name}"></div>

    <input type="email" th:field="*{email}" />
    <div th:if="${#fields.hasErrors('email')}" th:errors="*{email}"></div>

    <button type="submit">Register</button>
</form>
```

---

## 3. Key Differences

| Feature         | REST API                       | MVC (Thymeleaf)                    |
| --------------- | ------------------------------ | ---------------------------------- |
| Controller Type | `@RestController`              | `@Controller`                      |
| Response        | JSON                           | HTML page                          |
| Error Handling  | `@RestControllerAdvice` + JSON | `BindingResult` + redisplay form   |
| Frontend        | React / Angular / Vue          | Thymeleaf / JSP / Server-side HTML |
| Flow            | Exception → JSON               | BindingResult → View               |

---

## 4. Summary

* **REST APIs** → JSON response for frontend apps. Use global exception handler.
* **MVC apps** → Errors returned to the same page using `BindingResult`. No JSON needed.
* Validation ensures **data integrity, user-friendly feedback, and security** in both cases.



