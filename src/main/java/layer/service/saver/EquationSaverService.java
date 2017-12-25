package layer.service.saver;

import layer.repository.BaseEntityRepository;
import model.Equation;
import model.Solution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EquationSaverService implements EquationSaver {

    @Autowired
    private BaseEntityRepository<Equation> equationRepository;

    @Autowired
    private BaseEntityRepository<Solution> solutionRepository;

    @Async
    @Transactional
    @Override
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
