# 🔹 What is ResponseEntity?

ResponseEntity is a class in Spring Boot used to **send full HTTP response** from backend to frontend.

👉 It gives control over:
- Body (data you send)
- Status Code (200, 404, 201, etc.)
- Headers (optional)

---

## 🔹 Simple Definition

ResponseEntity = Body + Status + Headers

---

## 🔹 Why we use it?

- To send proper API responses
- To handle success & error cases
- To return different status codes
- To build professional REST APIs

---

# 🔹 Basic Syntax

return new ResponseEntity<>(body, status);

---

# 🔹 Example

return new ResponseEntity<>("Created", HttpStatus.CREATED);

### Explanation:
- Body → "Created"
- Status → 201 CREATED

---

# 🔹 More Examples

###  1. Success Response

return new ResponseEntity<>("Success", HttpStatus.OK);

---

###  2. Return Object

User user = new User(1, "Raj");  
return new ResponseEntity<>(user, HttpStatus.OK);

---

###  3. Not Found

return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);

---

###  4. No Content

return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);

---

# 🔹 Better (Modern Way)

return ResponseEntity.status(HttpStatus.CREATED)
.body("Created");

---

# 🔹 Some Important Status Codes

- 200 → OK (Request successful)
- 201 → CREATED (Resource created)
- 204 → NO CONTENT (Success but no data)
- 400 → BAD REQUEST (Wrong input)
- 401 → UNAUTHORIZED (Login required)
- 403 → FORBIDDEN (No permission)
- 404 → NOT FOUND (Resource not found)
- 500 → INTERNAL SERVER ERROR (Server error)

---

# 🔹 Quick Summary

👉 ResponseEntity = full control of response  
👉 Used in REST APIs  
👉 Helps in sending proper status + data  