<!-- TABLE OF CONTENTS -->
## Table of Contents

* [About the Project](#about-the-project)
* [Installation](#installation)
* [Usage](#usage)
* [Contact](#contact)




<!-- ABOUT THE PROJECT -->
## About The Project

This program is using Spring Boot & Java 1.8 which determines if two cities are connected.
Two cities are considered connected if there’s a series of roads that can be traveled from one city
to another. List of roads is available in a file. The file contains a list of city
pairs (one pair per line, comma separated), which indicates that there’s a road between those cities.

### Installation
1. Clone the repo
```sh
git clone https://github.com/ysednevgit/mcard-challenge.git
```
2. Package with maven
```sh
mvn clean package
```
3. Run
```sh
java -jar target/challenge-0.0.1-SNAPSHOT.jar
```

<!-- USAGE EXAMPLES -->
## Usage
Start the project<br>
Open the browser and enter origin and destination cities<br>
http://localhost:8080/connected?origin=Houston&destination=Austin
<br>
As a second option use Swagger UI:<br>
http://localhost:8080/swagger-ui.html
<br> Select main-controller -> call /connected method

<!-- CONTACT -->
## Contact

Yury Sednev - yury.sednev@gmail.com

