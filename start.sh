#!/bin/sh

# shellcheck disable=SC2164
cd src

# Compiling app to ./bin folder
javac -d ../bin -cp .:/home/dkhorkov/.m2/repository/org/json/json/20220924/json-20220924.jar:\
/home/dkhorkov/.m2/repository/io/github/cdimascio/dotenv-java/3.0.0/dotenv-java-3.0.0.jar Main.java

cd ../

java -cp .:/home/dkhorkov/.m2/repository/org/json/json/20220924/json-20220924.jar\
:/home/dkhorkov/.m2/repository/io/github/cdimascio/dotenv-java/3.0.0/dotenv-java-3.0.0.jar\
:./bin  Main
