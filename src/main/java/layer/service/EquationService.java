package layer.service;

import model.Equation;

public interface EquationService {
    void solve(Equation equation);
    void save(Equation equation);
}
