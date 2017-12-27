/*init global_sequence*/
DROP SEQUENCE IF EXISTS global_sequence CASCADE;
CREATE SEQUENCE global_sequence START 1000000;

/*init solution table*/
DROP TABLE IF EXISTS solution CASCADE;
CREATE TABLE solution(

  id INTEGER DEFAULT nextval('global_sequence'),

  x FLOAT DEFAULT NULL,

  PRIMARY KEY (id)
);

/*init equation table*/
DROP TABLE IF EXISTS equation CASCADE;
CREATE TABLE equation(

  id INTEGER DEFAULT nextval('global_sequence'),

  param_a FLOAT DEFAULT 0,
  param_b FLOAT DEFAULT 0,
  param_c FLOAT DEFAULT 0,

  PRIMARY KEY (id)
);

/*init equation_solution table*/
DROP TABLE IF EXISTS equation_solution CASCADE;
CREATE TABLE equation_solution(

  equation_id INTEGER,
  solution_id INTEGER,

  FOREIGN KEY (equation_id) REFERENCES equation(id),
  FOREIGN KEY (solution_id) REFERENCES solution(id)

);