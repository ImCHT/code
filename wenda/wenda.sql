
CREATE TABLE `wenda`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NULL,
  `salt` VARCHAR(45) NULL,
  `headUrl` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));