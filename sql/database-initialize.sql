CREATE SCHEMA `m2u_interview` DEFAULT CHARACTER SET latin1 COLLATE latin1_general_ci ;

USE `m2u_interview`;

CREATE TABLE `user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(50) NOT NULL,
  `password` VARCHAR(60) NOT NULL,
  PRIMARY KEY (`id`));

INSERT INTO `m2u_interview`.`user` (`username`, `password`) VALUES ('admin', '$2a$10$2UlEoPiNE8HFSLii4zmFHeW7AzDTI.I0wXIKNIzRObPGkYQc22ehy');

CREATE TABLE `record` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `trx_datetime` DATETIME NOT NULL,
  `trx_descr` VARCHAR(1000) NOT NULL,
  `account_number` VARCHAR(100) NOT NULL,
  `trx_amount` DECIMAL(10,2) NOT NULL,
  `customerId` INT NOT NULL,
  PRIMARY KEY (`id`));

ALTER TABLE `record` 
CHANGE COLUMN `customerId` `customer_id` INT(11) NOT NULL ;

ALTER TABLE `record` 
CHANGE COLUMN `trx_amount` `trx_amount` DECIMAL(12,2) NOT NULL ;
