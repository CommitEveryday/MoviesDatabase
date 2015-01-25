DROP TABLE IF EXISTS director;
DROP TABLE IF EXISTS movie_genre;
DROP TABLE IF EXISTS actor;
DROP TABLE IF EXISTS review;
DROP TABLE IF EXISTS movie;
DROP TABLE IF EXISTS user_acount;
DROP TABLE IF EXISTS person;
DROP TABLE IF EXISTS rating;
DROP TABLE IF EXISTS genre;


CREATE TABLE movie (
  id INTEGER NOT NULL AUTO_INCREMENT,
  title VARCHAR(100) NOT NULL,
  premiere DATE NULL,
  PRIMARY KEY (id)
);
	
CREATE TABLE user_acount (
  id INTEGER NOT NULL AUTO_INCREMENT,
  login VARCHAR(100) NOT NULL,
  password VARCHAR(100) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY (login)
);
	
CREATE TABLE person (
  id INTEGER NOT NULL AUTO_INCREMENT,
  name VARCHAR(100) NOT NULL,
  surname VARCHAR(100) NULL,
  birth DATE NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE rating (
  id INTEGER NOT NULL AUTO_INCREMENT,
  description VARCHAR(100) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY (description)
);

CREATE TABLE genre (
  id INTEGER NOT NULL AUTO_INCREMENT,
  name VARCHAR(100) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY (name)
);

CREATE TABLE review (
  id INTEGER NOT NULL AUTO_INCREMENT,
  message TEXT NOT NULL,
  id_movie INTEGER NOT NULL,
  id_rating INTEGER NOT NULL,
  id_user_acount INTEGER NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (id_movie) REFERENCES movie (id),
  FOREIGN KEY (id_rating) REFERENCES rating (id),
  FOREIGN KEY (id_user_acount) REFERENCES user_acount (id) ON DELETE CASCADE
);

CREATE TABLE movie_genre (
  id_movie INTEGER NOT NULL,
  id_genre INTEGER NOT NULL,
  PRIMARY KEY (id_movie, id_genre),
  FOREIGN KEY (id_movie) REFERENCES movie (id),
  FOREIGN KEY (id_genre) REFERENCES genre (id)
);
	
CREATE TABLE actor (
  id_movie INTEGER NOT NULL,
  id_person INTEGER NOT NULL,
  PRIMARY KEY (id_movie, id_person),
  FOREIGN KEY (id_movie) REFERENCES movie (id),
  FOREIGN KEY (id_person) REFERENCES person (id)
);

CREATE TABLE director (
  id_movie INTEGER NOT NULL,
  id_person INTEGER NOT NULL,
  PRIMARY KEY (id_movie, id_person),
  FOREIGN KEY (id_movie) REFERENCES movie (id),
  FOREIGN KEY (id_person) REFERENCES person (id)
);


-- ---
-- Test Data
-- ---

-- INSERT INTO movie (id,title,premiere) VALUES
-- ('','','');
-- INSERT INTO user_acount (id,login,password) VALUES
-- ('','','');
-- INSERT INTO person (id,name,surname,birth) VALUES
-- ('','','','');
-- INSERT INTO review (id,text,id_movie,id_rating,id_user_acount) VALUES
-- ('','','','','');
-- INSERT INTO rating (id,description) VALUES
-- ('','');
-- INSERT INTO movie_genre (id_movie,id_genre) VALUES
-- ('','');
-- INSERT INTO actor (id_movie,id_person) VALUES
-- ('','');
-- INSERT INTO director (id_movie,id_person) VALUES
-- ('','');
-- INSERT INTO genre (id,name) VALUES
-- ('','');
