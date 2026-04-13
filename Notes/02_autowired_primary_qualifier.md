# Spring Boot – Autowired, Types of Injection, @Primary and @Qualifier (Complete Notes)

## 1. What is @Autowired?

@Autowired is used in Spring to automatically inject dependencies (objects) into another class.

Instead of creating objects manually using `new`, Spring:
- Creates objects (beans)
- Manages their lifecycle
- Injects them wherever needed

### Why use @Autowired?
- Removes manual object creation
- Reduces tight coupling
- Cleaner code
- Easier testing

---

## 2. Basic Example of @Autowired

Dependency class:

@Component
public class Laptop {
public void compile() {
System.out.println("Compiling code...");
}
}

Class using the dependency:

@Component
public class Dev {

    @Autowired
    private Laptop laptop;

    public void build() {
        laptop.compile();
    }
}

How it works:
1. Spring scans for @Component classes.
2. Creates Laptop and Dev objects.
3. Injects the Laptop object into Dev.

---

## 3. Types of Dependency Injection

### 3.1 Field Injection

@Component
public class Dev {

    @Autowired
    private Laptop laptop;
}

Pros:
- Simple and easy

Cons:
- Harder to test
- Uses reflection internally
- Not ideal for large projects

---

### 3.2 Constructor Injection (Recommended)

@Component
public class Dev {

    private final Laptop laptop;

    @Autowired
    public Dev(Laptop laptop) {
        this.laptop = laptop;
    }
}

Pros:
- Best practice
- Clear dependencies
- Easy testing
- Immutable dependencies

---

### 3.3 Setter Injection

@Component
public class Dev {

    private Laptop laptop;

    @Autowired
    public void setLaptop(Laptop laptop) {
        this.laptop = laptop;
    }
}

Use when:
- Dependency is optional
- Dependency may change

---

## 4. How @Autowired Works Internally

1. Spring scans for classes annotated with:
    - @Component
    - @Service
    - @Repository
    - @Controller

2. Spring creates objects (beans) and stores them in Application Context.

3. When @Autowired is found, Spring injects the required bean.

---

## 5. Problem: Multiple Beans of Same Type

@Component
public class HP implements Laptop {}

@Component
public class Dell implements Laptop {}

Spring will not know which one to inject.

---

## 6. Solution 1: @Primary

@Component
@Primary
public class HP implements Laptop {}

This makes HP the default implementation.

---

## 7. Solution 2: @Qualifier

@Component
public class Dev {

    @Autowired
    @Qualifier("dell")
    private Laptop laptop;
}

Rules:
- Bean name is usually class name with lowercase first letter
    - Dell → "dell"
    - HP → "hp"

---

## 8. @Primary vs @Qualifier

@Primary:
- Sets default bean
- Used when one implementation should be default

@Qualifier:
- Selects specific bean
- Used when multiple implementations exist

---

## 9. Common Mistakes

- Forgetting @Component (bean not created)
- Using @Autowired on non-bean classes
- Multiple beans without @Primary or @Qualifier

---

## 10. Best Practices

- Prefer Constructor Injection
- Use @Primary for default implementation
- Use @Qualifier for specific implementation
- Avoid Field Injection in large projects

---

## 11. Key Takeaways

- @Autowired enables automatic dependency injection.
- Spring creates and manages beans automatically.
- Three types of injection: Field, Constructor, Setter.
- Use @Primary for default bean.
- Use @Qualifier to select specific bean.