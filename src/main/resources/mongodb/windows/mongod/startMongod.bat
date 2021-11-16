cd src\main\resources\mongodb\windows\mongod
@REM If not exist "data\db" ( 
@REM     mkdir "data"
@REM     mkdir "data\db"
@REM )
@REM bin\mongod --dbpath data\db
brew services start mongodb-community@5.0