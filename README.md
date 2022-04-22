# CS-445-Project

## Julio Pagan

## What is this repository for?
  - The project is setup to store the source of a Java REST API application.
  - The assumption is that this is ran on a fresh installation of Ubuntu 20.04.3

## Automation Script
For the initial set up: execute the run.sh script
```
sudo cmod 777 run.sh
./run.sh
```

## Maven Set Up

1. Set up Enviornment Variables for Maven
```
sudo vim /etc/profile.d/maven.sh
```

Once the file is open you need to append the following into it.
```
export JAVA_HOME=/lib/jvm/java-17-openjdk-amd64
export PATH=$JAVA_HOME/bin:$PATH
export M2_HOME=/opt/apache-maven-3.8.5
export MAVEN_HOME=/opt/apache-maven-3.8.5
export PATH=${M2_HOME}/bin:${PATH}
```

2. Run runmaven.sh 
```
sudo chmod 777 runmaven.sh
./runmaven.sh
```



**Instructions to access Test Coverage**
While in the CS-445-Project directory:
```
cd REST_server/target/site/jacoco/
```
Then open the <index.html> with a browser