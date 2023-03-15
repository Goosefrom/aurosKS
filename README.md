# AurosKS test task "K-PAC in K-PAC sets"

## Subject description:
This is a Spring-based web application. It allows you to create, read, and delete data relating to K-PACs (knowledge packages) and K-PAC Sets.

This app stores data about K-PACs and K-PAC Sets in a relational database managed by MySQL.

## Functional requirements(endpoints):
- /kpacs - page where list of all K-PACs is displayed;
- /sets - page where list of all K-PAC Sets is displayed;
- /set/{id} - page where list of K-PACs attached to Set is displayed;

## Technologies:
- Java (JDK version 11)
- Spring (JDBC, MVC)
- Maven
- Database - MySQL (version 8.0.25)
- Server - Apache Tomcat (http://tomcat.apache.org/)
- IDE - IntelliJ IDEA Ultimate
- JSP
- Docker

# To launch the application, you will need:
1. Install Docker
2. Clone this project to your local machine;
3. run 
```maven
mvn clean install -DSkipTests
```
4. Go to project folder in terminal and run
``` docker
docker-compose up
```
