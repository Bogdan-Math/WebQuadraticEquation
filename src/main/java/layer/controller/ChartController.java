package layer.controller;

import model.Point;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/chart")
public class ChartController {

    @RequestMapping(method = RequestMethod.POST,
                    produces = MediaType.APPLICATION_JSON_VALUE)
    public Point[] chart() {
        return new Point[] {
                new Point(-3,9),
                new Point(-2,4),
                new Point(-1,1),
                new Point(0,0),
                new Point(1,1),
                new Point(2,4),
                new Point(3,9)
        };
    }
}