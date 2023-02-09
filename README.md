# SpringBootTest

Author: Robson Harrison

Description: Project created during QA SpringBoot training to test MYSQL connectivity with assosciated 'GET, POST, DELETE' requests. 

Database information:

CREATE DATABASE messageBoard_Database;
USE messageBoard_Database;
GRANT ALL ON messageBoard_Database.* TO root@'localhost';

CREATE TABLE quotes (
    -> quoteID int NOT NULL AUTO_INCREMENT,
    -> quote_string varchar(255), 
    -> PRIMARY KEY (quoteID)
    -> );

describe quotes;

+--------------+--------------+------+-----+---------+----------------+
| Field        | Type         | Null | Key | Default | Extra          |
+--------------+--------------+------+-----+---------+----------------+
| quoteID      | int          | NO   | PRI | NULL    | auto_increment |
| quote_string | varchar(255) | YES  |     | NULL    |                |
+--------------+--------------+------+-----+---------+----------------+

