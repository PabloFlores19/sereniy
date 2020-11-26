# Serenity JUnit Starter project


This is the simplest possible build script setup for Serenity BDD using Java. 

This is a very minimal sample project using JUnit and Serenity BDD in Java. 
You can use this project as a quick starting point for your own projects.

## Get the code

Git:

    git clone https://github.com/kloDerek/sereniy.git

    cd serenity-junit-starter


Or simply [download a zip](https://github.com/kloDerek/sereniy.zip) file.

## Use Maven

Open a command window and run:

    mvn clean verify

## Use Gradle

Open a command window and run:

    gradlew starter.test 


## Viewing the reports

Both of the commands provided above will produce a Serenity starter.test report in the `target/site/serenity` directory. Go take a look!

## To create a pipeline in jenkins 

1. Install docker
2. docker --version
3. Go to DockerHub and search Jenkins (no need to sign in)
4. docker pull jenkins (in terminal)
5. Create a folder called jenkins_home in Downloads
6. Create the container:docker run --add-host="localhost:"pc ip" -p 8080:8080 -p 50000:50000 --name jenkins -d -v /path/to/Downloads/jenkins_home:/var/jenkins_home jenkins/jenkins
7. docker logs -f jenkins
8. Validate that we have java: docker exec -it bash
9. Copy admin password from console to localhost:8080 in browser
10. Install recomended plugins jenkins
11. Create User
12. Install HTML publisher: Administrar Jenkins -> Administrar plugins
13. Global tool configuration

