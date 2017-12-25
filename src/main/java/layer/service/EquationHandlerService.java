package layer.service;

import layer.service.saver.EquationSaver;
import layer.service.solver.DiscriminantException;
import layer.service.solver.EquationSolver;
import model.Equation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EquationHandlerService implements EquationHandler {

    @Autowired
    private EquationSolver equationSolver;

    @Autowired
    private EquationSaver equationSaver;

    @Override
    public void handle(Equation equation) {
        try {
            equationSolver.solve(equation);
        }
        catch (DiscriminantException e) {
            System.out.println(e.getMessage());
        }
        finally {
            equationSaver.save(equation);
        }
    }

}
