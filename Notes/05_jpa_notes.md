#  Spring Data JPA & JpaRepository (Simple Explanation)

## 🔹 What is Spring Data JPA?

Spring Data JPA is a library that helps you interact with the database easily without writing SQL queries manually.

👉 Instead of writing SQL:
SELECT * FROM user;

👉 You just write:
userRepository.findAll();

✔ Less code  
✔ Faster development  
✔ Cleaner code

---

## 🔹 What is JPA?

JPA (Java Persistence API) is a specification (set of rules).

👉 It defines how Java objects are mapped to database tables.

Example:
```
@Entity
public class User {
private int id;
private String name;
}
```

✔ Class → Table  
✔ Object → Row

---

## 🔹 What is Hibernate?

Hibernate is the implementation of JPA.

👉 JPA = rules  
👉 Hibernate = actual working engine

---

## 🔹 What is JpaRepository?

JpaRepository is an interface that provides ready-made database operations.

Example:

public interface UserRepository extends JpaRepository<User, Integer> {
}

---

## 🔥 Methods provided by JpaRepository

- save(user) → insert/update
- findAll() → get all data
- findById(id) → get one record
- deleteById(id) → delete record
- existsById(id) → check existence

---

## 🔹 Flow

Controller → Service → Repository → JPA → Hibernate → MySQL

---

# 🔹 Steps to Connect MySQL (Docker) with Spring Boot

## 1️⃣ Run MySQL in Docker

```bash
docker rm -f mysql-container

docker run -d \
--name mysql-container \
-e MYSQL_ROOT_PASSWORD=root \
-e MYSQL_DATABASE=testdb \
-e MYSQL_ROOT_HOST=% \
-p 3307:3306 \
mysql:8
```

👉 Important:
- Port = 3307 (since 3306 already used)

---

## 2️⃣ Add Dependencies in pom.xml

```xml
<dependencies>

    <!-- Spring Web -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>

    <!-- Spring Data JPA -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>

    <!-- MySQL Driver -->
    <dependency>
        <groupId>com.mysql</groupId>
        <artifactId>mysql-connector-j</artifactId>
    </dependency>

</dependencies>
```

---

## 3️⃣ application.properties

```properties
spring.datasource.url=jdbc:mysql://localhost:3307/testdb
spring.datasource.username=root
spring.datasource.password=root

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

👉 DO NOT add dialect manually (Spring Boot auto-detects)

---

## 4️⃣ Create Entity (Model)

```java
package com.rajvardhan.ecommerce_springboot_backend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class User {

    @Id
    private int id;
    private String name;

    public User() {}

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
```

---

## 5️⃣ Create Repository

```java
package com.rajvardhan.ecommerce_springboot_backend.repository;

import com.rajvardhan.ecommerce_springboot_backend.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
```

---

## 6️⃣ Run Application

```bash
mvn spring-boot:run
```

---

# 🔹 What to Send in Postman

## 🔸 Create User (POST)

URL:
```
http://localhost:8080/users
```

Body (JSON):
```json
{
  "id": 1,
  "name": "Raj"
}
```

---

## 🔸 Get All Users (GET)

```
http://localhost:8080/users
```

---

## 🔸 Get User By ID (GET)

```
http://localhost:8080/users/1
```

---

## 🔸 Update User (PUT)

```
http://localhost:8080/users/1
```

Body:
```json
{
  "name": "Raj Updated"
}
```

---

## 🔸 Delete User (DELETE)

```
http://localhost:8080/users/1
```


---

# ✅ Final Flow

Controller → Service → Repository → Database

---

