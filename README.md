<h1>
Hospital App (Spring Security)</h1>
<hr>
<br>

In this project I'm going to put the light on Spring Security types : <br>
<h6>1) InMemoryAuthentication</h6>
<h6>2) JDBC Authentication</h6>
<h6>3) UserDetailsService Authentication</h6>

<hr>

## **_1) InMemoryAuthentication_**

Once we start the application we get this login page :

<h4>1- Login page</h4>
<img src="captures/Capture1.PNG" alt="">
<br>

To configure the application to use inMemoryAuthentication security, first we need to add SecurityConfig class that implement 2 methods :<br>
<br>
inMemoryUserDetailsManager method, to create new users and define their username, password and roles if it's a simple "USER" or "ADMIN" or both

The second method is securityFilterChain to configure the login page and associate each role with the request we want, also to permit http requests if it's authenticated and finally handling the access denied page



<h4>SecurityConfig.java</h4>
<img src="captures/Capture5.PNG" alt="">
<br>
<br>
So to configure the path of login and notAuthorized pages, we should a controller class to handle paths as the following :
<h4>SecurityController.java</h4>
<img src="captures/Capture6.PNG" alt="">
<br>
<br>

To customize the Login and notAuthorized page, we can make through thymeleaf enigne  or js framework such as Angular or ReactJs ...
<h4>Login.html</h4>
<img src="captures/Capture01.PNG" alt="">
<br>
<h4>notAuthorized page</h4>
<img src="captures/Capture7.PNG" alt="">
<br>
<h4>notAuthorized.html</h4>
<img src="captures/Capture07.PNG" alt="">
<br>
<hr>

## **_1) JDBC Authentication_**

To configure the application to use JDBC Authentication security, first we need to add SecurityConfig class that implement 2 methods : 
<br>
<br>
First we need to create new JdbcUserDetailsManager that takes dataSource as parameter.<br>
The dataSource needed from our **_application.properties_**
```markdown
spring.datasource.url=jdbc:mysql://localhost:3308/hospital-db?createDatabaseIfNotExist=true
spring.datasource.username=root
spring.datasource.password=
```
<br>
The Second method it's the same SecurityFilterChain from SecurityConfigInMemory.java Class
<br>
<br>

<h4>SecurityConfigJDBC.java</h4>
<img src="captures/jdbcSecurityConfig.png">
<br>
<br>

Our application.properties file that handles the datasource url, username and password it also handles jpa hibernate ddl-auto as none so spring won't generate tables again and that helps with sql init mode which mean the application will always initialize our schema.sql file once starting the application, but if we choose our hibernate ddl-auto as update it will ignore our schema.sql
<h4>application.properties</h4>

<img src="captures/jdbcAppProps.png">
<br>
<br>

Now in order to create users and authorities in our database we should create a schema.sql file in our resources package as the following

<h4>schema.sql</h4>

<img src="captures/schemaSQL.png">
<br>
<br>

The question now is, where to get these sql requests from ?<br>
First we need to go to External Libraries > Maven: org.springframework.security:spring-security-core:6.0.2 > spring-security-core:6.0.2.jar > org.springframework.security > core > userDetails > jdbc > users.ddl

<img src="captures/toGetSchema.png">
<br>
<br>

Now, the last thing is to create users and define roles.<br>

To do this, I had to create a CommandLineRunner Bean and inject JdbcUserDetailsManager into it and then create the users in condition that these users are not null 
<h4></h4>

<img src="captures/commandLineRunner.png">
<br>
<br>
So to configure the path of login and notAuthorized pages, we should a controller class to handle paths as the following :
<h4>SecurityController.java</h4>
<img src="captures/Capture6.PNG" alt="">
<br>
<br>

To customize the Login and notAuthorized page, we can make through thymeleaf enigne  or js framework such as Angular or ReactJs ...
<h4>Login.html</h4>
<img src="captures/Capture01.PNG" alt="">
<br>
<h4>notAuthorized page</h4>
<img src="captures/Capture7.PNG" alt="">
<br>
<h4>notAuthorized.html</h4>
<img src="captures/Capture07.PNG" alt="">
<br>
<br>
Once we start the application we get this login page :

<h4>1- Login page</h4>
<img src="captures/Capture1.PNG" alt="">
<br>
<br>
<hr>
