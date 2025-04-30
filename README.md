
# 🛡️ Spring Security - Stateless Authentication using JWT

  

Built with **Spring Boot**, with a focus on practicing **stateless authentication using JWT**. It exposes three main endpoints for **registration**, **login** and **verification of login attempts**.

  

## 🔧 Technologies Used

  

- Java 21

- Spring Boot 3

- Spring Security 6

- JWT (JSON Web Token)

- H2 Database (Database in memory)

- Maven

  

## 🚀  Running the project

  

```bash

git  clone  https://github.com/seu-usuario/spring-auth.git

cd  spring-auth

./mvnw  spring-boot:run

```

  

  
The application will be available in `http://localhost:8082`.

  

---

  

## 📬 Endpoints

  

### 🔐 POST `/api/auth/signup`

  

Register a new user..

  

#### Body JSON

```json

{
"name": "your_name",
"email": "user@example.com",
"password": "your_password"

}

```

  

---

  

### 🔐 POST `/api/auth/login`

  

Authenticates a user and returns a JWT token.

  

#### Body JSON

```json

{

"email": "user@example.com",
"password": "your_password"

}

```

  

#### Response

```json

{

"email": "user@example.com",
"token": "eyJhbGciOiJIUzI1NiJ9..."

}

```

  

---

  

### 📊 GET `/api/auth/loginAttempts`

  
Returns the login attempts of the authenticated user.

  

#### Header 

```http

Authorization: Bearer {token_returned_at_login}

```

  

#### Response

```json

[

{
"id":  1,
"email":  "user@example.com",
"status":  true,
"createdAt":  "2025-04-30T18:00:00"
},

{
"id":  2,
"email":  "user@example.com",
"status":  false,
"createdAt":  "2025-04-30T18:00:00"
}

]

```

  

---

  

## 🧪 Testing with Postman

  

1.    **Make a POST request to `/api/auth/signup` with the user's JSON body.**

2.  **Log in to `/api/auth/login` to get the JWT token.**

3.  **Copy the returned token and insert it as the value of the `Authorization` header with `Bearer` prefix when GETting to `/api/auth/loginAttempts`.**

  

---


## 📝 Files Relations Draw  
![architecture-draw](https://github.com/user-attachments/assets/2b4f31d2-03d5-4cfa-a042-6fb847860528)
~ Made using Excalidraw

---



## 🗂️ Observations

  

- Authentication is completely **stateless**, there is no session maintained by the server.

- Login attempts are stored in the H2 database and associated with the user's email.

  

---

  

## 🧑‍💻 Author

  Matheus de Sousa Almeida
