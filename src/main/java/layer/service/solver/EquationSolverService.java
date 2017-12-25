package layer.service.solver;

import model.Equation;
import model.Solution;
import org.springframework.stereotype.Service;

@Service
public class EquationSolverService implements EquationSolver {

    @Override
    public void solve(Equation equation) {

        Double discriminant = discriminantOf(equation);

        if (discriminant < 0) return;

        if (discriminant == 0) {
            final Double x = ( - equation.getParamB() ) / (2 * equation.getParamA());
            equation.setSolution(new Solution(x, x));
        }

        if (discriminant > 0) {
            final Double x1 = ( - equation.getParamB() - Math.sqrt(discriminant) ) / (2 * equation.getParamA() );
            final Double x2 = ( - equation.getParamB() + Math.sqrt(discriminant) ) / (2 * equation.getParamA() );

            equation.setSolution(new Solution(x1, x2));
        }
    }

    private Double discriminantOf(Equation equation) {
        Double paramA = equation.getParamA();
        Double paramB = equation.getParamB();
        Double paramC = equation.getParamC();

        return paramB * paramB - 4 * paramA * paramC;
    }
}
