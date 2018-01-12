package layer.controller;

import layer.service.EquationService;
import model.Equation;
import model.Solution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

import static java.util.stream.Collectors.toSet;

@RestController
@RequestMapping(value = "/equation")
public class EquationController {

    @Autowired
    private EquationService equationService;

    @RequestMapping(method = RequestMethod.POST,
                    consumes = MediaType.APPLICATION_JSON_VALUE,
                    produces = MediaType.APPLICATION_JSON_VALUE)
    public Set<Double> solve(@RequestBody Equation equation) {
        equationService.solve(equation);
        equationService.save(equation);
        return equation.solutions()
                .stream()
                .map(Solution::getX)
                .collect(toSet());
    }

}
