

# Employee Management System

## Overview
The **Employee Management System** is a robust application developed using **Spring JDBC** that enables seamless management of employee data. It provides functionalities for performing essential CRUD (Create, Read, Update, Delete) operations on employee records stored in a MySQL database. The system supports search operations, pagination for handling large datasets, and retrieval of the total number of employees in the database.

This project is designed to provide an efficient solution for managing employee information in a structured and scalable manner, using industry-standard frameworks and technologies.

## Key Features
- **CRUD Operations:** Create, update, and delete employee records.
- **Employee Search:** Search employees based on various attributes such as name, email, department, etc.
- **Pagination:** Support for paginated retrieval of employee records.
- **Total Employee Count:** Ability to retrieve the total number of employees in the database.
- **Database Interaction:** Utilizes Spring JdbcTemplate for interacting with MySQL.

## Technologies Used
- **Java** – Programming language used for the application development.
- **Spring Framework** – Specifically, Spring JDBC for database operations.
- **MySQL** – Relational database management system used for storing employee data.
- **JDBC Template** – Spring’s template class for simplifying JDBC operations.
- **RowMapper** – For mapping database rows to Java objects.

## Prerequisites
Before you can run the application, ensure the following software is installed and configured:
- **Java Development Kit (JDK)** – Version 8 or higher.
- **Maven** – For project dependency management and building the project.
- **MySQL Database** – A MySQL instance to store the employee data.
- **Spring Framework** – Dependencies managed by Maven.

## Setup Instructions

### 1. Clone the Repository:
Start by cloning the repository to your local machine:
```bash
git clone https://github.com/yourusername/EmployeeManagementSystem.git
```

### 2. Database Configuration:
- Create a MySQL database, for example `springjdbc`, or modify the existing database name in the configuration file.
- Modify the database connection details in `config.xml` located in the `resources` folder to reflect your MySQL instance.

Update the connection details in `config.xml`:
```xml
<bean id="dataSource" class="org.springframework.jdbc.datasource.DriverManagerDataSource"
      p:driverClassName="com.mysql.cj.jdbc.Driver"
      p:url="jdbc:mysql://localhost:3306/springjdbc"
      p:username="root"
      p:password="yourpassword" />
```

### 3. Build the Project:
Once the repository is cloned and the database connection is configured, use Maven to build the project:
```bash
mvn clean install
```

### 4. Run the Application:
After building the project, you can run the application from the `App.java` file:
```bash
java -cp target/EmployeeManagementSystem.jar Com.SpringJDBC1.App
```

## Functionality

### 1. **CRUD Operations:**
- **Create Employee:**
  Add a new employee record to the database.
  ```java
  Employee employee = new Employee();
  employee.setNameString("Romeo Parajuli");
  employee.setEmailString("Romeo@example.com");
  employee.setAddressString("Palpa");
  employee.setDepartmentString("HR");
  employee.setContactnumber(9876543210);
  employee.setSalary(60000);
  employee.setPostString("Manager");

  int result = dao.save(employee);
  ```

- **Update Employee:**
  Update the details of an existing employee.
  ```java
  employee.setNameString("John Smith");
  int result = dao.update(employee);
  ```

- **Delete Employee:**
  Delete an employee record by ID.
  ```java
  int result = dao.delete(4);  // Deleting employee with ID 4
  ```

- **Get Employee by ID:**
  Retrieve an employee record based on their unique ID.
  ```java
  Employee employee = dao.getEmployee(4);
  ```

### 2. **Search Employees:**
Search for employees based on a keyword (e.g., name, email, department).
```java
List<Employee> employees = dao.searchEmployees("Engineering");
```

### 3. **Pagination:**
Retrieve employees in a paginated manner (useful for large datasets).
```java
List<Employee> employees = dao.getEmployeesByPage(1, 10);  // First page, 10 employees per page
```

### 4. **Get Total Employee Count:**
Retrieve the total number of employees in the database.
```java
int totalEmployees = dao.getTotalEmployees();
```

## Project Structure

- **src/main/java**: Contains the main application code, including:
  - `App.java`: The entry point of the application.
  - `Dao` package: Contains classes for data access (e.g., `EmployeeDao`).
  - `Model` package: Contains the `Employee` class representing the employee entity.
  
- **src/main/resources**: Contains configuration files, including `config.xml` for Spring bean definitions.

- **pom.xml**: The Maven configuration file for managing dependencies.

## License
This project is licensed under the **MIT License**. See the [LICENSE](LICENSE) file for more details.

## Contribution
Contributions are welcome! If you would like to contribute, please fork the repository and submit a pull request with your changes. Ensure that you follow the coding conventions and include tests for new features or bug fixes.

## Contact
For any inquiries or feedback, feel free to open an issue or contact the repository owner.

---

