DROP TABLE IF EXISTS user;
  
CREATE TABLE user (
    id INTEGER NOT NULL,
    username VARCHAR(250) NOT NULL,
    email VARCHAR(250),
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS product;
  
CREATE TABLE product (
  barcode VARCHAR(6),
  name VARCHAR(250) NOT NULL,
  description VARCHAR(250),
  price FLOAT  NOT NULL,
  userID INT,
  PRIMARY KEY(barcode)
);

DROP TABLE IF EXISTS rates;
  
CREATE TABLE rates (
pBarcode VARCHAR(6), 
rate FLOAT
);