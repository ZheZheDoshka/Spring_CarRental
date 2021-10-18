DROP TABLE users;
DROP TABLE cars;
DROP TABLE brands;
DROP TABLE rentform;

CREATE TABLE users (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY ,
    username VARCHAR(32) NOT NULL UNIQUE ,
    password VARCHAR(250) NOT NULL ,
    role VARCHAR(10) NOT NULL,
    ban VARCHAR(12)

);

CREATE TABLE brands (
    brand VARCHAR(64) NOT NULL UNIQUE
);

CREATE TABLE cars (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY ,
    brand VARCHAR(64) NOT NULL ,
    class VARCHAR(2) NOT NULL ,
    model VARCHAR(250) NOT NULL ,
    price VARCHAR(64) NOT NULL ,
    status VARCHAR(24) NOT NULL

);

CREATE TABLE rentform (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY ,
    model VARCHAR(250) NOT NULL ,
    username VARCHAR(32) NOT NULL ,
    passport VARCHAR(10) NOT NULL ,
    price VARCHAR(64) NOT NULL
);

INSERT INTO users VALUES (1, 'admin1610', '$2a$12$odumr60QQXCkeA/TOhvJZ.GHC5CZO8H4BRRlZSIzrX.0OhrfDpJwO', 'ADMIN', 'PERMITTED');

INSERT INTO users VALUES (2, 'testUser', '$2a$12$odumr60QQXCkeA/TOhvJZ.GHC5CZO8H4BRRlZSIzrX.0OhrfDpJwO', 'USER', 'PERMITTED');

INSERT INTO cars VALUES (1, 'NISSAN', 'A', 'Silvia', '250.00', 'AVAILABLE')