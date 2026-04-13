# Spring Boot Dependency Injection 

## 1. Overview
This example demonstrates how Spring Boot handles object creation and dependency injection automatically.  
Instead of manually creating objects using `new`, Spring Boot creates and manages objects for you inside a container called the **Application Context**.

---

## 2. Key Concepts

### 2.1 @SpringBootApplication
- Marks the main class of the Spring Boot application.
- Enables:
    - Component scanning
    - Auto configuration
    - Bean creation and management

### 2.2 ApplicationContext
- A container that stores all Spring-managed objects (beans).
- Responsible for:
    - Creating objects
    - Managing their lifecycle
    - Providing objects when requested

### 2.3 @Component
- Marks a class as a Spring-managed component.
- Spring automatically creates an object of this class and stores it in the Application Context.

---

## 3. Code Flow Explanation

### Step 1: Application Starts
The main method starts the Spring Boot application.

### Step 2: Spring Creates Beans
Spring scans the project for classes annotated with `@Component` and creates objects for them.

### Step 3: Retrieving Bean from Container
Instead of using:

Dev obj = new Dev();

Spring provides the object:

Dev obj = context.getBean(Dev.class);

### Step 4: Using the Bean
After getting the object, you can use its methods:

obj.build();

---

## 4. Example Class Breakdown

### Main Application Class
@SpringBootApplication
public class MyAppApplication {

    public static void main(String[] args) {

        ApplicationContext context =
            SpringApplication.run(MyAppApplication.class, args);

        Dev obj = context.getBean(Dev.class);
        obj.build();
    }
}

### Component Class
@Component
public class Dev {

    public void build() {
        System.out.println("working on Awesome Project");
    }
}

---

## 5. Why This Matters
- No manual object creation
- Loose coupling between classes
- Easier testing and maintenance
- Cleaner code structure

---

## 6. Key Takeaways
- @Component tells Spring to manage the class.
- ApplicationContext stores and provides objects.
- Dependency Injection removes the need for manual object creation.
- Spring Boot automatically wires everything together.