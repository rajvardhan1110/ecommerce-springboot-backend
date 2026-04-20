# Spring Boot Request Annotations 

## 🔹 What are Request Annotations?
Used to get data from client (frontend) to backend controller.

----------------------------------------

## 1. @RequestBody

### ✔ Source:
JSON body

### ✔ Use:
Convert JSON → Java Object

### ✔ Example:
```
@PostMapping("/user")
public String create(@RequestBody User user) {
return user.getName();
}
```

### ✔ Input:
{
"id": 1,
"name": "Raj"
}

----------------------------------------

## 2. @RequestParam

### ✔ Source:
Query params (URL)

### ✔ Use:
Simple values

### ✔ Example:
```
@GetMapping("/user")
public String get(@RequestParam int id) {
return "Id: " + id;
}
```

### ✔ URL:
.../user?id=10

----------------------------------------

## 3. @PathVariable

### ✔ Source:
URL path

### ✔ Use:
REST APIs

### ✔ Example:
```
@GetMapping("/user/{id}")
public String get(@PathVariable int id) {
return "Id: " + id;
}
```

### ✔ URL:
.../user/10

----------------------------------------

## 4. @RequestPart

### ✔ Source:
Multipart/form-data

### ✔ Use:
File + text together

### ✔ Example:
```
@PostMapping("/upload")
public String upload(
    @RequestPart("file") MultipartFile file,
    @RequestPart("name") String name
) {
return name + " uploaded";
}
```

----------------------------------------

## 5. @RequestHeader

### ✔ Source:
HTTP headers

### ✔ Use:
Auth token, metadata

### ✔ Example:
```
@GetMapping("/header")
public String get(@RequestHeader("Authorization") String token) {
return token;
}
```

----------------------------------------

## 6. @CookieValue

### ✔ Source:
Cookies

### ✔ Use:
Session tracking

### ✔ Example:
```
@GetMapping("/cookie")
public String get(@CookieValue("sessionId") String id) {
return id;
}
```

----------------------------------------

## 7. @ModelAttribute

### ✔ Source:
Form data (key-value)

### ✔ Use:
Bind form → object

### ✔ Example:
```
@PostMapping("/form")
public String form(@ModelAttribute User user) {
return user.getName();
}
```

----------------------------------------

## 8. @MatrixVariable (Rare)

### ✔ Source:
Matrix URL

### ✔ Example:
@GetMapping("/cars/{id}")
public String get(@MatrixVariable int color) {
return "Color: " + color;
}

### ✔ URL:
.../cars/1;color=red

----------------------------------------

#  Quick Summary Table

| Annotation        | Data Source        | Use Case              |
|------------------|-------------------|----------------------|
| @RequestBody     | JSON body         | Object data          |
| @RequestParam    | Query params      | Simple values        |
| @PathVariable    | URL path          | REST IDs             |
| @RequestPart     | Multipart         | File upload          |
| @RequestHeader   | Headers           | Token/Auth           |
| @CookieValue     | Cookies           | Session              |
| @ModelAttribute  | Form-data         | Form binding         |
| @MatrixVariable  | Matrix URL        | Rare                 |

----------------------------------------

#  Memory Trick

- JSON → @RequestBody
- ?id=10 → @RequestParam
- /user/10 → @PathVariable
- File → @RequestPart
- Header → @RequestHeader
- Cookie → @CookieValue
- Form → @ModelAttribute

----------------------------------------

#  Most Used in Real Projects

✔ @RequestBody  
✔ @RequestParam  
✔ @PathVariable  
✔ @RequestHeader

