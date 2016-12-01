package layers.services;

import layers.services.saver.EquationSaver;
import layers.services.solver.DiscriminantException;
import layers.services.solver.EquationSolver;
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
            equationSaver.smartSave(equation);
        }
    }

}
