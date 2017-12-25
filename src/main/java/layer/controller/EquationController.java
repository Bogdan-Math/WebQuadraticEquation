package layer.controller;

import layer.service.saver.EquationSaver;
import layer.service.solver.EquationSolver;
import model.Equation;
import model.Solution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/equation")
public class EquationController {

    @Autowired
    private EquationSolver solver;

    @Autowired
    private EquationSaver saver;

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST,
                    consumes = MediaType.APPLICATION_JSON_VALUE,
                    produces = MediaType.APPLICATION_JSON_VALUE)
    public Solution solve(@RequestBody Equation equation) {
        solver.solve(equation);
        saver.save(equation);
        return equation.getSolution();
    }

}
