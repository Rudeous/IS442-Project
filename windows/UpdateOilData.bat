cd ..
call mvn clean compile assembly:single 
call java -cp target/test_project-1.0.jar PopulateDB 