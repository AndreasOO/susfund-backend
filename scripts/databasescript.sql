
DROP SCHEMA IF EXISTS `susfund_db`;
CREATE SCHEMA IF NOT EXISTS `susfund_db`;
USE `susfund_db`;



                      
DROP TABLE IF EXISTS `organization_type`;
CREATE TABLE `organization_type` ( `id` INT NOT NULL AUTO_INCREMENT,
							   `name` VARCHAR(255) NOT NULL,
						       PRIMARY KEY (`id`)
							 ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `organization`;
CREATE TABLE `organization` ( `id` INT NOT NULL AUTO_INCREMENT,
							   `name` VARCHAR(255) NOT NULL,
                               `organization_type_id` INT NOT NULL,
                               CONSTRAINT `FK_organization_type_id` FOREIGN KEY (`organization_type_id`) REFERENCES `organization_type` (`id`),
						       PRIMARY KEY (`id`)
							 ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `case_manager`;
CREATE TABLE `case_manager` ( `id` INT NOT NULL AUTO_INCREMENT,
						`name` VARCHAR(255) NOT NULL,
						 PRIMARY KEY (`id`)
					  ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;  
                
DROP TABLE IF EXISTS `cases`;
CREATE TABLE `cases` ( `id` INT NOT NULL AUTO_INCREMENT,
						`name` VARCHAR(255) NOT NULL,
                        `organization_id` INT NOT NULL,
                        `case_manager_id` INT NOT NULL,
                        CONSTRAINT `FK_organization_id` FOREIGN KEY (`organization_id`) REFERENCES `organization` (`id`),
                        CONSTRAINT `FK_case_manager_id` FOREIGN KEY (`case_manager_id`) REFERENCES `case_manager` (`id`),
						 PRIMARY KEY (`id`)
					  ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;          
          

INSERT INTO `susfund_db`.`organization_type` (`name`) VALUES ("SOLE_TRADER");
INSERT INTO `susfund_db`.`organization_type` (`name`) VALUES ("LIMITED_COMPANY"); 
INSERT INTO `susfund_db`.`organization_type` (`name`) VALUES ("BRANCH");
INSERT INTO `susfund_db`.`organization_type` (`name`) VALUES ("TRADING_PARTNERSHIP"); 
INSERT INTO `susfund_db`.`organization_type` (`name`) VALUES ("LIMITED_PARTNERSHIP"); 


INSERT INTO `susfund_db`.`organization` (`name`, `organization_type_id`) VALUES ("CompanyOne", 1);
INSERT INTO `susfund_db`.`organization` (`name`, `organization_type_id`) VALUES ("CompanyTwo", 2);
INSERT INTO `susfund_db`.`organization` (`name`, `organization_type_id`) VALUES ("CompanyThree", 3); 
INSERT INTO `susfund_db`.`organization` (`name`, `organization_type_id`) VALUES ("CompanyFour", 4); 

-- change to case_manager 
INSERT INTO `susfund_db`.`case_manager` (`name`) VALUES ("UNASSIGNED");
INSERT INTO `susfund_db`.`case_manager` (`name`) VALUES ("Andreas Ohlander");
INSERT INTO `susfund_db`.`case_manager` (`name`) VALUES ("Josefin Törner");
INSERT INTO `susfund_db`.`case_manager` (`name`) VALUES ("Linn Edvarsson"); 
INSERT INTO `susfund_db`.`case_manager` (`name`) VALUES ("Lasse Maja");

-- add case_manager_id in values
INSERT INTO `susfund_db`.`cases` (`name`, `organization_id`, `case_manager_id`) VALUES ("Unhandled case1", 1, 1);
INSERT INTO `susfund_db`.`cases` (`name`, `organization_id`, `case_manager_id`) VALUES ("Unhandled case2", 1, 1);
INSERT INTO `susfund_db`.`cases` (`name`, `organization_id`, `case_manager_id`) VALUES ("Unhandled case3", 1, 1);
INSERT INTO `susfund_db`.`cases` (`name`, `organization_id`, `case_manager_id`) VALUES ("Funding for future", 1, 2);
INSERT INTO `susfund_db`.`cases` (`name`, `organization_id`, `case_manager_id`) VALUES ("Going green", 2, 3);
INSERT INTO `susfund_db`.`cases` (`name`, `organization_id`, `case_manager_id`) VALUES ("No more gaslighting", 3, 4); 
INSERT INTO `susfund_db`.`cases` (`name`, `organization_id`, `case_manager_id`) VALUES ("Making the change", 4, 5);

                      
                         