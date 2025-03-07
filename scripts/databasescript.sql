DROP USER 'casemanager'@'localhost';
DROP ROLE casemanager;
CREATE ROLE 'casemanager';
GRANT ALL ON susfund_db.* TO 'casemanager';
CREATE USER 'casemanager'@'localhost' IDENTIFIED BY 'test1234'; 
GRANT 'casemanager' TO 'casemanager'@'localhost';
SET DEFAULT ROLE ALL TO 'casemanager'@'localhost';
GRANT SUPER ON *.* TO 'casemanager'@'localhost';



DROP SCHEMA IF EXISTS `susfund_db`;
CREATE SCHEMA IF NOT EXISTS `susfund_db`;
USE `susfund_db`;

DROP TABLE IF EXISTS `cases`;
CREATE TABLE `cases` ( `id` INT NOT NULL AUTO_INCREMENT,
						`name` VARCHAR(255) NOT NULL,
						 PRIMARY KEY (`id`)
					  ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

                      
DROP TABLE IF EXISTS `organizationType`;
CREATE TABLE `organizationType` ( `id` INT NOT NULL AUTO_INCREMENT,
							   `name` VARCHAR(255) NOT NULL,
						       PRIMARY KEY (`id`)
							 ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `organization`;
CREATE TABLE `organization` ( `id` INT NOT NULL AUTO_INCREMENT,
							   `name` VARCHAR(255) NOT NULL,
                               `organizationType_id` INT NOT NULL,
                               CONSTRAINT `FK_organizationType_id` FOREIGN KEY (`organizationType_id`) REFERENCES `organizationType` (`id`),
						       PRIMARY KEY (`id`)
							 ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;
                
          
          
INSERT INTO `susfund_db`.`cases` (`name`) VALUES ("Funding for future");
INSERT INTO `susfund_db`.`cases` (`name`) VALUES ("Going green");
INSERT INTO `susfund_db`.`cases` (`name`) VALUES ("No more gaslighting"); 
INSERT INTO `susfund_db`.`cases` (`name`) VALUES ("Making the change");

INSERT INTO `susfund_db`.`organizationType` (`name`) VALUES ("SOLE_TRADER");
INSERT INTO `susfund_db`.`organizationType` (`name`) VALUES ("LIMITED_COMPANY"); 
INSERT INTO `susfund_db`.`organizationType` (`name`) VALUES ("BRANCH");
INSERT INTO `susfund_db`.`organizationType` (`name`) VALUES ("TRADING_PARTNERSHIP"); 
INSERT INTO `susfund_db`.`organizationType` (`name`) VALUES ("LIMITED_PARTNERSHIP"); 


INSERT INTO `susfund_db`.`organization` (`name`, `organizationType_id`) VALUES ("Funding for future", 1);
INSERT INTO `susfund_db`.`organization` (`name`, `organizationType_id`) VALUES ("Going green", 2);
INSERT INTO `susfund_db`.`organization` (`name`, `organizationType_id`) VALUES ("No more gaslighting", 3); 
INSERT INTO `susfund_db`.`organization` (`name`, `organizationType_id`) VALUES ("Making the change", 4); 

                      
                             