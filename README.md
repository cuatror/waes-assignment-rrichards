# waes-assignment-rrichards
Repository for the WAES assignment

## Author
* Rafael Richards

# Objetive

Show your coding skills and what you value in software engineering. We value new ideas so next to the original requirement feel free to improve/add/extend. 

# The Assignment

* Provide 2 http endpoints that accepts JSON base64 encoded binary data on both endpoints 
    o <host>/v1/diff/<ID>/left and <host>/v1/diff/<ID>/right 
* The provided data needs to be diff-ed and the results shall be available on a third end point 
    o <host>/v1/diff/<ID> 
* The results shall provide the following info in JSON format 
    o If equal return that 
    o If not of equal size just return that 
    o If of same size provide insight in where the diffs are, actual diffs are not needed. 
      ▪ So mainly offsets + length in the data 
• Make assumptions in the implementation explicit, choices are good but need to be communicated 


## Tech Used
* Java 8
* SpringBoot
* H2 Database

## Structure
* com.waes.assignment.rrichards.controllers
* com.waes.assignment.rrichards.entities
* com.waes.assignment.rrichards.enums
* com.waes.assignment.rrichards.exceptions
* com.waes.assignment.rrichards.repository
* com.waes.assignment.rrichards.service

## Tests

*  Run tests: mvn clean test
*  Compile: mvn clean compile
*  Local install: mvn clean install

## Endpoints
*  GET http://localhost:8080/v1/diff
*  PUT http://localhost:8080/v1/diff/ID/left
*  PUT http://localhost:8080/v1/diff/ID/right

* Post Data: 

* Json: {"data": "aGVsbG86d29ybGQ="}
* Json: {"data": "aGVsbG86d34xbGA="}
* Json: {"data": "aGVsbG86d34xbty982b="}


### Improvements

1. Use Swagger to improve the user experience
2. Implement a validator for the base64 encoded binary data
3. More specific Exceptions can be created
