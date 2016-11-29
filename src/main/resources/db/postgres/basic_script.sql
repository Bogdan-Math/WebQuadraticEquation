/*init global_sequence*/
DROP SEQUENCE IF EXISTS global_sequence CASCADE;
CREATE SEQUENCE global_sequence START 1000000;

/*init users table*/
DROP TABLE IF EXISTS equation CASCADE;
CREATE TABLE equation
(
  id          INTEGER DEFAULT nextval('global_sequence'),
  solution_id INTEGER,

  param_a FLOAT DEFAULT 0,
  param_b FLOAT DEFAULT 0,
  param_c FLOAT DEFAULT 0,

  has_natural_solution BOOLEAN DEFAULT NULL,

  PRIMARY KEY (id),
  FOREIGN KEY (solution_id) REFERENCES solution(id) ON DELETE CASCADE
);

DROP TABLE IF EXISTS solution CASCADE;
CREATE TABLE solution
(
  id INTEGER DEFAULT nextval('global_sequence'),

  x_1 FLOAT DEFAULT NULL,
  x_2 FLOAT DEFAULT NULL,

  PRIMARY KEY (id)
);