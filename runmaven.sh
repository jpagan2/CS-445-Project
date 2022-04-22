#!/bin/bash

# Automate Maven Set Up for "Buy Nothing RESTful API application"
# Julio Pagan

#Update Maven Enviornment Variables
sudo chmod +x /etc/profile.d/maven.sh
source /etc/profile.d/maven.sh
mvn -version

#Clean Package Run Maven Project
cd REST_server
mvn clean
mvn clean package
mvn spring-boot:run
