CREATE TABLE user (
  id int(11)  AUTO_INCREMENT PRIMARY  KEY NOT NULL,
  name varchar(50) DEFAULT NULL,
  account_id varchar(100) DEFAULT NULL,
  token varcar(36) DEFAULT NULL,
  gmt_create bigint(20) DEFAULT NULL,
  gmt_modified bigint(20) DEFAULT NULL
  );
