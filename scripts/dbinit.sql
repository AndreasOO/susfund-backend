
SET NAMES utf8mb4 COLLATE utf8mb4_unicode_ci;

DROP SCHEMA IF EXISTS `susfund_db`;
CREATE SCHEMA IF NOT EXISTS `susfund_db`
    CHARACTER SET utf8mb4
    COLLATE utf8mb4_unicode_ci;
USE `susfund_db`;


DROP TABLE IF EXISTS `organization`;
CREATE TABLE `organization` ( `id` INT NOT NULL AUTO_INCREMENT,
                              `name` VARCHAR(255) NOT NULL,
                              `organization_type` VARCHAR(255),
                              PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 
  CHARACTER SET utf8mb4
  COLLATE utf8mb4_unicode_ci;


DROP TABLE IF EXISTS `case_manager`;
CREATE TABLE `case_manager` ( `id` INT NOT NULL AUTO_INCREMENT,
                              `name` VARCHAR(255) NOT NULL,
                              PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 
  CHARACTER SET utf8mb4
  COLLATE utf8mb4_unicode_ci;


DROP TABLE IF EXISTS `user_password`;
CREATE TABLE `user_password` (`id` INT NOT NULL AUTO_INCREMENT,
                              `password` VARCHAR(255) NOT NULL,
                              PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 
  CHARACTER SET utf8mb4
  COLLATE utf8mb4_unicode_ci;


DROP TABLE IF EXISTS `user_credentials`;
CREATE TABLE `user_credentials` (`id` INT NOT NULL AUTO_INCREMENT,
                                 `user_name` VARCHAR(255) NOT NULL,
                                 `case_manager_id` INT NOT NULL,
                                 `user_password_id` INT NOT NULL,
                                 PRIMARY KEY (`id`),
                                 CONSTRAINT `FK_case_manager_id2` FOREIGN KEY (`case_manager_id`) REFERENCES `case_manager` (`id`),
                                 CONSTRAINT `FK_user_password_id` FOREIGN KEY(`user_password_id`) REFERENCES `user_password` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 
  CHARACTER SET utf8mb4
  COLLATE utf8mb4_unicode_ci;


DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` ( `id` INT NOT NULL AUTO_INCREMENT,
                           `name` VARCHAR(255) NOT NULL,
                           PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 
  CHARACTER SET utf8mb4
  COLLATE utf8mb4_unicode_ci;


DROP TABLE IF EXISTS `user_credentials_user_roles`;
CREATE TABLE `user_credentials_user_roles` ( `user_credentials_id` INT NOT NULL,
                                             `user_role_id` INT NOT NULL,
                                             CONSTRAINT `FK_user_credentials_id2` FOREIGN KEY (`user_credentials_id`) REFERENCES `user_credentials` (`id`),
                                             CONSTRAINT `FK_user_role_id` FOREIGN KEY (`user_role_id`) REFERENCES `user_role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 
  CHARACTER SET utf8mb4
  COLLATE utf8mb4_unicode_ci;


-- ---------------------------------------------------------------------------- START FIELD DEFINITION

DROP TABLE IF EXISTS `support_type_node`;
CREATE TABLE `support_type_node` (`id` INT NOT NULL AUTO_INCREMENT,
                                   `tech_name` VARCHAR(255),
                                   PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1
  CHARACTER SET utf8mb4
  COLLATE utf8mb4_unicode_ci;


DROP TABLE IF EXISTS `case_entity`;
CREATE TABLE `case_entity` (`id` INT NOT NULL AUTO_INCREMENT,
                            `name` VARCHAR(255) NOT NULL,
                            `organization_id` INT NOT NULL,
                            `case_manager_id` INT NOT NULL,
                            `case_controller_id` INT NOT NULL,
                            `handled_by_id` INT NOT NULL,
                            `case_status` VARCHAR(255) NOT NULL,
                            `case_decision_type` VARCHAR(255) NOT NULL,
                            `support_type_node_id` INT NOT NULL,
                            CONSTRAINT `FK10_organization_id` FOREIGN KEY (`organization_id`) REFERENCES `organization` (`id`),
                            CONSTRAINT `FK10_case_manager_id` FOREIGN KEY (`case_manager_id`) REFERENCES `case_manager` (`id`),
                            CONSTRAINT `FK11_case_manager_id` FOREIGN KEY (`case_controller_id`) REFERENCES `case_manager` (`id`),
                            CONSTRAINT `FK12_case_manager_id` FOREIGN KEY (`handled_by_id`) REFERENCES `case_manager` (`id`),
                            CONSTRAINT `FK2_support_type_node_id` FOREIGN KEY (`support_type_node_id`) REFERENCES `support_type_node` (`id`),
                            PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 
  CHARACTER SET utf8mb4
  COLLATE utf8mb4_unicode_ci;


DROP TABLE IF EXISTS `field_definition_entity`;
CREATE TABLE `field_definition_entity` ( `id` INT NOT NULL AUTO_INCREMENT,
                                         `title` VARCHAR(255),
                                         `preamble` VARCHAR(255),
                                         `assisting_text` VARCHAR(255),
                                         `has_comment` TINYINT,
                                         `start_date` DATE,
                                         `end_date` DATE,
                                         `sub_section` VARCHAR(255),
                                         `field_type` VARCHAR(255) NOT NULL,
                                         `budget_type` VARCHAR(255),
                                         `selectable` VARCHAR(255),
                                         `frontend_location` VARCHAR(255),
                                         `row_index` INT,
                                         `section` VARCHAR(255),
                                         `DISCRIMINATOR_FIELD_TYPE` VARCHAR(255) NOT NULL,
                                         PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 
  CHARACTER SET utf8mb4
  COLLATE utf8mb4_unicode_ci;


DROP TABLE IF EXISTS `stn_fdn`;
CREATE TABLE `stn_fdn` (`field_definition_id` INT NOT NULL,
                        `support_type_node_id` INT NOT NULL,
                        CONSTRAINT `FK5_field_definition_id` FOREIGN KEY  (`field_definition_id`) REFERENCES `field_definition_entity` (`id`),
                        CONSTRAINT `FK_support_type_node_id` FOREIGN KEY  (`support_type_node_id`) REFERENCES `support_type_node` (`id`),
                        PRIMARY KEY (`field_definition_id`,`support_type_node_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1
  CHARACTER SET utf8mb4
  COLLATE utf8mb4_unicode_ci;


DROP TABLE IF EXISTS `field_value_entity`;
CREATE TABLE `field_value_entity` ( `id` INT NOT NULL AUTO_INCREMENT,
                                    `field_definition_entity_id` INT NOT NULL,
                                    `owning_case` INT NOT NULL,
                                    `string_value` VARCHAR(255),
                                    `numeric_value` INT,
                                    `date_value` DATE,
                                    `total_financing_ratio` INT,
                                    `last_updated` DATE,
                                    `decision_date` DATE,
                                    `assessment_justification` VARCHAR(255),
                                    `assessment_score` VARCHAR(255),
                                    `decision_motivation` VARCHAR(255),
                                    `decision_result_type` VARCHAR(255),
                                    `DISCRIMINATOR_FIELD_VALUE_TYPE` VARCHAR(255) NOT NULL,
                                    CONSTRAINT `FK1_field_definition_entity_id` FOREIGN KEY  (`field_definition_entity_id`) REFERENCES  `field_definition_entity` (`id`),
                                    CONSTRAINT `FK9_case_id` FOREIGN KEY  (`owning_case`) REFERENCES  `case_entity` (`id`),
                                    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 
  CHARACTER SET utf8mb4
  COLLATE utf8mb4_unicode_ci;


DROP TABLE IF EXISTS `financing_row`;
CREATE TABLE `financing_row` ( `id` INT NOT NULL AUTO_INCREMENT,
                               `field_value_entity_id` INT NOT NULL,
                               `organization_id` INT NOT NULL,
                               `financing_amount` INT NOT NULL,
                               `financing_percentage` INT NOT NULL,
                               `financing_type` VARCHAR(255),
                                CONSTRAINT `FK1_field_value_entity_id` FOREIGN KEY  (`field_value_entity_id`) REFERENCES  `field_value_entity` (`id`),
                                CONSTRAINT `FK4_organization_id` FOREIGN KEY  (`organization_id`) REFERENCES  `organization` (`id`),
                                PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 
  CHARACTER SET utf8mb4
  COLLATE utf8mb4_unicode_ci;


DROP TABLE IF EXISTS `budget_row`;
CREATE TABLE `budget_row` ( `id` INT NOT NULL AUTO_INCREMENT,
                            `field_value_entity_id` INT NOT NULL,
                            `estimated_cost` INT NOT NULL,
                            `cost_type` VARCHAR(255) NOT NULL,
                            `accrued_cost` INT NOT NULL,
                            `description` VARCHAR(255),
                            CONSTRAINT `FK2_field_value_entity_id` FOREIGN KEY  (`field_value_entity_id`) REFERENCES  `field_value_entity` (`id`),
                            PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 
  CHARACTER SET utf8mb4
  COLLATE utf8mb4_unicode_ci;


DROP TABLE IF EXISTS `selectable_value`;
CREATE TABLE `selectable_value` (`id` INT NOT NULL AUTO_INCREMENT,
                                 `selectable_type` VARCHAR(255) NOT NULL,
                                 `value` VARCHAR(255) NOT NULL,
                                 PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 
  CHARACTER SET utf8mb4
  COLLATE utf8mb4_unicode_ci;


DROP TABLE IF EXISTS `fdn_slv`;
CREATE TABLE `fdn_slv` (`field_definition_id` INT NOT NULL ,
                        `selectable_value_id` INT NOT NULL ,
                        CONSTRAINT `FK4_field_definition_id` FOREIGN KEY  (`field_definition_id`) REFERENCES  `field_definition_entity` (`id`),
                        CONSTRAINT `FK_selectable_value_id` FOREIGN KEY  (`selectable_value_id`) REFERENCES  `selectable_value` (`id`),
                                 PRIMARY KEY (`field_definition_id`,`selectable_value_id`)

) ENGINE=InnoDB AUTO_INCREMENT=1 
  CHARACTER SET utf8mb4
  COLLATE utf8mb4_unicode_ci;


DROP TABLE IF EXISTS `justification_entity`;
CREATE TABLE `justification_entity` (`id` INT NOT NULL AUTO_INCREMENT,
                                    `field_value_entity_id` INT NOT NULL,
                                    `selectable_value_id` INT NOT NULL,
                                    `justification_type` VARCHAR(255) NOT NULL,
                                    CONSTRAINT `FK3_field_value_entity_id` FOREIGN KEY  (`field_value_entity_id`) REFERENCES  `field_value_entity` (`id`),
                                    CONSTRAINT `FK1_selectable_value_id` FOREIGN KEY  (`selectable_value_id`) REFERENCES  `selectable_value` (`id`),
                                    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 
  CHARACTER SET utf8mb4
  COLLATE utf8mb4_unicode_ci;


DROP TABLE IF EXISTS `history_event`;
CREATE TABLE `history_event` (`id` INT NOT NULL AUTO_INCREMENT,
                               `field_value_entity_id` INT NOT NULL,
                               `history_event_type` VARCHAR(255),
                               `history_event_date` DATE,
                               `history_event_details` VARCHAR(255),
                               CONSTRAINT `FK4_field_value_entity_id` FOREIGN KEY  (`field_value_entity_id`) REFERENCES  `field_value_entity` (`id`),
                               PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 
  CHARACTER SET utf8mb4
  COLLATE utf8mb4_unicode_ci;

-- -------------------------------------------------------------------------------- START INSERTS

INSERT INTO `susfund_db`.`organization` (`name`, `organization_type`) VALUES ("CompanyOne", "SOLE_TRADER");
INSERT INTO `susfund_db`.`organization` (`name`, `organization_type`) VALUES ("CompanyTwo", "LIMITED_COMPANY");
INSERT INTO `susfund_db`.`organization` (`name`, `organization_type`) VALUES ("CompanyThree", "BRANCH");
INSERT INTO `susfund_db`.`organization` (`name`, `organization_type`) VALUES ("CompanyFour", "LIMITED_PARTNERSHIP");


INSERT INTO `susfund_db`.`case_manager` (`name`) VALUES ("UNASSIGNED");
INSERT INTO `susfund_db`.`case_manager` (`name`) VALUES ("Andreas Ohlander");
INSERT INTO `susfund_db`.`case_manager` (`name`) VALUES ("Josefin Törner");
INSERT INTO `susfund_db`.`case_manager` (`name`) VALUES ("Linn Edvarsson");
INSERT INTO `susfund_db`.`case_manager` (`name`) VALUES ("Lasse Maja");


INSERT INTO `susfund_db`.`user_role` (`name`) VALUES ("user");
INSERT INTO `susfund_db`.`user_role` (`name`) VALUES ("user role 2");
INSERT INTO `susfund_db`.`user_role` (`name`) VALUES ("user role 3");


INSERT INTO `susfund_db`.`user_password` (`password`) VALUES ("test1234");


INSERT INTO `susfund_db`.`user_credentials` (`user_name`, `case_manager_id`, `user_password_id`) VALUES ("testuser", 1, 1);


INSERT INTO `susfund_db`.`user_credentials_user_roles` (`user_credentials_id`, `user_role_id`) VALUES (1, 1);


INSERT INTO `selectable_value` (selectable_type, value) VALUES ("CASE_DECISION", "APPROVED");
INSERT INTO `selectable_value` (selectable_type, value) VALUES ("CASE_DECISION", "REJECTED");
INSERT INTO `selectable_value` (selectable_type, value) VALUES ("CASE_DECISION", "PARTIALLY APPROVED");