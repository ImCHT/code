CREATE TABLE `letsdomaths`.`TableName1`( 
   `id` INT UNSIGNED NOT NULL AUTO_INCREMENT , 
   `name` VARCHAR(10) NOT NULL , 
   `password` VARCHAR(10) NOT NULL , 
   `genanswer` INT DEFAULT '0' , 
   `genright` INT DEFAULT '0' , 
   `cdanswer` INT DEFAULT '0' , 
   `cdright` INT DEFAULT '0' , 
   `matans` INT DEFAULT '0' , 
   `matright` INT DEFAULT '0' , 
   PRIMARY KEY (`id`)
 )  ENGINE=INNODB COMMENT='' ROW_FORMAT=DEFAULT CHARSET=utf8  