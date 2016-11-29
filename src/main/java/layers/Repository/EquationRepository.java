package layers.repository;

import model.Equation;

public interface EquationRepository extends BaseRepository<Equation> {
    Equation getByParams(float a, float b, float c);
}
