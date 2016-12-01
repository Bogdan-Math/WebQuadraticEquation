package layers.services.solver;

import model.Equation;
import model.Solution;
import org.springframework.stereotype.Service;

@Service
public class EquationSolverService implements EquationSolver {

    private Double discriminant;

    @Override
    public Double discriminant(Equation equation) {
        if (null == this.discriminant) {
            Double paramA = equation.getParamA();
            Double paramB = equation.getParamB();
            Double paramC = equation.getParamC();

            this.discriminant = paramB * paramB - 4 * paramA * paramC;
        }

        return this.discriminant;
    }

    @Override
    public void solve(Equation equation) throws DiscriminantException {
        Double discriminant = discriminant(equation);

        if (discriminant(equation) <= 0) throw new DiscriminantException(discriminant.toString());

        Double x1 = ( - equation.getParamB() - Math.sqrt(discriminant) ) / (2 * equation.getParamA());
        Double x2 = ( - equation.getParamB() + Math.sqrt(discriminant) ) / (2 * equation.getParamA());

        equation.setSolution(new Solution(x1, x2));
    }
}
