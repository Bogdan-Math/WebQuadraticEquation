package layers.controllers;

import layers.services.EquationHandler;
import model.Equation;
import model.Solution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/equation")
public class EquationJsonController {

    @Autowired
    private EquationHandler equationHandler;

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Solution calc(@RequestBody Equation equation) {
        equationHandler.handle(equation);
        return equation.getSolution();
    }

}
