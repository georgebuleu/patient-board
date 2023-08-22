# PatientBoard Description
PatientBoard Backend API is a Java-based backend system meticulously crafted to empower doctors and medical staff in hospitals. 
It facilitates seamless access to vital patient information based on room numbers, treatment, surgeries, medical history, involved medical staff, and insurance details.

# 1. Database Schema Design:
Schema Blueprint: We began by meticulously designing the database schema, outlining tables, fields, and their relationships.
Normalization: Ensured data integrity through proper normalization, minimizing redundancy and improving query performance.
Foreign Key Constraints: Implemented foreign key constraints to maintain referential integrity.

# 2. Entity Mapping with Hibernate:
Entity Classes: We created Java entity classes to represent database tables, utilizing Hibernate annotations.
Mapping Configurations: Developed mapping configurations for each entity to define how they correlate with database tables.
Optimized Queries: Leveraged Hibernate's capabilities for efficient database querying.

# 3. Controller Development:
RESTful API Endpoints: Built RESTful controllers to expose API endpoints for data retrieval and manipulation.
Request-Response Handling: Implemented request and response handling logic, ensuring data integrity and validation.
Pagination and Filtering: Added features like pagination and data filtering for improved usability.

# 4. Session-Based Authentication:
Interceptor Implementation: Developed a custom interceptor to handle session-based authentication.
Security Layers: Ensured multiple security layers, including session validation and access control.
Token Management: Managed user sessions and tokens securely.

# 5. Dockerization:
Database Docker Container: 
Created a Docker container for the PostgreSQL database, enabling easy portability and consistency.
Backend Docker Container: Dockerized the backend API for simplified deployment and scaling.
Docker Compose: Orchestrated the entire environment using Docker Compose, including database initialization and backend service setup.

##Start Docker container with app and db running
Docker installed on your machine.

**1. Build docker image for the SpringBoot service**
 ```
 mvn clean install
 
 docker build -t app .  
 ```
**2. Run docker containers for service and db**
 ```
 docker-compose up -d
 ```
**3. Check if the containers are running**
 ```
 docker-compose ps
 ```
**4. Connect to the database in the container using the psql client (password is "admin"):
 ```
 docker exec -t <CONTAINER_ID> psql -U admin -W postgres
 ```
**5. To stop the containers run:
 ```
 docker-compose down
 ```

## Spring Boot container
- Docker desktop is open
- run dockerFile pentru a se crea imaginea
- docker ps -a (check if the container is running)
- docker run -d  id_imagine id_container_creat (create and start a new container from the specified image)
  =======
# Patient Hub - Postgres Container Setup


## Prerequisites

- Docker installed on your machine

## Steps

1. Pull the PostgreSQL Docker image:

    ```
    docker pull postgres:15
    ```

2. Create a Docker container for the database:

    ```
    docker run --name patient-hub-db -e POSTGRES_USER=admin -e POSTGRES_PASSWORD=admin -p 2345:5432 -d --restart=always postgres:15
    ```

   This command will create a container named "patient-hub-db", with a PostgreSQL user named "admin" and password "admin".
   The container's port 5432 will be mapped to port 2345 on your machine, and the container will run in detached mode with auto-restart enabled.

3. Check if the container is running

    ```
    docker ps -a
    ```
   You should see something like this: ![img.png](images/img.png)
4. Connect to the database using the psql client:

    ```
    psql -h localhost -p 2345 -U admin -W postgres
    ```

   This command will connect to the database running in the Docker container using the psql client you will have to enter the password which is also "admin". This is only to test if the database is running.

Note:
You will need to create
You will have to change application.properties from
   ```
   spring.datasource.url=jdbc:postgresql://localhost:5432/PacientHub
   ```
to
   ```
   spring.datasource.url=jdbc:postgresql://localhost:2345/PacientHub //op the port your container is mapped to.
   ```

## Spring Boot container
- Docker desktop is open 
 - run dockerFile pentru a se crea imaginea
 - docker ps -a (check if the container is running)
 - docker run -d  id_imagine id_container_creat (create and start a new container from the specified image)

