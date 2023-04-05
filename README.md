# accounts
Account Opening Application

Requirements
For building and running the application you need:

JDK 17
Gradle 7.4.2
Running the application locally
There are several ways to run the 
Account application on your local machine. Kindly follow any of the
steps below:
1). One way is to execute the main method in the
com.rova.account.AccountsApplication class from your IDE.

2). Another way is to use Spring Boot gradle plugin like so:

gradle bootRun

3). If you have docker installed on your local system then you can 
change directory[cd] to the root folder and run the following
command : 
docker build -t accounts-app . 

docker run accounts-app

4). Find access to the swagger page using this link :

http://localhost:8020/swagger-ui/index.html

5). The application uses the embedded h2 database so you do not need 
any external database configuration

6). On application startup 4 customers have been created with ID ranging 
from 1 - 4. Use this customer id to test.

