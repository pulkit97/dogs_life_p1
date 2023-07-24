DROP TABLE IF EXISTS DOGS;
DROP TABLE IF EXISTS OWNERS;

CREATE TABLE OWNERS/* creates a new table called OWNERS*/
(
 Owner_ID INT NOT NULL  AUTO_INCREMENT  PRIMARY KEY, /*Add field id that is an integer that auto increments and PK*/
 Name INT NOT NULL
);


CREATE TABLE DOGS /* creates a new table called dogs*/
(
 ID INT NOT NULL, /*Add field id that is an integer that auto increments and PK*/
 Name VARCHAR(250) NOT NULL,  /*Add field name that is a none-null string*/
 Age INT NOT NULL, /*Add field age that is a none-null integer*/
 Owner_ID INT NOT NULL, /*Add field Owner_ID that is a none-null integer*/
 FOREIGN KEY (Owner_ID) REFERENCES OWNERS(Owner_ID)
);

