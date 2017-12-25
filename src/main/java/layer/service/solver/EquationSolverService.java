package layer.service.solver;

import model.Equation;
import model.Solution;
import org.springframework.stereotype.Service;

@Service
public class EquationSolverService implements EquationSolver {

    @Override
    public Double discriminant(Equation equation) {
        Double paramA = equation.getParamA();
        Double paramB = equation.getParamB();
        Double paramC = equation.getParamC();

        return paramB * paramB - 4 * paramA * paramC;
    }

    @Override
    public void solve(Equation equation) throws DiscriminantException {
        Double x1;
        Double x2;

        Double discriminant = discriminant(equation);

        if (discriminant < 0) throw new DiscriminantException(discriminant.toString());

        if (discriminant == 0) {
            Double result = ( - equation.getParamB() ) / (2 * equation.getParamA());
            equation.setSolution(new Solution(result, result));
        }

        if (discriminant > 0) {
            x1 = ( - equation.getParamB() - Math.sqrt(discriminant) ) / (2 * equation.getParamA());
            x2 = ( - equation.getParamB() + Math.sqrt(discriminant) ) / (2 * equation.getParamA());

            equation.setSolution(new Solution(x1, x2));
        }
    }
}
