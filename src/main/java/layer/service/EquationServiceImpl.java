package layer.service;

import layer.repository.BaseEntityRepository;
import layer.service.solver.EquationSolver;
import model.Equation;
import model.Solution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
public class EquationServiceImpl implements EquationService {

    @Autowired
    private EquationSolver equationSolver;

    @Autowired
    private BaseEntityRepository<Equation> equationRepository;

    @Autowired
    private BaseEntityRepository<Solution> solutionRepository;

    @Transactional
    @Override//TODO: add logging
    public void solve(Equation equation) {
        equationSolver.solve(equation);
    }

    @Async
    @Transactional
    @Override//TODO: add logging
    public void save(Equation equation) {
        Set<Solution> solutions = equation.safeSolutions();

        if (!equationRepository.contains(equation)) {
            for (Solution solution : solutions) {
                if (!solutionRepository.contains(solution)) {
                    solution.setId(solutionRepository.save(solution).getId());
                } else {
                    solution.setId(solutionRepository.get(solution).getId());
                }
            }
            equationRepository.save(equation);
        }

    }
}
