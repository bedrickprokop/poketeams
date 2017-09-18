# Description
Web Project Java/AngularJs to manage pokemon teams

## Requirements
Install in your computer the Maven, NodeJs, NPM and Bower.   

## Setup and Startup
#### Clone this repository 
$ git clone https://github.com/bedrickprokop/poketeams.git

#### Navigate to the root folder
$ cd poketeams

#### Run maven to install the java dependencies, execute the unit and integration tests and compile the application
$ mvn install

#### Run bower to install the client dependencies
$ bower install

#### Run the application
$ mvn spring-boot:run

## Project contents
#### Main page
Open your browser in localhost:8080/index.html to access the application.

#### H2 Database
Open your browser in localhost:8080/console and use the following credentials:

- Saved Settings: Generic H2 (Embedded)
- Setting Name: Generic H2 (Embedded)
- Driver class: org.h2.Driver
- JDBC URL: jdbc:h2:file:~/h2/poketeams;DB_CLOSE_ON_EXIT=FALSE
- User Name: root
- Password: root

#### Restful Endpoints
You can use Postman tool to perform these operations

##### Coach
- Create: POST to localhost:8080/api/coach with JSON {"name": "Coach Bedrick"}

- FindAll: GET to localhost:8080/api/coach

- FindOne: GET to localhost:8080/api/coach/ID where ID is an identification number for specific coach

- Update: PUT to localhost:8080/api/coach with JSON {"id": 1, "name": "Coach Bedrick"}

- Delete: DELETE to localhost:8080/api/coach/ID where ID is an identification number for specific coach
 
