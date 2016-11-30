package layers.services;

import model.Equation;
import model.Solution;

public interface EquationHandlerService {
    void process(Equation equation);
    void smartSave(Equation equation, Solution solution);
}
