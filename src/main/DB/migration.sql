DROP DATABASE IF EXISTS pet_lister;

CREATE DATABASE pet_lister_db;

USE pet_lister_db;

DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS ads;

CREATE TABLE users(
    id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    email VARCHAR(60) NOT NULL,
    password VARCHAR(60) NOT NULL
);


CREATE TABLE ads(
    id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(50) NOT NULL,
    description TEXT NOT NULL,
    date DATE NOT NULL,
    user_id INT UNSIGNED NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(id)
);
USE pet_lister_db;
SELECT * FROM ads;
# USE adlister_db;
# DROP TABLE ads;
# DROP TABLE IF EXISTS pet_type;
# CREATE TABLE pet_type(
#     id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
#     dog BOOLEAN,
#     cat BOOLEAN,
#     reptile BOOLEAN,
#     bird BOOLEAN,
#     fish BOOLEAN,
#     ads_id INT UNSIGNED,
#     FOREIGN KEY (ads_id) REFERENCES ads(id)
# );

