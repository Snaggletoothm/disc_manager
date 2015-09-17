CREATE TABLE user (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(30) NOT NULL,
  password VARCHAR(60) NOT NULL DEFAULT '1234',
  email VARCHAR(50) NOT NULL DEFAULT 'default@mail.com',
  photo BLOB,
  state VARCHAR(30) NOT NULL,
  UNIQUE UQ_USER (name),
  PRIMARY KEY (id)
);

CREATE TABLE user_profile(
  id INT NOT NULL AUTO_INCREMENT,
  type VARCHAR(30) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE (type)
);

CREATE TABLE app_user_user_profile(
  user_id INT NOT NULL,
  user_profile_id INT NOT NULL,
  PRIMARY KEY (user_id, user_profile_id),
  CONSTRAINT FK_APP_USER FOREIGN KEY (user_id) REFERENCES user (id) ON DELETE CASCADE,
  CONSTRAINT FK_USER_PROFILE FOREIGN KEY (user_profile_id) REFERENCES user_profile (id) ON DELETE CASCADE
);

CREATE TABLE disc (
  id INT NOT NULL AUTO_INCREMENT,
  user_id INT NOT NULL,
  title VARCHAR(60) NOT NULL,
  genre VARCHAR(30) NOT NULL,
  description VARCHAR(2000),
  imgDisc MEDIUMBLOB,
  owner INT NOT NULL,
  tempOwnerName VARCHAR(60) NOT NULL DEFAULT '',
  PRIMARY KEY (id),
  CONSTRAINT USER_FK FOREIGN KEY (user_id) REFERENCES user (id)
);

CREATE TABLE comment (
  id INT NOT NULL AUTO_INCREMENT,
  disc_id INT NOT NULL,
  user_name VARCHAR(30) NOT NULL,
  user_comment VARCHAR(2000),
  local_date DATE NOT NULL,
  rating INT NOT NULL DEFAULT 0,
  PRIMARY KEY (id),
  CONSTRAINT fk_user_comment FOREIGN KEY (disc_id) REFERENCES disc (id) ON DELETE CASCADE
);


-- ===================================================
-- Remember my schema
CREATE TABLE persistent_logins(
  username VARCHAR(64) NOT NULL,
  series VARCHAR(64) NOT NULL,
  token VARCHAR(64) NOT NULL,
  last_used TIMESTAMP NOT NULL,
  PRIMARY KEY (series)
);