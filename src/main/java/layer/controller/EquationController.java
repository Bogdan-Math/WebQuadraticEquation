package layer.controller;

import layer.service.EquationService;
import model.Equation;
import model.Solution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Set;

@Controller
@RequestMapping(value = "/equation")
public class EquationController {

    @Autowired
    private EquationService equationService;

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST,
                    consumes = MediaType.APPLICATION_JSON_VALUE,
                    produces = MediaType.APPLICATION_JSON_VALUE)
    public Set<Solution> solve(@RequestBody Equation equation) {
        equationService.solve(equation);
        equationService.save(equation);
        return equation.solutions();
    }

}
