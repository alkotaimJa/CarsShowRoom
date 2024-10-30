--liquibase formatted sql
--changeset AlkotaimJa:1 failOnError=false
-- Create car_showroom table
CREATE TABLE IF NOT EXISTS car_showroom (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    commercial_registration_number VARCHAR(10) NOT NULL UNIQUE,
    manager_name VARCHAR(100),
    contact_number VARCHAR(15) NOT NULL,
    address VARCHAR(255),
    deleted BOOLEAN DEFAULT FALSE
);

