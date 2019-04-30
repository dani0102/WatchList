# Watchlist

Watchlist is a program that allows you to access information about several tv shows and movies. <br>
If you are a member of watchlist, you can also add, change and delete tv shows as well as movies. It is basically a big data-based program. 

## Application Requirements

> Unknown Users can:
- Register a new account
- Login
- View Tv Shows (Overview)
- View Movies (Overview)

> Logged in Users can:
- Logout
- View / edit / delete the own profile
- View Tv Shows (Overview)
- View Movies (Overview)
- Add new, edit / delete existing Tv Shows
- Add new, edit / delete existing Movies

> Nice to haves:
- Pictures of Tv Shows / Movies
- Avatar-Picture
- Ratings
- Detailed Views of Movies and Tv Shows for both known and unknown users

## Getting Started

Since watchlist does not run on a server yet, no special deployement is needed. 

### Prerequisites

All you need to run our program at this point is the Java-IDE eclipse SimRel and Java 11.0.1.<br>
For editing the GUI you would need SceneBuilder aswell.

Down here is a listing of all tools we have used in this project. 

- [Eclipse SimRel](https://www.eclipse.org/downloads/)
- [Java 11](https://www.oracle.com/technetwork/java/javase/downloads/jdk11-downloads-5066655.html)
- [Gitkraken](https://www.gitkraken.com)
- [Git](https://git-scm.com/)
- [SceneBuilder](https://gluonhq.com/products/scene-builder/)
- [Gradle](https://gradle.org/)
- [Flyway](https://flywaydb.org/)
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Swagger](https://swagger.io/)
- [PgAdmin 4](https://www.pgadmin.org/)

### Installation

> Preconditions

You need to install Eclipse SimRel (Or any of the last versions of eclipse) and set the JDK to Java 11. This project will not work with any JDK under 11, Therefore JavaFX is not included. <br>
After setting eclipse up, you need to install PgAdmin, including PostgreSQL. Set the password to: 123

Now, setting up the database is neccessairy. <br>

> Database setup 

- Open PgAdmin
When you run PgAdmin, you will be redirected to a web application. Here you can see the UI of PgAdmin.
- Open the Servers-Tree
- Open PostgreSQL 10 and identify yourself with the defined password
- Create a new database called: watchlist (All in lowercase)

Now that the database is setup, we can import our project. 
<br>Therefore, you need to clone it from the remote repository. You can do that via Gitkraken and Github.

> Importing the project

Now you can start eclipse. Choose the workspace of your wish. <br>
- Open the "File" - directory
- Klick on Import
- Choose: Import existing gradle project
- Choose the directory where you have cloned this project to and klick on finish.

Now that the project is imported in eclipse, you need to wait a few moments for the project to build itself. 

> Tasks before run

Before the project can run, you need to run a few tasks. 
- Open the gradle tasks tab (somewhere near console usually)
- Klick on watchlist

Here you have several groups of tasks. First, we will run the flyway tasks. 
- Open the Flyway group
- Run: FlywayClean and wait until it is finished.
- Run: FlywayMigrate and wait until it is finished.

> Run the project

Under application you can find the task: run.
<br>You can run the project with this task. 

## Running the tests

We implemented some Unit-tests for our Controllers and Services (Web- / Service-Layers). These have run without any issues until now. 

[![Build Status](http://img.shields.io/travis/badges/badgerbadgerbadger.svg?style=flat-square)](https://travis-ci.org/badges/badgerbadgerbadger)<br>
[![Coverage Status](http://img.shields.io/coveralls/badges/badgerbadgerbadger.svg?style=flat-square)](https://coveralls.io/r/badges/badgerbadgerbadger)


## Built With

* [Spring Boot](https://spring.io/projects/spring-boot) - The web framework used
* [Gradle](https://gradle.org/) - Dependency Management / Project builds
* [Flyway](https://flywaydb.org/) - Used to generate database ressources


## Versioning

We are using [Git](https://git-scm.com/), as well as [Gitkraken](https://www.gitkraken.com/)  for versioning. <br>
Our repository lies here on github. 


## Code Documentation

Our whole project is thoroughly documented with [JavaDoc](https://docs.oracle.com/javase/8/docs/technotes/tools/windows/javadoc.html).<br>Our Endpoints also come with a [Swagger Documentation](https://swagger.io/). 


## Contributors

> Scrum Team

| <a href="https://github.com/test0102test" target="_blank">**Daniela Simões**</a> | <a href="https://github.com/bemary" target="_blank">**Belinda Stifani**</a> | <a href="https://github.com/Lingelingeling" target="_blank">**Belinda Schühle**</a> |
| :---: |:---:| :---:|
| [![Daniela Simões](https://avatars2.githubusercontent.com/u/42814758?v=3&s=200)](https://github.com/test0102test)    | [![Belinda Stifani](https://avatars0.githubusercontent.com/u/26041312?v=3&s=200)](https://github.com/bemary) | [![Belinda Schühle](https://avatars1.githubusercontent.com/u/33859776?s=400&u=f88789442721683ed0ba8d72082aeb44ff50945c&v=3&s=200)](https://github.com/Lingelingeling)  |
| <a href="https://github.com/test0102test" target="_blank">`https://github.com/test0102test`</a> | <a href="https://github.com/bemary" target="_blank">`https://github.com/bemary`</a> | <a href="https://github.com/Lingelingeling" target="_blank">`https://github.com/Lingelingeling`</a> |
