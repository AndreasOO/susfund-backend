
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



DROP TABLE IF EXISTS `application`;
CREATE TABLE `application` ( `id` INT NOT NULL AUTO_INCREMENT,
                             `submission_date` DATE NOT NULL,
                             PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;



DROP TABLE IF EXISTS `cases`;
CREATE TABLE `cases` ( `id` INT NOT NULL AUTO_INCREMENT,
						`name` VARCHAR(255) NOT NULL,
                        `organization_id` INT NOT NULL,
                        `case_manager_id` INT NOT NULL,
                        `case_status_id` INT NOT NULL,
                        `case_decision_type_id` INT NOT NULL,
                        `case_decision_id` INT,
                        `application_id` INT NOT NULL,
                        CONSTRAINT `FK_organization_id` FOREIGN KEY (`organization_id`) REFERENCES `organization` (`id`),
                        CONSTRAINT `FK_case_manager_id` FOREIGN KEY (`case_manager_id`) REFERENCES `case_manager` (`id`),
                        CONSTRAINT `FK_case_status_id` FOREIGN KEY (`case_status_id`) REFERENCES `case_status` (`id`),
                        CONSTRAINT `FK_case_decision_type_id` FOREIGN KEY (`case_decision_type_id`) REFERENCES `case_decision_type` (`id`),
                        CONSTRAINT `FK_case_decision_id` FOREIGN KEY (`case_decision_id`) REFERENCES `case_decision` (`id`),
                        CONSTRAINT `FK_application_id` FOREIGN KEY (`application_id`) REFERENCES `application` (`id`),
						 PRIMARY KEY (`id`)
					  ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `section`;
CREATE TABLE `section` ( `id` INT NOT NULL AUTO_INCREMENT,
                         `name` VARCHAR(255) NOT NULL,
                         PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `question`;
CREATE TABLE `question` (`id` INT NOT NULL AUTO_INCREMENT,
                         `title` VARCHAR(255) NOT NULL,
                         `preamble` VARCHAR(255) NOT NULL,
                         `assisting_text` VARCHAR(255) NOT NULL,
                         `section_id` INT NOT NULL,
                         CONSTRAINT `FK_section_id` FOREIGN KEY (`section_id`) REFERENCES `section` (`id`),
                         PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


-- skriv om för application och question
DROP TABLE IF EXISTS `applications_questions`;
CREATE TABLE `applications_questions` ( `application_id` INT NOT NULL,
                                       `question_id` INT NOT NULL,
                                       CONSTRAINT `FK_applications_questions_application_id` FOREIGN KEY (`application_id`) REFERENCES `application` (`id`),
                                       CONSTRAINT `FK_applications_questions_question_id` FOREIGN KEY (`question_id`) REFERENCES `question` (`id`),
                                       UNIQUE KEY `applications_questions_index` (`application_id`, `question_id`)
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

INSERT INTO `susfund_db`.`case_decision_result` (`name`) VALUES ("Approved");
INSERT INTO `susfund_db`.`case_decision_result` (`name`) VALUES ("Rejected");
INSERT INTO `susfund_db`.`case_decision_result` (`name`) VALUES ("Partially approved");

INSERT INTO `susfund_db`.`case_decision` (`case_decision_result_id`, `decision_date`) VALUES (1, "2025-03-23");
INSERT INTO `susfund_db`.`case_decision` (`case_decision_result_id`, `decision_date`) VALUES (2, "2025-02-14");
INSERT INTO `susfund_db`.`case_decision` (`case_decision_result_id`, `decision_date`) VALUES (3, "2025-03-10");
INSERT INTO `susfund_db`.`case_decision` (`case_decision_result_id`, `decision_date`) VALUES (1, "2025-03-20");

INSERT INTO `susfund_db`.`application` (`submission_date`) VALUES ("2025-03-23");
INSERT INTO `susfund_db`.`application` (`submission_date`) VALUES ("2025-03-24");
INSERT INTO `susfund_db`.`application` (`submission_date`) VALUES ("2025-03-10");
INSERT INTO `susfund_db`.`application` (`submission_date`) VALUES ("2025-02-11");
INSERT INTO `susfund_db`.`application` (`submission_date`) VALUES ("2025-02-20");
INSERT INTO `susfund_db`.`application` (`submission_date`) VALUES ("2025-02-22");
INSERT INTO `susfund_db`.`application` (`submission_date`) VALUES ("2025-02-28");


INSERT INTO `susfund_db`.`cases` (`name`, `organization_id`, `case_manager_id`, `case_status_id`, `case_decision_type_id`, `case_decision_id`, `application_id`) VALUES ("Going solar", 1, 1,1,1, 1, 1);
INSERT INTO `susfund_db`.`cases` (`name`, `organization_id`, `case_manager_id`, `case_status_id`, `case_decision_type_id`, `case_decision_id`, `application_id`) VALUES ("I got wind", 1, 1,2,2, 2, 2);
INSERT INTO `susfund_db`.`cases` (`name`, `organization_id`, `case_manager_id`, `case_status_id`, `case_decision_type_id`, `case_decision_id`, `application_id`) VALUES ("Shop locally", 1, 1,3,3, 3, 3);
INSERT INTO `susfund_db`.`cases` (`name`, `organization_id`, `case_manager_id`, `case_status_id`, `case_decision_type_id`, `case_decision_id`, `application_id`) VALUES ("Funding for future", 1, 2,4,4, 4, 4);
INSERT INTO `susfund_db`.`cases` (`name`, `organization_id`, `case_manager_id`, `case_status_id`, `case_decision_type_id`, `case_decision_id`, `application_id`) VALUES ("Going green", 2, 3,2,2, null, 5);
INSERT INTO `susfund_db`.`cases` (`name`, `organization_id`, `case_manager_id`, `case_status_id`, `case_decision_type_id`, `case_decision_id`, `application_id`) VALUES ("No more gaslighting", 3, 4,2,2, null, 6);
INSERT INTO `susfund_db`.`cases` (`name`, `organization_id`, `case_manager_id`, `case_status_id`, `case_decision_type_id`, `case_decision_id`, `application_id`) VALUES ("Making the change", 4, 5,2,2, null, 7);

INSERT INTO `susfund_db`.`section` (`name`) VALUES ("Economic feasibility");
INSERT INTO `susfund_db`.`section` (`name`) VALUES ("Regional Growth");
INSERT INTO `susfund_db`.`section` (`name`) VALUES ("Company");
INSERT INTO `susfund_db`.`section` (`name`) VALUES ("Sustainability");

INSERT INTO `susfund_db`.`question` (`title`, `preamble`, `assisting_text`, `section_id`) VALUES ("Björn-Bessé Borg", "Han vill investera", "Men går det bra?", 1);
INSERT INTO `susfund_db`.`question` (`title`, `preamble`, `assisting_text`, `section_id`) VALUES ("Investera hur då", "Är en pengafråga", "Jag försöker", 1);
INSERT INTO `susfund_db`.`question` (`title`, `preamble`, `assisting_text`, `section_id`) VALUES ("Andreas hjälp", "Vågar inte ställa fler frågor", "Så det här får duga", 2);
INSERT INTO `susfund_db`.`question` (`title`, `preamble`, `assisting_text`, `section_id`) VALUES ("Är ni hållbara?", "Hållbarhetsfråga", "Hmm vad kan stå här då", 4);


INSERT INTO `susfund_db`.`applications_questions` (`application_id`, `question_id`) VALUES (2, 1);
INSERT INTO `susfund_db`.`applications_questions` (`application_id`, `question_id`) VALUES (1, 1);
INSERT INTO `susfund_db`.`applications_questions` (`application_id`, `question_id`) VALUES (3, 4);
INSERT INTO `susfund_db`.`applications_questions` (`application_id`, `question_id`) VALUES (4, 2);
INSERT INTO `susfund_db`.`applications_questions` (`application_id`, `question_id`) VALUES (4, 3);
INSERT INTO `susfund_db`.`applications_questions` (`application_id`, `question_id`) VALUES (5, 1);
INSERT INTO `susfund_db`.`applications_questions` (`application_id`, `question_id`) VALUES (6, 3);
INSERT INTO `susfund_db`.`applications_questions` (`application_id`, `question_id`) VALUES (7, 2);



                      
                         