# PACIENT BOARD

How We Built the PatientBoard Backend API

So, here's the scoop on how we put together the PatientBoard Backend API. We got all techy and used some cool stuff to make it happen.

Database Setup: First things first, we had to figure out how to store all that patient info. We designed a database schema
that was organized and didn't have any extra junk in it. Plus, we made sure everything was connected properly using foreign
keys to keep the data in line.

Hibernate Magic: We used this fancy thing called Hibernate to talk to our database. It's like a bridge between Java and the database.
Our Java classes became buddies with the database tables, thanks to all those Hibernate annotations. This made it easy to fetch data and
send it where it needed to go.

Dealing with Errors: Let's face it, stuff can go wrong. So, we created some special error messages for when things didn't go as planned. 
These errors were like little notes that told us what went wrong and where. This way, we could fix things faster.

DTOs for Smooth Data Moves: To get data back and forth between the front-end and the back-end, we introduced something called
Data Transfer Objects (DTOs). These acted like messengers, carrying data between different parts of our app. We even made
sure the data was clean and legit before it traveled.

Spring Data JPA for Smart Queries: Spring Data JPA was our go-to for talking to the database. We made these fancy interfaces that
knew how to ask the database for the right info just by their method names. This saved us a lot of time and made our code easy to understand.

Three-Tier Architecture: Our app had different parts, and we organized them neatly. The controllers handled requests and
decided what to do with them. The services were like the brain, where all the smart decisions happened. And the repositories
were the database whisperers that knew how to talk to the database.

Docker Magic: Lastly, we needed to make sure our app could run anywhere without a hassle. So, we put everything in these
containers called Docker. The database and our app each had their own container. And with Docker Compose, we could start
them all together without any fuss.

So, that's how we built the PatientBoard Backend API - a mix of techy tools, some smart organization, and a little bit of 
magic to make it all work.

## Start Docker container with app and db running
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
   spring.datasource.url=jdbc:postgresql://localhost:2345/PacientHub //or any port your container is mapped to.
   ```

## Spring Boot container
- Docker desktop is open 
 - run dockerFile pentru a se crea imaginea
 - docker ps -a (check if the container is running)
 - docker run -d  id_imagine id_container_creat (create and start a new container from the specified image)

