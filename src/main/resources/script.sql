CREATE database blog;
CREATE USER 'bloguser'@'localhost' identified by '!GDFSG78vsd/';
GRANT ALL PRIVILEGES ON blog.* TO 'bloguser'@'localhost';
INSERT INTO `blog`.`role` (`name`) VALUES ('ROLE_USER');
INSERT INTO `blog`.`role` (`name`) VALUES ('ROLE_MOD');
INSERT INTO `blog`.`role` (`name`) VALUES ('ROLE_ADMIN');