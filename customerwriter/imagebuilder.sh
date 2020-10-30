#!/bin/bash

docker pull mysql:8.0

docker pull redis:3.2.11

mvn clean package -DskipTests

docker build -t testtask/customerwriter .