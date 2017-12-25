package layer.service.solver;

import model.Equation;

public interface EquationSolver {
    Double discriminant(Equation equation);
    void solve(Equation equation) throws DiscriminantException;
}
