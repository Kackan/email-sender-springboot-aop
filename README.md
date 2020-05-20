# system-to-manage-movie-db-with-aop

Application enables add own movie to database and display all records additionally sends email to user with confirmation that movie was added.

## Getting Started

1.Clone the repository.

2.Do prerequisites.

3.Open project in your IDE.  

4.Run the project.

### Prerequisites

If you would like to add your own movies to database you need to download Api Client (for example [Postman](https://www.postman.com/) ).


Before you start project you need to replace *** with your own google account login and password in application.properties. (I recommend to create new google account). You need to set less secure app access: Google account->Security-> Less secure app access (on).


### Operation

(GET) - in postman you need to set 'GET' request 


To get all records from database you need to paste text below to postman

```
http://localhost:8080/api/v1/movies
```
click Send.


To get one records you need to paste text below with appropriate number

```
http://localhost:8080/api/v1/movies/1
```
click Send.


(POST) - in postman you need to set 'POST' request

To add your own record to database you need to select body, in body section you need to mark raw and chose JSON. In raw section you need to create JSON object.

```
{
"title":"your title",
"yearProduction": year of production,
"email":" your email (you will get a message on this email with confirmation)"
}

```



## Built With
* [Maven](https://maven.apache.org/)
* [Spring boot](https://spring.io/projects/spring-boot) 


## Authors

* **Kackan** 
