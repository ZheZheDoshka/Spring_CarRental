DROP TABLE users;

CREATE TABLE users (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY ,
    username VARCHAR(32) NOT NULL UNIQUE ,
    password VARCHAR(250) NOT NULL ,
    role VARCHAR(10) NOT NULL,
    ban VARCHAR(12)

);

INSERT INTO users VALUES (1, 'hellmin', '$2a$12$odumr60QQXCkeA/TOhvJZ.GHC5CZO8H4BRRlZSIzrX.0OhrfDpJwO', 'ADMIN', 'Not_banned');

