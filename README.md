# Stock-service

Simple java application which provides CRUD API for stock entity and UI based on ReactJs.

# Stack of technologies

 - Gradle as build tool
 - Spring Boot as main Framework
 - Spring Data Rest for providing REST API
 - Postgres SQL as data lake
 - Flyway for db version control
 - ReactJs as Framework for UI
 - Docker for containerizing
 - AWS CodePipeline and AWS CodeBuild as build environment (dummy kind of CI/CD) 
 
# Tests

There is no sense in unit tests for one Repository, so application has only tests for data persistence layer.
In tests h2 db is used instead of postgres db. 

# Build and Release process

Current git repository integrates with aws CodePipeline. In scope of build pipeline aws CodeBuild launches and build application.
CodeBuild steps are described in [buildspec.yml](buildspec.yml). It builds ui subproject, containerizes application, tag it with first 8 chars of hash commit and publish image to [docker hub](https://hub.docker.com/r/otodosov/stock-service/).

# How to run

Execute 
```sh 
docker-compose up
```
in the project's root directory. 
Docker will run containers with stock-service application and postgres db.
DB schema (without data) will be automatically rolled out by Flyway.
To add some initial data execute 
```sh 
mv src/main/resources/db/migration/V2__load-test-data.sql1 src/main/resources/db/migration/V2__load-test-data.sql
```
**CAUTION**: _this will cause test failures because of populating data to db_. 

Finally just open [http://localhost:8080](http://localhost:8080)  