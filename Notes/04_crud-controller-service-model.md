# Spring Boot – Controller, Service, Model + Annotations (Full Theory + Code)

## 1. Overview (Flow)

Spring Boot follows layered architecture:

Client → Controller → Service → Model → Response

- Controller → Handles HTTP request
- Service → Business logic
- Model → Data structure (POJO)

---

## 2. Important Annotations (Theory First)

### @RestController
- Used to create REST APIs
- Combines @Controller + @ResponseBody
- Returns JSON directly (no HTML page)

---

### @Service
- Marks a class as Service layer
- Contains business logic
- Managed by Spring (Bean)

---

### @Component
- Generic annotation to make a class a Spring Bean
- @Service, @Repository, @Controller are specialized versions

---

### @RequestMapping
- Defines base URL for controller

Example:
@RequestMapping("/users")

---

### @GetMapping
- Handles HTTP GET request
- Used to fetch data

---

### @PostMapping
- Handles HTTP POST request
- Used to create data

---

### @PutMapping
- Handles HTTP PUT request
- Used to update data

---

### @DeleteMapping
- Handles HTTP DELETE request
- Used to delete data

---

### @PathVariable
- Used to get value from URL

Example:
@GetMapping("/{id}")
→ /users/5 → id = 5

---

### @RequestBody
- Used to get JSON data from request
- Converts JSON → Java Object

---

## 3. Model (User Class)

```
public class User {
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

## 4. Service Layer (In-Memory Data)
```
@Service
public class UserService {

    private List<User> users = new ArrayList<>();

    public UserService() {
        users.add(new User(1, "Raj"));
        users.add(new User(2, "Amit"));
    }

    // GET ALL USERS
    public List<User> getAllUsers() {
        return users;
    }

    // GET USER BY ID
    public User getUserById(int id) {
        for (User u : users) {
            if (u.getId() == id) return u;
        }
        return null;
    }

    // CREATE USER
    public User createUser(User user) {
        users.add(user);
        return user;
    }

    // UPDATE USER
    public User updateUser(int id, User newUser) {
        for (User u : users) {
            if (u.getId() == id) {
                u.setName(newUser.getName());
                return u;
            }
        }
        return null;
    }

    // DELETE USER
    public String deleteUser(int id) {
        Iterator<User> it = users.iterator();
        while (it.hasNext()) {
            User u = it.next();
            if (u.getId() == id) {
                it.remove();
                return "Deleted user with id: " + id;
            }
        }
        return "User not found";
    }
}

```
---

## 5. Controller Layer
```
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    // GET ALL USERS
    @GetMapping
    public List<User> getAll() {
        return userService.getAllUsers();
    }

    // GET USER BY ID
    @GetMapping("/{id}")
    public User getById(@PathVariable int id) {
        return userService.getUserById(id);
    }

    // CREATE USER
    @PostMapping
    public User create(@RequestBody User user) {
        return userService.createUser(user);
    }

    // UPDATE USER
    @PutMapping("/{id}")
    public User update(@PathVariable int id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    // DELETE USER
    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        return userService.deleteUser(id);
    }
}
```
---

## 6. API Examples

GET /users  
GET /users/1  
POST /users  
PUT /users/1  
DELETE /users/1

---

## 7. Example JSON (Request Body)

{
"id": 3,
"name": "Rahul"
}

---

## 8. Key Takeaways

- @RestController → Handles API and returns JSON
- @Service → Business logic layer
- Model → Data structure
- @GetMapping → Fetch data
- @PostMapping → Create data
- @PutMapping → Update data
- @DeleteMapping → Delete data
- @PathVariable → Get value from URL
- @RequestBody → Get JSON from client
- Data stored in List (no database)