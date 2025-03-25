
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

DROP TABLE IF EXISTS `case_decision_result`;
CREATE TABLE `case_decision_result` ( `id` INT NOT NULL AUTO_INCREMENT,
                                      `name` VARCHAR(255) NOT NULL,
                                      PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `case_decision`;
CREATE TABLE `case_decision` ( `id` INT NOT NULL AUTO_INCREMENT,
                                `case_decision_result_id` INT NOT NULL,
                                `decision_date` DATE NOT NULL,
                                CONSTRAINT `FK_case_decision_result_id` FOREIGN KEY  (`case_decision_result_id`) REFERENCES  `case_decision_result` (`id`),
                                PRIMARY KEY (`id`)
                    ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;
                    
-- ----------------------------------------- START NEW ANDREAS

DROP TABLE IF EXISTS `assessment_section`;
CREATE TABLE `assessment_section` ( `id` INT NOT NULL AUTO_INCREMENT,
								`name` VARCHAR(255) NOT NULL,
                                PRIMARY KEY (`id`)
                    ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1; 
                    
DROP TABLE IF EXISTS `assessment_item`;
CREATE TABLE `assessment_item` ( `id` INT NOT NULL AUTO_INCREMENT,
                                `assessment_section_id` INT NOT NULL,
                                `title` VARCHAR(255) NOT NULL,
                                `preamble` VARCHAR(4000) NOT NULL,
                                `assisting_text` VARCHAR(255) NOT NULL,
                                CONSTRAINT `FK_assessment_section_id` FOREIGN KEY  (`assessment_section_id`) REFERENCES  `assessment_section` (`id`),
                                PRIMARY KEY (`id`)
                    ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;                     
                  
DROP TABLE IF EXISTS `assessment_result`;
CREATE TABLE `assessment_result` ( `id` INT NOT NULL AUTO_INCREMENT,
								`assessment_item_id` INT NOT NULL,
                                `score` INT NOT NULL,
                                `justification` VARCHAR(4000) NOT NULL,
                                CONSTRAINT `FK_assessment_item_id` FOREIGN KEY  (`assessment_item_id`) REFERENCES  `assessment_item` (`id`),
                                PRIMARY KEY (`id`)
                    ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;                     				
                  
DROP TABLE IF EXISTS `case_assessment`;
CREATE TABLE `case_assessment` ( `id` INT NOT NULL AUTO_INCREMENT,
                                PRIMARY KEY (`id`)
                    ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;   


DROP TABLE IF EXISTS `case_assessment_assessment_section`;
CREATE TABLE `case_assessment_assessment_section` ( 
								 `assessment_section_id` INT NOT NULL, 
                                 `case_assessment_id` INT NOT NULL, 
								 UNIQUE `case_assessment_assessment_section_index`(`assessment_section_id`, `case_assessment_id`)
                    ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;   
                     
-- -----------------------------------------END NEW ANDREAS
                -- TODO ADD CASE ASSESSMENT ID TO CASE COLUMNS
                
                
DROP TABLE IF EXISTS `cases`;
CREATE TABLE `cases` ( `id` INT NOT NULL AUTO_INCREMENT,
						`name` VARCHAR(255) NOT NULL,
                        `organization_id` INT NOT NULL,
                        `case_manager_id` INT NOT NULL,
                        `case_status_id` INT NOT NULL,
                        `case_decision_type_id` INT NOT NULL,
                        `case_decision_id` INT,
                        CONSTRAINT `FK_organization_id` FOREIGN KEY (`organization_id`) REFERENCES `organization` (`id`),
                        CONSTRAINT `FK_case_manager_id` FOREIGN KEY (`case_manager_id`) REFERENCES `case_manager` (`id`),
                        CONSTRAINT `FK_case_status_id` FOREIGN KEY (`case_status_id`) REFERENCES `case_status` (`id`),
                        CONSTRAINT `FK_case_decision_type_id` FOREIGN KEY (`case_decision_type_id`) REFERENCES `case_decision_type` (`id`),
                        CONSTRAINT `FK_case_decision_id` FOREIGN KEY (`case_decision_id`) REFERENCES `case_decision` (`id`),
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
INSERT INTO `susfund_db`.`case_status` (`name`) VALUES ("Paused");
INSERT INTO `susfund_db`.`case_status` (`name`) VALUES ("Closed");

INSERT INTO `susfund_db`.`case_decision_type` (`name`) VALUES ("Application approval");
INSERT INTO `susfund_db`.`case_decision_type` (`name`) VALUES ("Payment request");
INSERT INTO `susfund_db`.`case_decision_type` (`name`) VALUES ("Repayment");
INSERT INTO `susfund_db`.`case_decision_type` (`name`) VALUES ("Closing");

INSERT INTO `susfund_db`.`case_decision_result` (`name`) VALUES ("Approved");
INSERT INTO `susfund_db`.`case_decision_result` (`name`) VALUES ("Rejected");
INSERT INTO `susfund_db`.`case_decision_result` (`name`) VALUES ("Partially approved");

INSERT INTO `susfund_db`.`case_decision` (`case_decision_result_id`, `decision_date`) VALUES (1, "2025-03-23");
INSERT INTO `susfund_db`.`case_decision` (`case_decision_result_id`, `decision_date`) VALUES (2, "2025-02-14");
INSERT INTO `susfund_db`.`case_decision` (`case_decision_result_id`, `decision_date`) VALUES (3, "2025-03-10");
INSERT INTO `susfund_db`.`case_decision` (`case_decision_result_id`, `decision_date`) VALUES (1, "2025-03-20");

-- NEW ANDREAS
INSERT INTO `susfund_db`.`assessment_section` (`name`) VALUES ("Economic feasibility");
INSERT INTO `susfund_db`.`assessment_section` (`name`) VALUES ("Regional Growth");
INSERT INTO `susfund_db`.`assessment_section` (`name`) VALUES ("Company");
INSERT INTO `susfund_db`.`assessment_section` (`name`) VALUES ("Sustainability");

INSERT INTO `susfund_db`.`assessment_item` (`assessment_section_id`, `title`, `preamble`, `assisting_text`) VALUES (1, "Economic feasibility title", "Economic feasibility preamble", "Economic feasibility assisting text" );
INSERT INTO `susfund_db`.`assessment_item` (`assessment_section_id`, `title`, `preamble`, `assisting_text`) VALUES (1, "Regional Growth title", "Regional Growth preamble", "Regional Growth assisting text" );
INSERT INTO `susfund_db`.`assessment_item` (`assessment_section_id`, `title`, `preamble`, `assisting_text`) VALUES (1, "Economic feasibility title", "Economic feasibility preamble", "Economic feasibility assisting text" );
INSERT INTO `susfund_db`.`assessment_item` (`assessment_section_id`, `title`, `preamble`, `assisting_text`) VALUES (1, "Economic feasibility title", "Economic feasibility preamble", "Economic feasibility assisting text" );
-- TODO INSERT THE REST
-- END NEW ANDREAS

-- TODO INSERT ASSESSMENT ID TO CASE
INSERT INTO `susfund_db`.`cases` (`name`, `organization_id`, `case_manager_id`, `case_status_id`, `case_decision_type_id`, `case_decision_id`) VALUES ("Going solar", 1, 1,1,1, 1);
INSERT INTO `susfund_db`.`cases` (`name`, `organization_id`, `case_manager_id`, `case_status_id`, `case_decision_type_id`, `case_decision_id`) VALUES ("I got wind", 1, 1,2,2, 2);
INSERT INTO `susfund_db`.`cases` (`name`, `organization_id`, `case_manager_id`, `case_status_id`, `case_decision_type_id`, `case_decision_id`) VALUES ("Shop locally", 1, 1,3,3, 3);
INSERT INTO `susfund_db`.`cases` (`name`, `organization_id`, `case_manager_id`, `case_status_id`, `case_decision_type_id`, `case_decision_id`) VALUES ("Funding for future", 1, 2,4,4, 4);
INSERT INTO `susfund_db`.`cases` (`name`, `organization_id`, `case_manager_id`, `case_status_id`, `case_decision_type_id`, `case_decision_id`) VALUES ("Going green", 2, 3,2,2, null);
INSERT INTO `susfund_db`.`cases` (`name`, `organization_id`, `case_manager_id`, `case_status_id`, `case_decision_type_id`, `case_decision_id`) VALUES ("No more gaslighting", 3, 4,2,2, null);
INSERT INTO `susfund_db`.`cases` (`name`, `organization_id`, `case_manager_id`, `case_status_id`, `case_decision_type_id`, `case_decision_id`) VALUES ("Making the change", 4, 5,2,2, null);

                      
                         