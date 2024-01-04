# Speer Backend project for Notes management System using Springboot

## How to run 
- Clone this repository : 
```
git clone https://github.com/zeel099/Speer_project/tree/main
```
- Make sure you are using JDK 1.8 and Maven 3.x
- You can build the project and run the tests by running mvn clean package
Once successfully built.

### For testing a API use postman :  
Download link : https://www.postman.com/downloads/


## List of Api :

```python
#create user
POST localhost:8080/api/auth/signup

# login user
POST localhost:8080/api/auth/login

# get user by userId
GET localhost:8080/api/user/{userId}

# create note for authenticated user
POST localhost:8080/api/notes/login/{userId}

#delete note using noteId
DELETE localhost:8080/api/notes/{noteId}

#update note using noteId
UPDATE localhost:8080/api/notes/{noteId}

#search note using keyword (used title as keyword)
GET localhost:8080/api/notes/search/{keyword}
```

## Why choose MySQL as a databse

MySQL's connectivity, speed, and security make it highly suited for accessing databases on the internet. Developers can install MySQL in minutes, and the database is easy to manage. MySQL is one of the most mature and widely used databases.

