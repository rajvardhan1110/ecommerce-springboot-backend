# Servlet, Tomcat, and Servlet Container (Simple Notes)

## 1. What is a Servlet?

A Servlet is a Java program that runs on a server and handles HTTP requests and responses.

Simple meaning:
- It receives request from browser
- Processes it
- Sends response back

Example flow:
Browser → Servlet → Response

Key points:
- Written in Java
- Handles GET, POST requests
- Runs on server
- Cannot run alone (needs a container)

---

## 2. What is Tomcat?

Tomcat is a web server and servlet container.

Simple meaning:
- It runs your Java web applications
- It executes Servlets

Key points:
- Receives request from browser
- Sends request to Servlet
- Sends response back to browser
- Example: Apache Tomcat

---

## 3. What is a Servlet Container?

A Servlet Container is a system that manages Servlets.

Simple meaning:
- It creates, runs, and destroys Servlets
- It handles communication between browser and servlet

Responsibilities:
- Lifecycle management of servlets
- Request and response handling
- Security and threading

---

## 4. Relationship Between Them

- Servlet = Logic (Java code)
- Servlet Container = Manager of Servlets
- Tomcat = Software that provides Servlet Container

Flow:
Browser → Tomcat (Servlet Container) → Servlet → Response → Browser

---

## 5. Simple Analogy

- Servlet = Worker
- Servlet Container = Manager
- Tomcat = Factory

---

## 6. In Spring Boot

- You don’t create Servlets manually
- Spring Boot uses an embedded Tomcat
- Your controllers work like servlets internally

---

## 7. Key Summary

- Servlet handles request and response
- Servlet Container manages servlets
- Tomcat runs the servlet container