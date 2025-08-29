# 📚 Book API (Spring Boot)

A simple RESTful API for managing books, built with **Spring Boot, JPA, and H2 Database**.

## Features
- Create, Read, Update, Delete (CRUD) books
- DTO pattern for clean APIs
- Global Exception Handling
- Ready for deployment

## Run Locally
```bash
git clone https://github.com/your-username/book-api.git
cd book-api
mvn spring-boot:run
API runs at: http://localhost:8080
```

## API Endpoints
-GET /books → get all books
-GET /books/{id} → get book by id
-POST /books → add new book
-PUT /books/{id} → update book
-DELETE /books/{id} → delete book
