# javabrains-microservices
Spring Boot Microservices tutorial

## Database

You can use docker container for the mysql database.
Install [Docker](https://www.docker.com/)

In a terminal paste the following commands to create and run the container:

```
docker run --name mysql-standalone -p 3307:3306 -d -e MYSQL_ROOT_PASSWORD=123 -e MYSQL_DATABASE=movies_db mysql:8.0.17

docker start mysql-standalone
```

