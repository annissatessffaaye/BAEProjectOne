CREATE DATABASE baeprojectonedb;
DROP TABLE IF EXISTS user CASCADE;
CREATE TABLE user (
	id INT AUTO_INCREMENT,
	firstname VARCHAR(255) NOT NULL,
	last_name VARCHAR(255) NOT NULL,
	username VARCHAR(255) UNIQUE NOT NULL,
	PRIMARY KEY (ID)
);

-----------------------------------------------------
    
use baeprojectonedb;

INSERT INTO user (firstname, last_name, username) VALUES ("Jim", "Jones", "jjones1");
INSERT INTO user (firstname, last_name, username) VALUES ("Jim", "Smith", "tsmith1");

---------------------------------------------------------

 SELECT * FROM baeprojectonedb.user;