package layer.controller;

import layer.service.ChartService;
import model.Point;
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
    public O chart() {
        return new O(chartService.getChartPoints());
    }

    class O {

        private Point[] points;
        double suggestedMinX = -4;
        double suggestedMaxX = 4;
        double suggestedMinY = -1;
        double suggestedMaxY = 16;

        O(Point[] points) {
            this.points = points;
        }

        public Point[] getPoints() {
            return points;
        }

        public void setPoints(Point[] points) {
            this.points = points;
        }

        public double getSuggestedMinX() {
            return suggestedMinX;
        }

        public void setSuggestedMinX(double suggestedMinX) {
            this.suggestedMinX = suggestedMinX;
        }

        public double getSuggestedMaxX() {
            return suggestedMaxX;
        }

        public void setSuggestedMaxX(double suggestedMaxX) {
            this.suggestedMaxX = suggestedMaxX;
        }

        public double getSuggestedMinY() {
            return suggestedMinY;
        }

        public void setSuggestedMinY(double suggestedMinY) {
            this.suggestedMinY = suggestedMinY;
        }

        public double getSuggestedMaxY() {
            return suggestedMaxY;
        }

        public void setSuggestedMaxY(double suggestedMaxY) {
            this.suggestedMaxY = suggestedMaxY;
        }
    }
}