DROP TABLE IF EXISTS contact;

CREATE TABLE contact (
  id          INT         NOT NULL AUTO_INCREMENT,
  first_name  VARCHAR(60) NOT NULL,
  last_name   VARCHAR(40) NOT NULL,
  birth_date  DATE,
  discription VARCHAR(2000),
  photo       BLOB,
  version     INT         NOT NULL DEFAULT 0,
  UNIQUE (first_name, last_name),
  PRIMARY KEY (id)

);

CREATE TABLE contact_tel_detail (
  id         INT NOT NULL AUTO_INCREMENT,
  contact_id INT NOT NULL,
  tel_type   INT NOT NULL,
  tel_number INT NOT NULL,
  UNIQUE (contact_id, tel_type),
  PRIMARY KEY (id),
  CONSTRAINT fk_contact_tel_detail_1 FOREIGN KEY (CONTACT_ID) REFERENCES contact (id)
);
