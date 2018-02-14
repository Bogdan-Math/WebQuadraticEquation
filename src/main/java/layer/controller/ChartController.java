package layer.controller;

import layer.service.ChartService;
import model.Chart;
import model.Equation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping(value = "/chart")
public class ChartController {

    @Autowired
    private ChartService chartService;

    @RequestMapping(method   = RequestMethod.POST,
                    consumes = MediaType.APPLICATION_JSON_VALUE,
                    produces = MediaType.APPLICATION_JSON_VALUE)
    public Chart chart(@RequestBody Equation equation) {
        System.out.println(equation);
        return chartService.getChart();
    }
}