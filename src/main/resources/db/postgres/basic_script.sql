/*init global_sequence*/
DROP SEQUENCE IF EXISTS global_sequence CASCADE;
CREATE SEQUENCE global_sequence START 1000000;

/*init users table*/
DROP TABLE IF EXISTS equation CASCADE;
CREATE TABLE equation
(
  id      INTEGER DEFAULT nextval('global_sequence'),

  param_a FLOAT DEFAULT 0,
  param_b FLOAT DEFAULT 0,
  param_c FLOAT DEFAULT 0,

  x_1     FLOAT DEFAULT NULL,
  x_2     FLOAT DEFAULT NULL,

  has_natural_solution BOOLEAN DEFAULT NULL,

  PRIMARY KEY (id)
);

INSERT INTO equation (param_a, param_b, param_c) VALUES (31.2, 44.61, -14.76);

SELECT param_a, param_b, param_c FROM equation;