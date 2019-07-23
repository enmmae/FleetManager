# FleetManager

Pretask given by Etteplan MORE in spring 2019.

Supports adding, editing and deleting a car, 
getting info of a spesific car, all of the cars, cars by model year, cars by make and cars by model.

Initializes the database with the seed-data from car.csv file.

## Built with
* [Maven](https://maven.apache.org/) - Dependency Management
* [Spring framework](https://spring.io/) - The web framework used
* [MySQL](https://www.mysql.com/) - The database used


## How to run the application

Create a fleetamanager database and a Car table. Change the info in application.properties to match the right values.
Then 
```
mvn spring-boot:run
```


## How to test the application

### PostMan sample requests

https://www.getpostman.com/collections/4610e3d6a35784d793c6

### Swagger documentation

http://localhost:8080/swagger-ui.html


## 

###### Could be done/be wise to do: tests to test folder and more time efficient version of loadFromCSV() in CarService
