package layer.controller;

import layer.service.ChartService;
import model.Chart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/chart")
public class ChartController {

    @Autowired
    private ChartService chartService;

    @RequestMapping(method   = RequestMethod.POST,
                    produces = MediaType.APPLICATION_JSON_VALUE)
    public Chart chart() {
        return chartService.getChart();
    }
}