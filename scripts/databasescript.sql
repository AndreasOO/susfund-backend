
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
                      

DROP TABLE IF EXISTS `case_status`;
CREATE TABLE `case_status` ( `id` INT NOT NULL AUTO_INCREMENT,
						`name` VARCHAR(255) NOT NULL,
						 PRIMARY KEY (`id`)
					  ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;    
                      
DROP TABLE IF EXISTS `case_decision_type`;
CREATE TABLE `case_decision_type` ( `id` INT NOT NULL AUTO_INCREMENT,
						`name` VARCHAR(255) NOT NULL,
						 PRIMARY KEY (`id`)
					  ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;                        
                
DROP TABLE IF EXISTS `cases`;
CREATE TABLE `cases` ( `id` INT NOT NULL AUTO_INCREMENT,
						`name` VARCHAR(255) NOT NULL,
                        `organization_id` INT NOT NULL,
                        `case_manager_id` INT NOT NULL,
                        `case_status_id` INT NOT NULL,
                        `case_decision_type_id` INT NOT NULL,
                        CONSTRAINT `FK_organization_id` FOREIGN KEY (`organization_id`) REFERENCES `organization` (`id`),
                        CONSTRAINT `FK_case_manager_id` FOREIGN KEY (`case_manager_id`) REFERENCES `case_manager` (`id`),
                        CONSTRAINT `FK_case_status_id` FOREIGN KEY (`case_status_id`) REFERENCES `case_status` (`id`),
                        CONSTRAINT `FK_case_decision_type_id` FOREIGN KEY (`case_decision_type_id`) REFERENCES `case_decision_type` (`id`),
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


INSERT INTO `susfund_db`.`case_manager` (`name`) VALUES ("UNASSIGNED");
INSERT INTO `susfund_db`.`case_manager` (`name`) VALUES ("Andreas Ohlander");
INSERT INTO `susfund_db`.`case_manager` (`name`) VALUES ("Josefin Törner");
INSERT INTO `susfund_db`.`case_manager` (`name`) VALUES ("Linn Edvarsson"); 
INSERT INTO `susfund_db`.`case_manager` (`name`) VALUES ("Lasse Maja");


INSERT INTO `susfund_db`.`case_status` (`name`) VALUES ("Unhandled");
INSERT INTO `susfund_db`.`case_status` (`name`) VALUES ("Awaiting decision");
INSERT INTO `susfund_db`.`case_status` (`name`) VALUES ("Rejected");
INSERT INTO `susfund_db`.`case_status` (`name`) VALUES ("Closed");

INSERT INTO `susfund_db`.`case_decision_type` (`name`) VALUES ("Application approval");
INSERT INTO `susfund_db`.`case_decision_type` (`name`) VALUES ("Payment request");
INSERT INTO `susfund_db`.`case_decision_type` (`name`) VALUES ("Repayment");
INSERT INTO `susfund_db`.`case_decision_type` (`name`) VALUES ("Closed");


INSERT INTO `susfund_db`.`cases` (`name`, `organization_id`, `case_manager_id`, `case_status_id`, `case_decision_type_id`) VALUES ("Going solar", 1, 1,1,1);
INSERT INTO `susfund_db`.`cases` (`name`, `organization_id`, `case_manager_id`, `case_status_id`, `case_decision_type_id`) VALUES ("I got wind", 1, 1,2,2);
INSERT INTO `susfund_db`.`cases` (`name`, `organization_id`, `case_manager_id`, `case_status_id`, `case_decision_type_id`) VALUES ("Shop locally", 1, 1,3,3);
INSERT INTO `susfund_db`.`cases` (`name`, `organization_id`, `case_manager_id`, `case_status_id`, `case_decision_type_id`) VALUES ("Funding for future", 1, 2,4,4);
INSERT INTO `susfund_db`.`cases` (`name`, `organization_id`, `case_manager_id`, `case_status_id`, `case_decision_type_id`) VALUES ("Going green", 2, 3,2,2);
INSERT INTO `susfund_db`.`cases` (`name`, `organization_id`, `case_manager_id`, `case_status_id`, `case_decision_type_id`) VALUES ("No more gaslighting", 3, 4,2,2); 
INSERT INTO `susfund_db`.`cases` (`name`, `organization_id`, `case_manager_id`, `case_status_id`, `case_decision_type_id`) VALUES ("Making the change", 4, 5,2,2);

                      
                         