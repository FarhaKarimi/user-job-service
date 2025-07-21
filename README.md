# User-Job Service

This is a Spring Boot microservice for managing users and jobs in a real-time job recommendation system.

## Features
- Create and retrieve user information (`POST /api/users`, `GET /api/users/{userId}`)
- Create and retrieve job information (`POST /api/jobs`, `GET /api/jobs/{jobId}`)
- Record job views and send events to Event-Tracker Service (`POST /api/jobs/{jobId}/view/{userId}`)

## Prerequisites
- Java 17
- Maven
- PostgreSQL (database: `userjobdb`)

## Setup
1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/user-job-service.git
Configure PostgreSQL:
Create a database named userjobdb.
Update src/main/resources/application.yml with your PostgreSQL credentials.
Build and run:
bash

Collapse

Wrap

Run

Copy
mvn clean install
mvn spring-boot:run
The service will run on http://localhost:8081.
API Endpoints
POST /api/users: Create a new user
GET /api/users/{userId}: Get user details
POST /api/jobs: Create a new job
GET /api/jobs/{jobId}: Get job details
POST /api/jobs/{jobId}/view/{userId}: Record a job view
Dependencies
Spring Boot Web
Spring Data JPA
PostgreSQL Driver
