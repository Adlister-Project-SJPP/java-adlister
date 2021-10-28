CREATE DATABASE pet_lister;

USE pet_lister;

DROP TABLE IF EXISTS users;

CREATE TABLE users(
    id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    email VARCHAR(60) NOT NULL,
    password VARCHAR(60) NOT NULL
);
DROP TABLE IF EXISTS ads;

CREATE TABLE ads(
    id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(50) NOT NULL,
    description TEXT NOT NULL,
    date DATE,
    user_id INT UNSIGNED NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(id)
);
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

