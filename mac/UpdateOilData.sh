cd ..
mvn clean compile assembly:single 
java -cp target/test_project-1.0.jar PopulateDB 