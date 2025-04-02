
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

DROP TABLE IF EXISTS `case_assessment`;
CREATE TABLE `case_assessment` ( `id` INT NOT NULL AUTO_INCREMENT,
								`assessment_date` DATE,
                                PRIMARY KEY (`id`)
                    ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `assessment_result`;
CREATE TABLE `assessment_result` ( `id` INT NOT NULL AUTO_INCREMENT,
								`case_assessment_id` INT NOT NULL,
								`assessment_item_id` INT NOT NULL,
                                `score` INT NOT NULL,
                                `justification` VARCHAR(4000) NOT NULL,
                                CONSTRAINT `FK1_case_assessment_id` FOREIGN KEY  (`case_assessment_id`) REFERENCES  `case_assessment` (`id`),
                                CONSTRAINT `FK_assessment_item_id` FOREIGN KEY  (`assessment_item_id`) REFERENCES  `assessment_item` (`id`),
                                UNIQUE `case_assessment_assessment_result_index`(`case_assessment_id`, `assessment_item_id`),
                                PRIMARY KEY (`id`)
                    ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

-- -----------------------------------------END NEW ANDREAS

-- TODO ADD CASE ASSESSMENT ID TO CASE COLUMNS

DROP TABLE IF EXISTS `case_application`;
CREATE TABLE `case_application` ( `id` INT NOT NULL AUTO_INCREMENT,
                             `submission_date` DATE NOT NULL,
                             PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;



DROP TABLE IF EXISTS `application_section`;
CREATE TABLE `application_section` ( `id` INT NOT NULL AUTO_INCREMENT,
                         `name` VARCHAR(255) NOT NULL,
                         PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `application_question`;
CREATE TABLE `application_question` (`id` INT NOT NULL AUTO_INCREMENT,
                         `title` VARCHAR(255) NOT NULL,
                         `preamble` VARCHAR(255) NOT NULL,
                         `assisting_text` VARCHAR(255) NOT NULL,
                         `application_section_id` INT NOT NULL,
                         CONSTRAINT `FK_application_section_id` FOREIGN KEY (`application_section_id`) REFERENCES `application_section` (`id`),
                         PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `question_result`;
CREATE TABLE `question_result` ( `id` INT NOT NULL AUTO_INCREMENT,
                                 `answer` VARCHAR(255) NOT NULL,
                                 `application_question_id` INT NOT NULL,
                                 `case_application_id` INT NOT NULL,
                                 CONSTRAINT `FK_application_question_id` FOREIGN KEY (`application_question_id`) REFERENCES `application_question` (`id`),
                                 CONSTRAINT `FK_case_application_id` FOREIGN KEY (`case_application_id`) REFERENCES `case_application` (`id`),
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
                        `case_assessment_id` INT NOT NULL,
                        `case_application_id` INT NOT NULL,
                        CONSTRAINT `FK_organization_id` FOREIGN KEY (`organization_id`) REFERENCES `organization` (`id`),
                        CONSTRAINT `FK_case_manager_id` FOREIGN KEY (`case_manager_id`) REFERENCES `case_manager` (`id`),
                        CONSTRAINT `FK_case_status_id` FOREIGN KEY (`case_status_id`) REFERENCES `case_status` (`id`),
                        CONSTRAINT `FK_case_decision_type_id` FOREIGN KEY (`case_decision_type_id`) REFERENCES `case_decision_type` (`id`),
                        CONSTRAINT `FK_case_decision_id` FOREIGN KEY (`case_decision_id`) REFERENCES `case_decision` (`id`),
                        CONSTRAINT `FK2_case_assessment_id` FOREIGN KEY (`case_assessment_id`) REFERENCES `case_assessment` (`id`),
                        CONSTRAINT `FK2_case_application_id` FOREIGN KEY (`case_application_id`) REFERENCES `case_application` (`id`),
						 PRIMARY KEY (`id`)
					  ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

-- -----------------------------------------START VIKTORS HISTORY IMPLEMENTATION

DROP TABLE IF EXISTS `event_type`;
CREATE TABLE `event_type` ( `id` INT NOT NULL AUTO_INCREMENT,
                            `name` VARCHAR(255) NOT NULL,
                            PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `history_event`;
CREATE TABLE `history_event` ( `id` INT NOT NULL AUTO_INCREMENT,
                               `cases_id` INT NOT NULL,
                               `event_type_id` INT NOT NULL,
                               `date` DATE NOT NULL,
                               `details` VARCHAR(4000) NOT NULL,
                               CONSTRAINT `FK_event_type_id` FOREIGN KEY (`event_type_id`) REFERENCES `event_type` (`id`),
                               CONSTRAINT `FK_cases_id` FOREIGN KEY (`cases_id`) REFERENCES `cases` (`id`),
                               PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

-- -----------------------------------------END VIKTORS HISTORY IMPLEMENTATION
-- -----------------------------------------START JOSEFINS USER IMPLEMENTATION


DROP TABLE IF EXISTS `user_credentials`;
CREATE TABLE `user_credentials` (`id` INT NOT NULL AUTO_INCREMENT,
                                `user_name` VARCHAR(255) NOT NULL,
                                `case_manager_id` INT NOT NULL,
                                 PRIMARY KEY (`id`),
                                 CONSTRAINT `FK_case_manager_id2` FOREIGN KEY (`case_manager_id`) REFERENCES `case_manager` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `user_password`;
CREATE TABLE `user_password` (`id` INT NOT NULL AUTO_INCREMENT,
                              `password` VARCHAR(255) NOT NULL,
                              `user_credentials_id` INT NOT NULL,
                               PRIMARY KEY (`id`),
                               CONSTRAINT `FK_user_credentials_id` FOREIGN KEY (`user_credentials_id`) REFERENCES `user_credentials` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` ( `id` INT NOT NULL AUTO_INCREMENT,
                           `name` VARCHAR(255) NOT NULL,
                            PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `user_roles_mapping`;
CREATE TABLE `user_roles_mapping` ( `user_credentials_id` INT NOT NULL,
                            `user_role_id` INT NOT NULL,
                            CONSTRAINT `FK_user_credentials_id2` FOREIGN KEY (`user_credentials_id`) REFERENCES `user_credentials` (`id`),
                            CONSTRAINT `FK_user_role_id` FOREIGN KEY (`user_role_id`) REFERENCES `user_role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

-- ------------------------------------END JOSEFINS USER IMPLEMENTATION

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


-- NEW ANDREAS
INSERT INTO `susfund_db`.`assessment_section` (`name`) VALUES ("Economic feasibility");
INSERT INTO `susfund_db`.`assessment_section` (`name`) VALUES ("Regional Growth");
INSERT INTO `susfund_db`.`assessment_section` (`name`) VALUES ("Company");
INSERT INTO `susfund_db`.`assessment_section` (`name`) VALUES ("Sustainability");

INSERT INTO `susfund_db`.`assessment_item` (`assessment_section_id`, `title`, `preamble`, `assisting_text`) VALUES (1, "Economic feasibility title", "Economic feasibility preamble", "Economic feasibility assisting text" );
INSERT INTO `susfund_db`.`assessment_item` (`assessment_section_id`, `title`, `preamble`, `assisting_text`) VALUES (2, "Regional Growth title", "Regional Growth preamble", "Regional Growth assisting text" );
INSERT INTO `susfund_db`.`assessment_item` (`assessment_section_id`, `title`, `preamble`, `assisting_text`) VALUES (3, "Company title", "Company preamble", "Company assisting text" );
INSERT INTO `susfund_db`.`assessment_item` (`assessment_section_id`, `title`, `preamble`, `assisting_text`) VALUES (4, "Sustainability title", "Sustainability preamble", "Sustainability assisting text" );


INSERT INTO `susfund_db`.`case_assessment` (`assessment_date`) VALUES ("2024-12-01");
INSERT INTO `susfund_db`.`case_assessment` (`assessment_date`) VALUES ("2024-12-02");
INSERT INTO `susfund_db`.`case_assessment` (`assessment_date`) VALUES ("2024-12-03");
INSERT INTO `susfund_db`.`case_assessment` (`assessment_date`) VALUES ("2024-12-04");
INSERT INTO `susfund_db`.`case_assessment` (`assessment_date`) VALUES ("2024-12-05");
INSERT INTO `susfund_db`.`case_assessment` (`assessment_date`) VALUES ("2024-12-06");
INSERT INTO `susfund_db`.`case_assessment` (`assessment_date`) VALUES ("2024-12-07");

INSERT INTO `susfund_db`.`assessment_result` (`case_assessment_id`, `assessment_item_id`, `score`, `justification`) VALUES (1, 1, 5, "Did really well");
INSERT INTO `susfund_db`.`assessment_result` (`case_assessment_id`, `assessment_item_id`, `score`, `justification`) VALUES (1, 2, 1, "Did poorly");
INSERT INTO `susfund_db`.`assessment_result` (`case_assessment_id`, `assessment_item_id`, `score`, `justification`) VALUES (1, 3, 3, "Did ok");
INSERT INTO `susfund_db`.`assessment_result` (`case_assessment_id`, `assessment_item_id`, `score`, `justification`) VALUES (2, 4, 5, "Did really well");
INSERT INTO `susfund_db`.`assessment_result` (`case_assessment_id`, `assessment_item_id`, `score`, `justification`) VALUES (3, 1, 5, "Did really well");
INSERT INTO `susfund_db`.`assessment_result` (`case_assessment_id`, `assessment_item_id`, `score`, `justification`) VALUES (4, 2, 5, "Did really well");
INSERT INTO `susfund_db`.`assessment_result` (`case_assessment_id`, `assessment_item_id`, `score`, `justification`) VALUES (5, 3, 5, "Did really well");
INSERT INTO `susfund_db`.`assessment_result` (`case_assessment_id`, `assessment_item_id`, `score`, `justification`) VALUES (5, 4, 5, "Did really well");
INSERT INTO `susfund_db`.`assessment_result` (`case_assessment_id`, `assessment_item_id`, `score`, `justification`) VALUES (6, 4, 5, "Did really well");
INSERT INTO `susfund_db`.`assessment_result` (`case_assessment_id`, `assessment_item_id`, `score`, `justification`) VALUES (7, 4, 5, "Did really well");



-- TODO ADD RESULT TSUFF

-- TODO INSERT THE REST
-- END NEW ANDREAS


INSERT INTO `susfund_db`.`case_application` (`submission_date`) VALUES ("2025-03-23");
INSERT INTO `susfund_db`.`case_application` (`submission_date`) VALUES ("2025-03-24");
INSERT INTO `susfund_db`.`case_application` (`submission_date`) VALUES ("2025-03-10");
INSERT INTO `susfund_db`.`case_application` (`submission_date`) VALUES ("2025-02-11");
INSERT INTO `susfund_db`.`case_application` (`submission_date`) VALUES ("2025-02-20");
INSERT INTO `susfund_db`.`case_application` (`submission_date`) VALUES ("2025-02-22");
INSERT INTO `susfund_db`.`case_application` (`submission_date`) VALUES ("2025-02-28");


INSERT INTO `susfund_db`.`application_section` (`name`) VALUES ("Economic feasibility");
INSERT INTO `susfund_db`.`application_section` (`name`) VALUES ("Regional Growth");
INSERT INTO `susfund_db`.`application_section` (`name`) VALUES ("Company");
INSERT INTO `susfund_db`.`application_section` (`name`) VALUES ("Sustainability");

INSERT INTO `susfund_db`.`application_question` (`title`, `preamble`, `assisting_text`, `application_section_id`) VALUES ("Title", "Preamble", "Assisting text", 1);
INSERT INTO `susfund_db`.`application_question` (`title`, `preamble`, `assisting_text`, `application_section_id`) VALUES ("Title", "Preamble", "Assisting text",  1);
INSERT INTO `susfund_db`.`application_question` (`title`, `preamble`, `assisting_text`, `application_section_id`) VALUES ("Title", "Preamble", "Assisting text", 2);
INSERT INTO `susfund_db`.`application_question` (`title`, `preamble`, `assisting_text`, `application_section_id`) VALUES ("Title", "Preamble", "Assisting text", 4);

INSERT INTO `susfund_db`.`question_result` (`answer`, `application_question_id`, `case_application_id`) VALUES ("Answer", 1, 1);
INSERT INTO `susfund_db`.`question_result` (`answer`, `application_question_id`, `case_application_id`) VALUES ("Answer", 2, 3);
INSERT INTO `susfund_db`.`question_result` (`answer`, `application_question_id`, `case_application_id`) VALUES ("Answer", 3, 2);
INSERT INTO `susfund_db`.`question_result` (`answer`, `application_question_id`, `case_application_id`) VALUES ("Answer", 4, 5);
INSERT INTO `susfund_db`.`question_result` (`answer`, `application_question_id`, `case_application_id`) VALUES ("Answer", 1, 5);



INSERT INTO `susfund_db`.`cases` (`name`, `organization_id`, `case_manager_id`, `case_status_id`, `case_decision_type_id`, `case_decision_id`, `case_assessment_id`, `case_application_id`) VALUES ("Going solar", 1, 1,1,1, 1,1,1);
INSERT INTO `susfund_db`.`cases` (`name`, `organization_id`, `case_manager_id`, `case_status_id`, `case_decision_type_id`, `case_decision_id`, `case_assessment_id`, `case_application_id`) VALUES ("I got wind", 1, 1,2,2, 2,2,2);
INSERT INTO `susfund_db`.`cases` (`name`, `organization_id`, `case_manager_id`, `case_status_id`, `case_decision_type_id`, `case_decision_id`, `case_assessment_id`, `case_application_id`) VALUES ("Shop locally", 1, 1,3,3, 3,3,3);
INSERT INTO `susfund_db`.`cases` (`name`, `organization_id`, `case_manager_id`, `case_status_id`, `case_decision_type_id`, `case_decision_id`, `case_assessment_id`, `case_application_id`) VALUES ("Funding for future", 1, 2,4,4, 4,4,4);
INSERT INTO `susfund_db`.`cases` (`name`, `organization_id`, `case_manager_id`, `case_status_id`, `case_decision_type_id`, `case_decision_id`, `case_assessment_id`, `case_application_id`) VALUES ("Going green", 2, 3,2,2, null,5,5);
INSERT INTO `susfund_db`.`cases` (`name`, `organization_id`, `case_manager_id`, `case_status_id`, `case_decision_type_id`, `case_decision_id`, `case_assessment_id`, `case_application_id`) VALUES ("No more gaslighting", 3, 4,2,2, null,6,6);
INSERT INTO `susfund_db`.`cases` (`name`, `organization_id`, `case_manager_id`, `case_status_id`, `case_decision_type_id`, `case_decision_id`, `case_assessment_id`, `case_application_id`) VALUES ("Making the change", 4, 5,2,2, null,7,7);

-- -----------------------------------------START VIKTORS HISTORY IMPLEMENTATION

INSERT INTO `susfund_db`.`event_type` (`name`) VALUES ("Event type 1");
INSERT INTO `susfund_db`.`event_type` (`name`) VALUES ("Event type 2");
INSERT INTO `susfund_db`.`event_type` (`name`) VALUES ("Event type 3");

INSERT INTO `susfund_db`.`history_event` (`cases_id`, `event_type_id`, `date`, `details`) VALUES (1, 1, "2025-03-27", "Details text");
INSERT INTO `susfund_db`.`history_event` (`cases_id`, `event_type_id`, `date`, `details`) VALUES (1, 2, "2025-03-31", "Details text");
INSERT INTO `susfund_db`.`history_event` (`cases_id`, `event_type_id`, `date`, `details`) VALUES (2, 3, "2025-03-20", "Details text");
INSERT INTO `susfund_db`.`history_event` (`cases_id`, `event_type_id`, `date`, `details`) VALUES (3, 1, "2025-03-25", "Details text");

-- -----------------------------------------END VIKTORS HISTORY IMPLEMENTATION

-- -----------------------------------------START JOSEFINS USER IMPLEMENTATION

INSERT INTO `susfund_db`.`user_role` (`name`) VALUES ("user");
INSERT INTO `susfund_db`.`user_role` (`name`) VALUES ("user role 2");
INSERT INTO `susfund_db`.`user_role` (`name`) VALUES ("user role 3");

INSERT INTO `susfund_db`.`user_credentials` (`user_name`, `case_manager_id`) VALUES ("testuser", 1);

INSERT INTO `susfund_db`.`user_password` (`password`, `user_credentials_id`) VALUES ("test1234", 1);

INSERT INTO `susfund_db`.`user_roles_mapping` (`user_credentials_id`, `user_role_id`) VALUES (1, 1);
