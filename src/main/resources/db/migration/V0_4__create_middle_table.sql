CREATE TABLE equation_solution
(
  equation_id INTEGER
    CONSTRAINT equation_id_fk
    REFERENCES equation
    ON DELETE CASCADE,

  solution_id INTEGER
    CONSTRAINT solution_id_fk
    REFERENCES solution
    ON DELETE CASCADE
);

