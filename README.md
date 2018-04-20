Author: **Farrukh Mirza**  
Date: 20/04/2018  
Location: Dublin, Republic of Ireland  

Purpose
========
oauth-server is a Java [Spring Boot](http://projects.spring.io/spring-boot/) based microservice.  
It acts as an embedded OAuth2 Authentication Server and exposes a REST API secured via OAUTH2 Authentication Token.
This project also shows how a service can be dockerized using com.spotify maven plugin

Licenses
=========

**oauth-server** (this service) is provided under Apache License version 2.0.
1. spring-boot and all associated libraries are provided under APACHE License v2
	

Build
======

#### Pre-requisites

	1. JDK8
	2. Maven 3
	3. Git 
	4. Docker 
	5. Ubuntu 16.04 LTS (For dockerizing only) 
	

#### Standalone Build and execute
The service can be built and executed on any operating system

This service is built to use embedded Apache Tomcat server <code>mvn clean package</code>.
This service can be executed using <code>java -jar target\oauth-server.jar</code>  
<code>build.bat</code> and <code>run.bat</code> can also be used respectively. 

The log files are created under <code>/tmp/logs/</code> inside the container.

#### Docker Build and execute
The service can be built and executed for docker container, however, that requires a linux operating system.
The dockerization is tested on Ubuntu 16.04 LTS

	1. Base Image: openjdk:8-jdk-alpine
	2. Container Volume: /tmp

Build for docker using <code>./dockerBuild.sh</code>


Run the docker container using <code>sudo docker run -e "SPRING_PROFILES_ACTIVE=DEVELOPMENT" –p 8080:8080 -v /opt/oauth-server-volume:/tmp farrukhmpk/oauth-server</code>

 - This command will run docker container with DEVELOPMENT spring profile.
 - This command will forward port 8080 on the hostmachine to port 8080 inside the container.
 - This command will map /opt/oauth-server-volume location on host machine to /tmp inside the docker container. 


REST Endpoints
===============

Endpoint Types
--------------
There are two types of endpoints.  

	1. Service Endpoints.  
	3. Management Endpoints (Spring Boot).  

#### Service Endpoints

The service can be access at <code>{PROTOCOL}://{HOST:PORT}/</code> base address.   

Generate an OAUTH token using 
<code>curl -X POST --user 'dev:devsecret' -d 'grant\_type=client\_credentials&client\_id=dev&client\_secret=devsecret' {PROTOCOL}://{HOST:PORT}/oauth/token</code>

Try the authorized server using 
<code>curl -i -H "Accept: application/json" -H "Authorization: Bearer $TOKEN" -X GET {PROTOCOL}://{HOST:PORT}/secure</code> 
where $TOKEN is replaced by the token received as a result of the first command.

The client\_id and client\_secret parameters are different for each spring profile. Please consult src/main/resources/application.yml.
This project can also be used without any spring profile, in which case, default settings will be used.

Available Spring Profiles:
 - DEVELOPMENT
 - TEST
 - PRODUCTION

#### Management Endpoints

These endpoints are provided by the spring-boot framework.  
They are generally available at <code>{PROTOCOL}://{HOST:PORT}/</code>

	1. <code>/health</code> shows general health of the application


NOTES
======

	1. Operating System must be Linux to build docker container. 
	2. Target environment is also assumed to be Linux host.
	3. Install Docker using https://docs.docker.com/install/linux/docker-ce/ubuntu/#install-docker-ce
	4. Create a docker hub account for redistribution at https://hub.docker.com
		a.	Carefully select UserID as it will be used in the build process and redistribution
		b.	Create a repository with the project build final name, as per maven	
			i.	Make sure to make it private
			ii.	If not, it will be exposed to the entire world
		c.	Change the docker hub account from farrukhmpk to what was selected above
			i. Pom.xml
			ii. dockerRun.sh (This can also be used on development and target Linux machine)
			iii. dockerPush.sh
			iv. dockerPull.sh (Only needed in target Linux machine)

