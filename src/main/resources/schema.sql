create database if not exist pmvcjavawebspring DEFAULT CHARACTER SET utf8  DEFAULT COLLATE utf8_general_ci;
create table if not exist user(
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL,
  `pass` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `birthday` DATE NOT NULL,
  PRIMARY KEY (`id`));