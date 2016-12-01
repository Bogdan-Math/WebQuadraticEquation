package layers.controllers;

import model.Equation;
import model.Solution;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/equation")
public class EquationJsonController {

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Solution calc(@RequestBody Equation equation) {

        System.out.println(equation);
        return new Solution(0.001, 1.4);
    }

}
