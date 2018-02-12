CREATE TABLE solution
(
  id INTEGER DEFAULT nextval('global_sequence' :: REGCLASS) NOT NULL
     CONSTRAINT solution_pk
     PRIMARY KEY,

  x  DOUBLE PRECISION
);