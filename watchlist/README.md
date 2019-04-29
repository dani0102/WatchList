# Watchlist

Watchlist is a program that allows you to access information about several tv shows and movies. <br>
If you are a member of watchlist, you can also add, change and delete tv shows as well as movies. It is basically a big data-based program. 

## Application Requirements

> Unknown Users can:
- Register a new account
- Login
- View Tv Shows (Overview as well as detailed view)
- View Movies (Overview as well as detailed view)

> Logged in Users can:
- Logout
- View / edit / delete the own profile
- View Tv Shows (Overview as well as detailed view)
- View Movies (Overview as well as detailed view)
- Add new, edit / delete existing Tv Shows
- Add new, edit / delete existing Movies

> Nice to haves:
- Pictures of Tv Shows / Movies
- Avatar-Picture
- Ratings

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

> TODO

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
| [![Daniela Simões](https://avatars1.githubusercontent.com/u/4284691?v=3&s=200)](https://github.com/test0102test)    | [![Belinda Stifani](https://avatars1.githubusercontent.com/u/4284691?v=3&s=200)](https://github.com/bemary) | [![Belinda Schühle](https://avatars1.githubusercontent.com/u/4284691?v=3&s=200)](https://github.com/Lingelingeling)  |
| <a href="https://github.com/test0102test" target="_blank">`https://github.com/test0102test`</a> | <a href="https://github.com/bemary" target="_blank">`https://github.com/bemary`</a> | <a href="https://github.com/Lingelingeling" target="_blank">`https://github.com/Lingelingeling`</a> |


## Reflexions

### Overall

Overall, we had many problems with this project. We started it as a web application but went for a JavaFX GUI in the end. This already caused us some big problems in connecting front- and backend. <br>
The projects start was almost completely without any issues. We worked on the entities in an MVC-Pattern, which worked just fine. Also testing the functions using postman, revealed no issues. 

None of us have used JavaFX so far, which made it a little more difficult but also more interesting to work with. We learned a lot new things. <br>
All of us can say, that we have some basic knowledge in working with JavaFX and SceneBuilder now.

Also, this was the first time despite our intercompany course, where we worked with PostgreSQL. It's not too different from MySQL but it was still something new we could all learn and profit from. 

#### Daniela Simões

> TODO

#### Belinda Stifani

> TODO

#### Belinda Schühle

My biggest problem was probably JavaFX. Like all of us, I have never worked with this before. In the company we used to work on an older project with Java Swing, so it had some similarities but it's still not quite the same. <br>
I have also spent a lot of time with the JUnit Tests. We worked with then before but that was a while ago, so I was a little rusty in it. In the end I have really learned a lot in this project and I could also refresh some of my forgotten knowledge. 
