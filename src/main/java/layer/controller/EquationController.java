package layer.controller;

import layer.service.EquationService;
import lombok.AllArgsConstructor;
import lombok.Getter;
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
public class EquationController {

    @Autowired
    private EquationService equationService;

    @RequestMapping(value = "/equation",
                    method = RequestMethod.POST,
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

    @RequestMapping(value = "/chart",
                    method = RequestMethod.POST,
                    produces = MediaType.APPLICATION_JSON_VALUE)
    public El[] a() {
        return new El[] {
                new El(-3,9),
                new El(-2,4),
                new El(-1,1),
                new El(0,0),
                new El(1,1),
                new El(2,4),
                new El(3,9)
        };
    }

    @Getter
    @AllArgsConstructor
    class El { int x; int y; }
}
