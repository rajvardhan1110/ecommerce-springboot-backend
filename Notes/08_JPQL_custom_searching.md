# JPQL + Custom Searching (Spring Data JPA)

## 🔹 What is JPQL?

JPQL = Java Persistence Query Language

✔ Works on **Entity class (not table)**
✔ Uses **object fields (not column names)**

-> SQL → table, column  
-> JPQL → Entity, fields

----------------------------------------

## 🔹 1. Basic JPQL using @Query

### ✔ Example:

@Query("SELECT u FROM User u WHERE u.name = :name")
List<User> findByName(@Param("name") String name);

-> "User" = Entity class  
-> "name" = field inside class

----------------------------------------

## 🔹 2. Find by Multiple Conditions

@Query("SELECT u FROM User u WHERE u.name = :name AND u.age = :age")
List<User> findByNameAndAge(@Param("name") String name,
@Param("age") int age);

----------------------------------------

## 🔹 3. LIKE (Search / Contains)

### ✔ Contains:
@Query("SELECT u FROM User u WHERE u.name LIKE %:keyword%")
List<User> search(@Param("keyword") String keyword);

### ✔ Starts With:
@Query("SELECT u FROM User u WHERE u.name LIKE :keyword%")
List<User> findStart(@Param("keyword") String keyword);

----------------------------------------

## 🔹 4. IN Query

@Query("SELECT u FROM User u WHERE u.id IN :ids")
List<User> findByIds(@Param("ids") List<Integer> ids);

----------------------------------------

## 🔹 5. Sorting

@Query("SELECT u FROM User u ORDER BY u.name ASC")
List<User> findAllSorted();

----------------------------------------

## 🔹 6. Update Query

@Modifying
@Query("UPDATE User u SET u.name = :name WHERE u.id = :id")
int updateUser(@Param("id") int id,
@Param("name") String name);

-> Must use:
@Transactional

----------------------------------------

## 🔹 7. Delete Query

@Modifying
@Query("DELETE FROM User u WHERE u.id = :id")
int deleteUser(@Param("id") int id);

----------------------------------------

## 🔹 8. Native Query (SQL instead of JPQL)

@Query(value = "SELECT * FROM users WHERE name = :name",
nativeQuery = true)
List<User> findNative(@Param("name") String name);

----------------------------------------

## 🔹 9. Dynamic Search (Optional Params)

@Query("""
SELECT u FROM User u
WHERE (:name IS NULL OR u.name = :name)
AND (:age IS NULL OR u.age = :age)
""")
List<User> searchDynamic(@Param("name") String name,
@Param("age") Integer age);

----------------------------------------

#  Derived Query (No @Query)

Spring can auto-create query from method name:

List<User> findByName(String name);

List<User> findByNameAndAge(String name, int age);

List<User> findByNameContaining(String keyword);

List<User> findByAgeGreaterThan(int age);

----------------------------------------

#  Important Points

✔ JPQL uses Entity name, not table name  
✔ Use @Param to bind values  
✔ @Modifying needed for update/delete  
✔ @Transactional required for update/delete  
✔ nativeQuery = true → SQL query



----------------------------------------

# Example Repository

public interface UserRepo extends JpaRepository<User, Integer> {

    @Query("SELECT u FROM User u WHERE u.name = :name")
    List<User> findByName(@Param("name") String name);

}