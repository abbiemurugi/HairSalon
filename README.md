# Title

Hair-salon Java App


## Author

By Abigail Murugi


## Description

This is an java App containing a database with stylists and clients details where one can add or update and delete'

stylists or clients from the list.


## Installation

If you want to use this as your template, here's how to go about it:

Install Git on you machine

Maneouver to 'clone or download' button and get the link

--Linux Users-- open your terminal and run the 'git clone ...' command in a directory of your choice

--for Windows Users-- Navigate to the location you'd want the repository located, right click and select "git bash here"

Clone the repository

Upon completion, navigate to the cloned repository Feel free to edit the files to your prefered taste

Now build the Database to enable storing of created instances

Install Postgres SQL

run the following commands in your terminal

psql

CREATE DATABASE hair-salon;

CREATE TABLE Stylists (id serial PRIMARY KEY, firstname varchar, middlename  varchar, lastname  varchar, Age varchar, Address varchar);

CREATE TABLE Clients (id serial PRIMARY KEY, firstname varchar, middlename  varchar, lastname  varchar, Age varchar, Address varchar);

CREATE DATABASE hair_salon_test WITH TEMPLATE hair_salon;


### Prerequisites

 * Java JDK 8
 * Gradle


### Technologies used

   * JAVA
   * Gradle
   * Junit
   *Terminal

