#!/bin/sh

# https://stackoverflow.com/questions/5916157/how-to-get-the-maven-local-repo-location
mvn_local_repository=$(mvn help:evaluate -Dexpression=settings.localRepository -q -DforceStdout)

# Compiling tests to ./bin folder
javac -d bin -cp .:"${mvn_local_repository}"/junit/junit/4.13.1/junit-4.13.1.jar\
:"${mvn_local_repository}"/org/hamcrest/hamcrest-core/1.3/hamcrest-core-1.3.jar\
:"${mvn_local_repository}"/org/json/json/20220924/json-20220924.jar\
:"${mvn_local_repository}"/io/github/cdimascio/dotenv-java/3.0.0/dotenv-java-3.0.0.jar\
:./src src/test/TestSuites.java

# Launch compiled tests
java -cp .:"${mvn_local_repository}"/junit/junit/4.13.1/junit-4.13.1.jar\
:"${mvn_local_repository}"/org/hamcrest/hamcrest-core/1.3/hamcrest-core-1.3.jar\
:"${mvn_local_repository}"/org/json/json/20220924/json-20220924.jar\
:"${mvn_local_repository}"/io/github/cdimascio/dotenv-java/3.0.0/dotenv-java-3.0.0.jar\
:./bin org.junit.runner.JUnitCore test.TestSuites