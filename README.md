# Quiz Application

Quiz application created to start practicing JSF

## Used libraries

- Apache Tomee 8.0.6
- Java 1.8
- Java EE 8 API 

## How it works

It uses the conventional JSF tecnology to create the application. All the actions are server side rendered. 
When someone click on a button, it sends a server action that goes to the server, find the session scoped bean and execute some logic, returning a new xhtml page with updated values.

We have one and only managed bean: Game. This holds all the application logic and ViewState.

## How to run it

Just package the application using maven:

```sh
$ mvn package
```

After packaging, just copy the war to the `webapp` folder on tomcat and you are good to go:

```sh
$ cp ./target/*.war /tomcat/path/webapp/quiz.war
```

Execute tomcat and the application will be ready on `/quiz` context path.
