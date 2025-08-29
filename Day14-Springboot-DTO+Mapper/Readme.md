# DTO & Mapper in Spring Boot

## 1️⃣ What is DTO (Data Transfer Object)?

* DTO is a **plain Java object** used to transfer data between layers (usually **Controller ↔ Service**).
* It usually contains only **fields needed for the request/response**, not the full Entity.
* Purpose:

  1. Separate **internal entity structure** from API.
  2. Validation at API layer.
  3. Avoid exposing sensitive data (e.g., password in response).

**Example:**

```java
public class UserDTO {
    private int id;
    private String name;
    private String email;
    private String password; // input only
}
```

## 2️⃣ What is Entity?

* Entity is a **database mapping class**.
* Annotated with `@Entity`, fields map to DB table columns.

**Example:**

```java
@Entity
@Table(name="users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;
    private String password;
}
```

## 3️⃣ What is Mapper?

* Mapper is a **utility class** that converts between **DTO and Entity**.
* Helps maintain separation of concerns:

  * Controller/Service works with DTO
  * Repository works with Entity

**Example Mapper:**

```java
@Component
public class UserMapper {

    public UserDTO toDTO(UserEntity userEntity) {
        if (userEntity == null) return null;
        UserDTO dto = new UserDTO();
        dto.setId(userEntity.getId());
        dto.setName(userEntity.getName());
        dto.setEmail(userEntity.getEmail());
        // Password usually not returned in response
        return dto;
    }

    public UserEntity toEntity(UserDTO userDTO) {
        if (userDTO == null) return null;
        UserEntity entity = new UserEntity();
        entity.setId(userDTO.getId());
        entity.setName(userDTO.getName());
        entity.setEmail(userDTO.getEmail());
        entity.setPassword(userDTO.getPassword()); // input
        return entity;
    }
}
```

## 4️⃣ Why DTO + Mapper?

* Security: avoid exposing DB fields (e.g., password)
* Validation: `@Valid` works on DTO before hitting DB
* Flexibility: API response can change without touching entity
* Clean code: service layer deals with DTO, repository with entity

## 5️⃣ Data Flow Diagram

```
Client JSON
    |
    v
[Controller]  <--- receives @RequestBody DTO
    |
    v
[Service]  <--- business logic & validation
    |
    v
[Mapper]  <--- converts DTO -> Entity
    |
    v
[Repository]  <--- JPA save/find/delete
    |
    v
[Database Table]
```

**Return Flow (DB → Client)**:

```
[Database Table]
    |
    v
[Repository]  → Entity
    |
    v
[Mapper]  → DTO
    |
    v
[Service]  → processed DTO
    |
    v
[Controller]  → ResponseEntity JSON
    |
    v
Client receives JSON
```

## 6️⃣ Key Points

1. **DTO**: for data transfer & validation (input/output)
2. **Entity**: DB mapping & persistence
3. **Mapper**: converts DTO ↔ Entity
4. **Controller**: handles HTTP request/response
5. **Service**: business logic
6. **Repository**: persistence layer (DB CRUD)
7. **Validation**: always apply `@Valid` on DTO in Controller
8. **Security**: never expose password in DTO response
9. **Optional**: Mapper can also handle **list conversion** and **Optional mapping**
