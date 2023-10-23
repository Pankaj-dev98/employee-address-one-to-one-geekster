# employee-address-one-to-one

**Name: Pankaj Kalra, Batch: FS-11**
[GITHUB](https://github.com/Pankaj-dev98/employee-address-one-to-one-geekster)

## Frameworks and languages used
- Source code: Java 21
- Base framework: SpringBoot with inbuilt TomCat server
- Dependencies: spring-boot-starter-web, Spring data JPA, Spring-boot-dev-tools, MySQL-jdbc-driver

## Data Flow
- Project implements an MVC architecture alongside a data-access directory to interface with the database.
- Control is first passed onto the endpoint handler in the controllers.
- The calls are delegated to the service layer wherein the business logic of the CRUD application exists.
- The DAO interfaces further are instantiated with standard-JPA entity manager to save and retrieve objects from the database.

- Source code is available at: [GITHUB](https://github.com/Pankaj-dev98/employee-address-one-to-one-geekster)

- Database design: Project uses a local relational MySql database with all required fields and constraints.

## Relationships
- Employee and address have a one-to-one mapping and Employee entity is the owner of this relationship.
- Deleting an employee will delete his address but the contrary is not true.

## Project Summary
Simple CRUD application has been created and tested.


