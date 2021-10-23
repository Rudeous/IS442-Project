# Energy-Trading-Data-Application

Implements an application to scrape for and process oil trading data using OOP

## Setup 

Maven installation: https://maven.apache.org/install.html



## Usage


### Unit testing (test individual methods, classes): 
1. add dependencies and plugins (added)
https://mkyong.com/maven/how-to-run-unit-test-with-maven/
https://www.petrikainulainen.net/programming/testing/junit-5-tutorial-running-unit-tests-with-maven/
2. write desired test class with test methods in ```src/test/java```:
   - import org.junit.jupiter.api.Test;
   - class name must end in "Test", "Tests" or "TestCase"
   - annotate method(s) to be tested with ```@Test```
3. add resources needed to ```src/test/resources``` if required

### To run all test classes:
```mvn clean test```

### To run a single desired test class:
```mvn test -Dtest=<TestClass>#<testMethod> test```


### create executable jar containing dependencies 
1. configure groupid, artifactid, version in pom.xml
2. run ```mvn clean compile assembly:single```
3. run jar file generated in ```target```
