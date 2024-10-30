
--liquibase formatted sql
--changeset AlkotaimJa:1 failOnError=false
-- Create car table
CREATE TABLE car (
    id INT AUTO_INCREMENT PRIMARY KEY,
    vin VARCHAR(25) NOT NULL,
    maker VARCHAR(25) NOT NULL,
    model VARCHAR(25) NOT NULL,
    model_year INT NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    car_showroom_id INT NOT NULL,
    FOREIGN KEY (car_showroom_id) REFERENCES car_showroom(id)
);