package layer.service;

import layer.repository.BaseEntityRepository;
import model.Equation;
import model.Solution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
class EquationServiceInstance implements EquationService {

    @Autowired
    private EquationSolver equationSolver;

    @Autowired
    private BaseEntityRepository<Equation> equationRepository;

    @Autowired
    private BaseEntityRepository<Solution> solutionRepository;

    @Override//TODO: add logging
    public void solve(Equation equation) {
        equationSolver.solve(equation);
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
