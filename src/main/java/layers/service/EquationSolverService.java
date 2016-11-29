package layers.service;

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
public class EquationSolverService {

    @Autowired
    public EquationRepository equationRepository;

    @Autowired
    public SolutionRepository solutionRepository;


    public void o() {
        for (Equation eq : equationRepository.getAll()) System.out.println(eq.getSolution());
        for (Solution s : solutionRepository.getAll()) System.out.println(s.getEquations());
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
