DROP USER 'casemanager'@'localhost';
DROP ROLE casemanager;
CREATE ROLE 'casemanager';
GRANT ALL ON susfund_db.* TO 'casemanager';
CREATE USER 'casemanager'@'localhost' IDENTIFIED BY 'test1234'; 
GRANT 'casemanager' TO 'casemanager'@'localhost';
SET DEFAULT ROLE ALL TO 'casemanager'@'localhost';
GRANT SUPER ON *.* TO 'casemanager'@'localhost';