package layer.service;

import layer.repository.BaseEntityRepository;
import layer.service.solver.EquationSolver;
import model.Equation;
import model.Solution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EquationServiceImpl implements EquationService {

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
    public void save(Equation equation) {
        Solution solution = equation.getSolution();

        if (!equationRepository.contains(equation)) {
            if (null == solution) {
                equationRepository.save(equation);
            }
            else if (!solutionRepository.contains(solution)) {
                equation.setSolution(solutionRepository.save(solution));
                equationRepository.save(equation);
            }
            else {
                equation.setSolution(solutionRepository.get(solution));
                equationRepository.save(equation);
            }
        }

    }
}
