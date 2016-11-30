package layers.service.solver;

import layers.repository.equation.EquationRepository;
import layers.repository.solution.SolutionRepository;
import lombok.Getter;
import lombok.Setter;
import model.Equation;
import model.Solution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Getter
@Setter
@Service
@Transactional
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
    public Solution solve(Equation equation) throws DiscriminantException {
        Double discriminant = discriminant(equation);

        if (discriminant(equation) <= 0) throw new DiscriminantException(discriminant.toString());

        Double x1 = ( - equation.getParamB() - Math.sqrt(discriminant) ) / (2 * equation.getParamA());
        Double x2 = ( - equation.getParamB() + Math.sqrt(discriminant) ) / (2 * equation.getParamA());

        return new Solution(x1, x2);
    }

    @Autowired
    public EquationRepository equationRepository;

    @Autowired
    public SolutionRepository solutionRepository;

    public void o() {
        Equation equation = new Equation(6, 12, 18);
        Solution solution = new Solution(4.001, 5.001);

        if (equationRepository.contains(equation)) {

            Equation persistedEquation = equationRepository.get(equation);
            if (!persistedEquation.getSolution().equals(solution)) {
                //update solution for equation
                Solution persistedSolution = persistedEquation.getSolution();
                persistedSolution.setX1(solution.getX1());
                persistedSolution.setX2(solution.getX2());
                solutionRepository.save(persistedSolution);
            }

        }
        else {
            if (!solutionRepository.contains(solution)) {
                equation.setSolution(solutionRepository.save(solution));
                equationRepository.save(equation);
            }
            else {
                equation.setSolution(solutionRepository.get(solution));
                equationRepository.save(equation);
            }
        }
    }

    private Equation equation;

    public Equation calculate(Equation equation) {
        this.equation = equation;

        this.initSolution();

        return this.equation;
    }

    private void initSolution() {
        Double paramA = equation.getParamA();
        Double paramB = equation.getParamB();
        Double paramC = equation.getParamC();

        Double discriminant = paramB * paramB - 4 * paramA * paramC;

/*
        this.equation.setX1( - paramB - Math.sqrt(discriminant) );
        this.equation.setX2( - paramB + Math.sqrt(discriminant) );
*/
    }
}