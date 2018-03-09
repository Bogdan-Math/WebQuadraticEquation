package layer.service.instance;

import layer.repository.BaseEntityRepository;
import layer.service.EquationService;
import model.Equation;
import model.Solution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
public class EquationServiceInstance implements EquationService {

    @Autowired
    private BaseEntityRepository<Equation> equationRepository;

    @Autowired
    private BaseEntityRepository<Solution> solutionRepository;

    @Override//TODO: add logging
    public void solve(Equation equation) {

        Double discriminant = discriminantOf(equation);

        if (discriminant < 0) return;

        if (discriminant == 0) {
            final Double x = ( - equation.getParamB() ) / (2 * equation.getParamA());
            equation.addSolutions(x);
        }

        if (discriminant > 0) {
            final Double x1 = ( - equation.getParamB() - Math.sqrt(discriminant) ) / (2 * equation.getParamA() );
            final Double x2 = ( - equation.getParamB() + Math.sqrt(discriminant) ) / (2 * equation.getParamA() );
            equation.addSolutions(x1, x2);
        }
    }

    private Double discriminantOf(Equation equation) {
        Double paramA = equation.getParamA();
        Double paramB = equation.getParamB();
        Double paramC = equation.getParamC();

        return paramB * paramB - 4 * paramA * paramC;
    }

    @Async
    @Transactional
    @Override//TODO: add logging
    public void save(Equation incomeEquation) {
        Equation checkedEquation = equationRepository.check(incomeEquation);
        Set<Solution> solutions  = checkedEquation.solutions();

        if (checkedEquation.isNew()) {
            for (Solution solution : solutions) {
                Solution checkedSolution = solutionRepository.check(solution);
                if (checkedSolution.isNew()) {
                    solution.setId(solutionRepository.save(solution).getId());
                } else {
                    solution.setId(checkedSolution.getId());
                }
            }
            equationRepository.save(incomeEquation);
        }
    }
}