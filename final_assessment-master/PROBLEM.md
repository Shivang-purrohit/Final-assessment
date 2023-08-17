# Objective
Complete the given Spring Boot Employee REST API, that use Spring Data JPA to interact with MySql database, by adding the missing code wherever required and submit within the alloted time.

# Complete the following as per the requirement
## Define Data Model - Employee Class  

Define the following properties in Employee Class. Properties should be private.
- id: int
- firstName: String
- department: String
- workLocation: String

Define parameterized constructor to initialize all the properties  
Define Getter and Setter for all the properties  

## Create Repository Interface  

In dao package, create EmployeeRepository interface that extends JPARepository  

## Create Service Class  

In service package, complete the EmployeeServiceImpl class by implementing the methods specified in the EmployeeService interface. These methods invokes the appropriate repository methods for interacting with the database and throws appropriate custom exceptions.   

## Create Employee Rest APIs Controller

In controller package, Complete the EmployeeController class that has the handler methods mapped to appropriate URIs for RESTful requests.  

## Create the GlobalExceptionHandler to manage the custom exceptions 
  

**Note:-** Read the instructions given as comments in the class files and add the dependencies if required.
