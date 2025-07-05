# Weather-Conscious To‑Do List Application

## 📋 Project Overview

This project is a web application that allows users to manage a to‑do list (add, view, edit, delete tasks) and display real-time weather information for a selected city.

**Backend:** Java + JDBC + SQLite  
**Frontend:** HTML, CSS, JavaScript  
**Weather Data:** OpenWeatherMap API

---

## 🎓 Formation Sessions (Preparatory Learning)

Before starting development, complete the following learning sessions:

1. **Introduction to Git and Version Control**
   - Basic Git commands: init, clone, commit, push, pull
2. **Creating a GitHub Repository**
   - Setting up and connecting a remote repository
3. **Branching and Collaboration**
   - Working with branches and merging changes
4. **Introduction to Java**
   - Java syntax, structure, and OOP principles
5. **Using JDBC with SQLite**
   - Connecting Java applications to SQLite databases
6. **REST API Concepts**
   - HTTP methods and RESTful design
7. **Introduction to OpenWeatherMap API**
   - Getting an API key and making HTTP requests
8. **Basics of HTML, CSS, JavaScript**
   - Page structure, styling, and dynamic content with fetch()

---

## 🛠️ Project Tasks

### 📂 Project Initialization
- [ ] Initialize a Git repository locally
- [ ] Create a GitHub repository and push the initial project
- [ ] Define project folder structure:
  - /backend (Java sources)
  - /frontend (HTML, CSS, JS)

---

### 💾 Database Setup
- [ ] Create an SQLite database file
- [ ] Write and test SQL scripts to create a `todos` table:

      CREATE TABLE todos (
        id INTEGER PRIMARY KEY AUTOINCREMENT,
        title TEXT NOT NULL,
        done INTEGER NOT NULL DEFAULT 0
      );

---

### ⚙️ Backend Development (Java)
- [ ] Set up a Java server or servlet (e.g., using SparkJava)
- [ ] Implement REST API endpoints:
    - GET /todos – List all tasks
    - POST /todos – Add a task
    - PUT /todos/{id} – Update task
    - DELETE /todos/{id} – Remove task
- [ ] Implement GET /weather?city=... endpoint to retrieve weather data from OpenWeatherMap API
- [ ] Test all API endpoints with Postman

---

### 🌐 Frontend Development
- [ ] Create the HTML page layout:
    - Task input and list display
    - Weather search section
- [ ] Style with CSS
- [ ] Implement JavaScript to:
    - Fetch and display to-do list data
    - Add, edit, and delete tasks
    - Fetch and display current weather

---

### 🔄 Integration
- [ ] Connect frontend forms and buttons to backend API endpoints
- [ ] Make sure the data updates dynamically without reloading the page

---

### 🧪 Testing and Validation
- [ ] Test CRUD operations thoroughly
- [ ] Test weather retrieval with valid and invalid city names
- [ ] Implement error handling for edge cases

---

### 🪄 Polish and Documentation
- [ ] Improve UI styling and responsiveness
- [ ] Document setup instructions and dependencies
- [ ] Write a user guide explaining usage

---

### 🚀 Deployment and Presentation
- [ ] Deploy locally or on a simple Java web server
- [ ] Prepare a final project presentation/demo
- [ ] Create a README.md with screenshots and instructions

---

## 🌤 API Information

You need an OpenWeatherMap API key. Sign up for a free account and get your key here:
https://openweathermap.org/api

---

## 📂 Folder Structure Example

    /backend
       └── src
       └── pom.xml (if using Maven)
    /frontend
       └── index.html
       └── style.css
       └── app.js

---

## ✅ Requirements

- Java 8+
- SQLite JDBC Driver
- Git
- OpenWeatherMap API Key

---

## 📘 License

This project is provided for educational purposes.
