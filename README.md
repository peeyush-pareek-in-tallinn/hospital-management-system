# 🏥 Hospital Management System

![GitHub Repo Size](https://img.shields.io/github/repo-size/peeyush-pareek-in-tallinn/Hospital-Management-System?style=flat-square)
![GitHub Contributors](https://img.shields.io/github/contributors/peeyush-pareek-in-tallinn/Hospital-Management-System?style=flat-square)
![GitHub License](https://img.shields.io/github/license/peeyush-pareek-in-tallinn/Hospital-Management-System?style=flat-square)
![GitHub Last Commit](https://img.shields.io/github/last-commit/peeyush-pareek-in-tallinn/Hospital-Management-System?style=flat-square)

A **Spring Boot Hospital Management System** designed to simulate key healthcare operations like managing patients, doctors, and insurance records — with real‑world practices like pagination, filtering, DTOs (Data Transfer Objects), and robust exception handling.

This project is a great example of building scalable REST APIs with Spring Boot and follows best practices for layered architecture.

## 💡 Table of Contents

- 📌 [Features](#-features)  
- 🧰 [Tech Stack](#-tech-stack)  
- 🚀 [Getting Started](#-getting-started)  
  - 📥 Installation  
  - ⚙️ Configuration  
  - ▶️ Run the App  
- 📊 [API Endpoints](#-api-endpoints)  
- 🛠 Project Structure  
- 🤝 [Contributing](#-contributing)  
- 📜 [License](#-license)  
- 🙌 [Acknowledgements](#-acknowledgements)

## ⭐️ Features

- 🧑‍⚕️ **Patient Management** – Create, read, and manage patient records  
- 🩺 **Doctor Management** – Add and retrieve doctor details  
- 📅 **Insurance Records** – Issue and track patient insurance information  
- 📚 **Pagination & Filtering** – Efficient querying of large datasets  
- 📦 **DTOs & Exception Handling** – Clean API contracts and robust error management  
- 📊 **RESTful Endpoints** – Structured API responses for frontend or clients

## 🛠️ Tech Stack

| Layer | Technology |
|-------|------------|
| Backend | Java (Spring Boot) |
| Web | Spring MVC / REST |
| Data | JPA / Hibernate |
| Database | PostgreSQL |
| Build | Maven |
| Testing | JUnit / Mockito (Not implemented yet) |
| Code Quality | Lombok, DTO patterns |

## 🚀 Getting Started

### 📥 Make sure you have:

- Java 17+ (or compatible with the project’s pom.xml)
- Maven installed and configured
- A running SQL database (e.g., MySQL)

### 📥 Installation

1. **Clone the repo**
   ```bash
   git clone https://github.com/peeyush-pareek-in-tallinn/Hospital-Management-System.git
   cd Hospital-Management-System

2. Open the project in your favorite IDE (IntelliJ IDEA / Eclipse / VS Code).

### ⚙️ Configuration

Update the application properties (application.properties or application.yml) with your database credentials:

- spring.datasource.url=jdbc:mysql://localhost:3306/hospital_db
- spring.datasource.username=your_username
- spring.datasource.password=your_password

- spring.jpa.hibernate.ddl-auto=update
- spring.jpa.show-sql=true

▶️ Run the App

```
mvn clean install
mvn spring-boot:run
```

Once started, your APIs will be available at:

http://localhost:8080/api/

### 📊 API Endpoints
| Endpoint |	Method |	Description |
|----------|---------|--------------|
| /api/patients |	GET |	List all patients |
| /api/patients/{id} |	GET |	Get patient by ID |
| /api/patients |	POST |	Create a new patient |
| /api/doctors |	GET |	List all doctors |
| /api/insurances |	POST |	Create insurance for patient |


### 🧱 Project Structure

```
src/
├── main/
│   ├── java/
│   │   └── com.example.hospital/
│   │       ├── controller/
│   │       ├── service/
│   │       ├── dto/
│   │       ├── model/
│   │       ├── repository/
│   │       └── exception/
│   └── resources/
│       └── application.properties
```

## 🤝 Contributing

Contributions are welcome! Here’s how you can help:

- ⭐️ Star the repo

- 🍴 Fork it

- 📝 Create a new branch

- 💡 Implement your feature

- 📣 Open a Pull Request

## 📜 License

Distributed under the MIT License. See LICENSE for more information.

## 🙌 Acknowledgements

Thanks for checking out this project! Use it as a learning resource, contribute improvements, or expand it into a full‑featured healthcare application.

---


## 🧑‍⚕️ Author

Peeyush Pareek
Aspiring Backend Java Developer
