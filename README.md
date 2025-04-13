## Setup develop environment
Download Docker Desktop and follow installation and setup instructions. 

Make sure Docker is installed and works by runing ```docker version```. You should see information on both client and server. 

Download maven.

Make sure maven is installed by running ```mvn --version```

Navigate to the root folder in the project (same folder as pom.xml) and run ```mvn clean install```

Make sure you don't have any cached images in your local docker repo by running ```docker compose down --rmi all``` from the project root folder (same folder as docker-compose.yml)

To start the application run ```docker compose up -d --build``` from the root folder 
(note: sometimes the database container takes up to 45 seconds to start).

Login to localhost:4200 and verify that you can login with testuser.
