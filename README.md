# TCSAssigment1

Introduction
=================================================================
This implemetation performs CRUD operations using java with springboot technology. Its meat to serve as training for whoever may be interested in using springboot for the developemtnent of REST api that performs CRUD operaton.


Technology
==================================================================
- Java 8
- Springboot
- Maven 3
- H2 In-Memory Database.
- TomCat
- Postman


SetUp
====================================================================
- Clone the codebase form the repsitory to your local environment with the following command: https://github.com/olusegun-emmanuel/SpringbootContribution1.git
- Run maven commands to clean and install the application. This is will ensude dependencied used in the application is downloded and installsed the command is: mvn clean install
- Run the application with the following command : mvnw spring-boot:run
- The application uses embeded Tomcatand its configured to run on port 8080. (Please ensure this port is available and not in use by any other applicatioln).
- WHen application is running, open Postman or any other apitesting tool installed your your machine to test the application.


APIs Sample
=====================================================================
# Create Developer
 - URL: localhost:8080/developers
 - METHOD: Post
 - BODY:  {
		"id": "1",
		"name": "Developer2",
        "email": "homa@mee.com",
		"skills": "Java,Spring Boot,REST,AWS"
	}
  
  # Get All Developers
 - URL: localhost:8080/developers/1
 - METHOD: Get
 
  # Delete Developers
 - URL: localhost:8080/developers/1
 - METHOD: Delete
 
  # Update Developer
 - URL: localhost:8080/developers/1
 - METHOD: Put
 - BODY: {
		"name": " Developer4"
}
