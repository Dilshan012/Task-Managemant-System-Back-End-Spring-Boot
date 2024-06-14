# Task-Managemant-System-Spring-Boot-Back-End
 
 ## Technologies Used
  - Spring Boot
  - Spring Security
  - Spring Data JPA
  - JWT
  - MySQL (or H2 Database)

## Installation and Setup

## Prerequisites
- Java 11 or higher
- Node.js and npm
- MySQL (if not using H2 database)

## Front-End & Back-End Setup
- Clone the repository:
   ```bash
   git clone --recurse-submodules https://github.com/Dilshan012/Task-Management-System.git

## Back-End Setup
-  Navigate to the back-end directory: cd Back-End

- Configure the database in src/main/resources/application.properties:

### For MySQL Database
#### spring.application.name=taskmanagemantsystem
#### spring.datasource.url=jdbc:mysql://localhost:3306/tasks_management
#### spring.datasource.username=root
#### spring.datasource.password= >>YourPassword<<
#### spring.jpa.hibernate.ddl-auto=update
#### spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
#### server.port=1010

- Run the Spring Boot application: ./mvnw spring-boot:run