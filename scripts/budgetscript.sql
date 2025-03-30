USE `susfund_db`;

DROP TABLE IF EXISTS `budget_post`;
DROP TABLE IF EXISTS `case_budget`;
DROP TABLE IF EXISTS `budget_post_type`;

DROP TABLE IF EXISTS `case_budget`;
CREATE TABLE `case_budget` ( `id` INT NOT NULL AUTO_INCREMENT,
							`date_last_changed` DATE,
                             PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `budget_post_type`;
CREATE TABLE `budget_post_type` ( `id` INT NOT NULL AUTO_INCREMENT,
							`name` VARCHAR(255) NOT NULL,
                             PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `budget_post`;
CREATE TABLE `budget_post` ( `id` INT NOT NULL AUTO_INCREMENT,
							`estimated_cost` INT NOT NULL,
							`budget_post_type_id` INT NOT NULL,
                            `case_budget_id` INT NOT NULL,
                             CONSTRAINT `FK_budget_post_type_id` FOREIGN KEY  (`budget_post_type_id`) REFERENCES  `budget_post_type` (`id`),
                             CONSTRAINT `FK_case_budget_id` FOREIGN KEY  (`case_budget_id`) REFERENCES  `case_budget` (`id`),
                             PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `budget_organization`;
CREATE TABLE `budget_organization` (
								`case_budget_id` INT NOT NULL,
								`organization_id` INT NOT NULL,
                                CONSTRAINT `FK2_organization_id` FOREIGN KEY (`organization_id`) REFERENCES `organization` (`id`),
                                CONSTRAINT `FK3_case_budget_id` FOREIGN KEY  (`case_budget_id`) REFERENCES  `case_budget` (`id`),
                                UNIQUE `budget_organization_index`(`case_budget_id`, `organization_id`),
                                PRIMARY KEY (`case_budget_id`, `organization_id`)
                    ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


INSERT INTO `susfund_db`.`case_budget` (`date_last_changed`) VALUES ("2024-03-29");
INSERT INTO `susfund_db`.`case_budget` (`date_last_changed`) VALUES ("2024-03-30");
INSERT INTO `susfund_db`.`case_budget` (`date_last_changed`) VALUES ("2024-03-30");
INSERT INTO `susfund_db`.`case_budget` (`date_last_changed`) VALUES ("2024-03-30");
INSERT INTO `susfund_db`.`case_budget` (`date_last_changed`) VALUES ("2024-03-30");
INSERT INTO `susfund_db`.`case_budget` (`date_last_changed`) VALUES ("2024-03-30");
INSERT INTO `susfund_db`.`case_budget` (`date_last_changed`) VALUES ("2024-03-30");

INSERT INTO `susfund_db`.`budget_post_type` (`name`) VALUES ("STAFF_COST");
INSERT INTO `susfund_db`.`budget_post_type` (`name`) VALUES ("LIGHT_EQUIPMENT");
INSERT INTO `susfund_db`.`budget_post_type` (`name`) VALUES ("HEAVY_EQUIPMENT");
INSERT INTO `susfund_db`.`budget_post_type` (`name`) VALUES ("MACHINERY");
INSERT INTO `susfund_db`.`budget_post_type` (`name`) VALUES ("IT_EQUIPMENT");
INSERT INTO `susfund_db`.`budget_post_type` (`name`) VALUES ("OVERHEAD");

-- case budget 1
INSERT INTO `susfund_db`.`budget_post` (`estimated_cost`, `budget_post_type_id`, `case_budget_id`) VALUES (5000, 1,1);
INSERT INTO `susfund_db`.`budget_post` (`estimated_cost`, `budget_post_type_id`, `case_budget_id`) VALUES (4000, 2,1);
INSERT INTO `susfund_db`.`budget_post` (`estimated_cost`, `budget_post_type_id`, `case_budget_id`) VALUES (2000, 3,1);
INSERT INTO `susfund_db`.`budget_post` (`estimated_cost`, `budget_post_type_id`, `case_budget_id`) VALUES (4000, 4,1);
INSERT INTO `susfund_db`.`budget_post` (`estimated_cost`, `budget_post_type_id`, `case_budget_id`) VALUES (8000, 5,1);
INSERT INTO `susfund_db`.`budget_post` (`estimated_cost`, `budget_post_type_id`, `case_budget_id`) VALUES (11000, 6,1);
INSERT INTO `susfund_db`.`budget_post` (`estimated_cost`, `budget_post_type_id`, `case_budget_id`) VALUES (50000, 1,1);

-- case budget 2-7
INSERT INTO `susfund_db`.`budget_post` (`estimated_cost`, `budget_post_type_id`, `case_budget_id`) VALUES (5000, 1,2);
INSERT INTO `susfund_db`.`budget_post` (`estimated_cost`, `budget_post_type_id`, `case_budget_id`) VALUES (5000, 1,3);
INSERT INTO `susfund_db`.`budget_post` (`estimated_cost`, `budget_post_type_id`, `case_budget_id`) VALUES (5000, 1,4);
INSERT INTO `susfund_db`.`budget_post` (`estimated_cost`, `budget_post_type_id`, `case_budget_id`) VALUES (5000, 1,5);
INSERT INTO `susfund_db`.`budget_post` (`estimated_cost`, `budget_post_type_id`, `case_budget_id`) VALUES (5000, 1,6);
INSERT INTO `susfund_db`.`budget_post` (`estimated_cost`, `budget_post_type_id`, `case_budget_id`) VALUES (5000, 1,7);

-- TODO insert into case
ALTER TABLE `susfund_db`.`cases` ADD COLUMN `case_budget_id` INT NOT NULL;

UPDATE `susfund_db`.`cases` SET `case_budget_id` = 1 WHERE `susfund_db`.`cases`.`id` = 1;
UPDATE `susfund_db`.`cases` SET `case_budget_id` = 2 WHERE `susfund_db`.`cases`.`id` = 2;
UPDATE `susfund_db`.`cases` SET `case_budget_id` = 3 WHERE `susfund_db`.`cases`.`id` = 3;
UPDATE `susfund_db`.`cases` SET `case_budget_id` = 4 WHERE `susfund_db`.`cases`.`id` = 4;
UPDATE `susfund_db`.`cases` SET `case_budget_id` = 5 WHERE `susfund_db`.`cases`.`id` = 5;
UPDATE `susfund_db`.`cases` SET `case_budget_id` = 6 WHERE `susfund_db`.`cases`.`id` = 6;
UPDATE `susfund_db`.`cases` SET `case_budget_id` = 7 WHERE `susfund_db`.`cases`.`id` = 7;


ALTER TABLE `susfund_db`.`cases` ADD CONSTRAINT `FK2_case_budget_id` FOREIGN KEY  (`case_budget_id`) REFERENCES  `case_budget` (`id`);

-- TODO join table for organization budget

INSERT INTO `susfund_db`.`budget_organization` (`case_budget_id`, `organization_id`) VALUES (1,1);
INSERT INTO `susfund_db`.`budget_organization` (`case_budget_id`, `organization_id`) VALUES (1,2);
INSERT INTO `susfund_db`.`budget_organization` (`case_budget_id`, `organization_id`) VALUES (1,3);
INSERT INTO `susfund_db`.`budget_organization` (`case_budget_id`, `organization_id`) VALUES (1,4);
