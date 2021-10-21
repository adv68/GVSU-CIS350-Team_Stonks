# Install Guide

This is a guide to installing all the tools necessary to build and run the project.

## Install prerequisites

1. Install [xampp webserver package](https://www.apachefriends.org/download.html). Only Apache, PHP, and MySQL (actually MariaDB in xampp) are required to run the software.
2. Install [Java OpenJDK 16](https://jdk.java.net/archive/).
3. (Optional) Install a Java IDE. The project will be build from IntelliJ, so installing IntelliJ is recommended.

## Get software

1. Clone the git repo. You can use git clone or download a zip.

## Building and running

1. Start Apache and MySQL (MariaDB) from the xampp control panel.
2. Navigate to localhost/phpmyadmin in your browser. Create a new database called "stonks". Then import the [stonks.sql](../src/sql/stonks.sql) file to create the database tables. NOTE that the default user is test and the default password is test. This is inherently insecure because the sql file is publicly available on the internet. 
3. All of the [php files](../src/php/) have to be copied to the xampp/htdocs folder. There are default files in this folder. These can be deleted or moved.
4. Build the java project. __TODO__ Work on java project.