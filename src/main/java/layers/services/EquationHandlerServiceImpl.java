package layers.services;

import layers.repositories.equation.EquationRepository;
import layers.repositories.solution.SolutionRepository;
import layers.services.solver.DiscriminantException;
import layers.services.solver.EquationSolver;
import model.Equation;
import model.Solution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EquationHandlerServiceImpl implements EquationHandlerService{

    @Autowired
    private EquationRepository equationRepository;

    @Autowired
    private SolutionRepository solutionRepository;

    @Autowired
    private EquationSolver equationSolver;

    @Override
    public void process(Equation equation) {
        try {
            equationSolver.solve(equation);
        }
        catch (DiscriminantException e) {
            System.out.println(e.getMessage());
            equation.setSolution(null);
        }
    }

    @Override
    public void smartSave(Equation equation, Solution solution) {

        if (!equationRepository.contains(equation)) {
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
}
