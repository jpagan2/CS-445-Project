#!/bin/bash

# Script to build and run "Buy Nothing RESTful API"


#Install openjdk-17-jdk
sudo apt update -y
sudo apt install openjdk-17-jdk -y
java --version

#Install Maven
wget https://dlcdn.apache.org/maven/maven-3/3.8.5/binaries/apache-maven-3.8.5-bin.tar.gz -P /tmp
sudo tar xf /tmp/apache-maven-*.tar.gz -C /opt
sudo ln -s /opt/apache-maven-3.8.5 /opt/maven

#Install Vim
sudo apt-get install vim -y

#Install Postman
sudo snap install postman