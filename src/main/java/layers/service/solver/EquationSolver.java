package layers.service.solver;

import model.Equation;
import model.Solution;

public interface EquationSolver {
    Double discriminant(Equation equation);
    Solution solve(Equation equation) throws DiscriminantException;
}
