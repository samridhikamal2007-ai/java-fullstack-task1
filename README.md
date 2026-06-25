# Java Full-Stack Internship Assignment (Task 1 & Task 2)

A production-grade, full-stack application built during the MainCrafts Technology Internship. This system bridges a modern responsive user interface with a robust Java Spring Boot backend and structured MySQL storage using Spring Data JPA.

## 🚀 Features Implemented

### Task 1: Core Landing Page & Processing Pipeline
* **Modern UI Front-end:** A high-end responsive landing page built with HTML and CSS.
* **Asynchronous Submissions:** Connects the contact form via JavaScript asynchronous `fetch()` network pipelines.
* **Enterprise-Grade Logging:** Captured payload metadata is streamed to the backend application logs using the **SLF4J** logging framework instead of raw console print scripts.

### Task 2: Database Persistence & Architectural Scaling
* **Layered Architecture:** Refactored into highly decoupled tiers using standard software design patterns (DTOs, Repositories, Services, and REST Controllers).
* **Data Validation:** Integrated `@Valid` payload interceptors (`spring-boot-starter-validation`) to ensure structural consistency.
* **JPA Database Engine:** Automated schema management (`ddl-auto=update`) linked directly to a local **MySQL (XAMPP)** instance.
* **JSON API Endpoint:** Created a versioned endpoint (`/api/v1/contacts`) to query and render stored entries in a clean JSON matrix.

---

## 📂 Project Structure
```text
internship/
├── src/
│   ├── main/
│   │   ├── java/com/maincrafts/internship/
│   │   │   ├── InternshipApplication.java  # Main Application Entry Point
│   │   │   ├── Contact.java                # Database Hibernate Entity
│   │   │   ├── ContactDTO.java             # Incoming Data Transfer Object
│   │   │   ├── ContactRepository.java      # Data Access Layer (JPA Interface)
│   │   │   ├── ContactService.java         # Core Service Interface
│   │   │   ├── ContactServiceImpl.java     # Business Logic Implementation
│   │   │   └── ContactController.java      # REST Endpoints (Submit/Get)
│   │   └── resources/
│   │       ├── static/
│   │       │   └── index.html              # Core Modern Frontend UI
│   │       └── application.properties      # MySQL Database Engine Profiles
├── pom.xml                                 # Build Dependencies & Properties
└── README.md                               # Project Documentation

```

---

## 🛠️ Tech Stack & Requirements

* **Java:** JDK 17 or higher
* **Framework:** Spring Boot 3.x
* **Persistence:** Spring Data JPA / Hibernate
* **Database:** MySQL Server (via XAMPP Control Panel)
* **Frontend:** HTML5, CSS3, Modern JavaScript (ES6 Fetch API)

---

## ⚡ How to Set Up and Run Locally

1. **Initialize the Database:**
* Open your **XAMPP Control Panel**.
* Click **Start** for both **Apache** and **MySQL**.


2. **Verify Backend Configuration:**
* Ensure your `application.properties` database credentials point correctly to your MySQL server:


```properties
spring.datasource.url=jdbc:mysql://localhost:3306/maincrafts_db?createDatabaseIfNotExist=true
spring.datasource.username=root
spring.datasource.password=

```


3. **Boot the Application:**
* Open your terminal in VS Code and execute:


```bash
./mvnw spring-boot:run

```


4. **Access the Project:**
* **Frontend Interface:** Right-click `src/main/resources/static/index.html` and choose **Open with Live Server**.
* **Live REST JSON Data:** Open your web browser and target `http://localhost:8080/api/v1/contacts
