cd src\main\resources\mongodb\windows\mongod
If not exist "data\db" ( 
    mkdir "data"
    mkdir "data\db"
)
bin\mongod --dbpath data\db