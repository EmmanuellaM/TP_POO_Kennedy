CREATE DATABASE IF NOT EXISTS TPOP;

USE TPOP;

CREATE TABLE IF NOT EXISTS Owner (
    owner_id        INT AUTO_INCREMENT PRIMARY KEY,
    owner_name      VARCHAR(30),
    owner_number    VARCHAR(30),
    owner_email    VARCHAR(30)
);

CREATE TABLE IF NOT EXISTS Object (
    object_id               INT AUTO_INCREMENT PRIMARY KEY,
    object_type             VARCHAR(30),
    object_mac_adress       VARCHAR(20),
    object_losing_date      DATETIME,
    object_losing_region    VARCHAR(20),
    object_owner_id         INT,

    FOREIGN KEY (object_owner_id) REFERENCES Owner(owner_id)
);