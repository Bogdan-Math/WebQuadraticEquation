package layer.service.instance;

import layer.service.ChartService;
import model.Chart;
import model.Equation;
import model.Point;
import org.springframework.stereotype.Service;

@Service
class ChartServiceInstance implements ChartService {

    @Override
    public Chart buildChartFor(Equation equation) {

        double x0 = - equation.getParamB() / (2 * equation.getParamA());
        double y0 = initY(x0, equation);

        double x1 = x0 + 1;
        double x2 = x0 - 1;
        double y1 = initY(x1, equation);

        double x3 = x0 + 2;
        double x4 = x0 - 2;
        double y2 = initY(x3, equation);

        double x5 = x0 + 3;
        double x6 = x0 - 3;
        double y3 = initY(x5, equation);

        double x7 = x0 + 4;
        double x8 = x0 - 4;
        double y4 = initY(x7, equation);

        Point[] points = {
                new Point(x8, y4),
                new Point(x6, y3),
                new Point(x4, y2),
                new Point(x2, y1),
                new Point(x0, y0),
                new Point(x1, y1),
                new Point(x3, y2),
                new Point(x5, y3),
                new Point(x7, y4)
        };

        double minX = x8 - 1;
        double maxX = x7 + 1;

        double minY = (y0 < y4 ? y0 : y4) - 1;
        double maxY = (y0 > y4 ? y0 : y4) + 1;

        return new Chart(points, minX, maxX, minY, maxY);//TODO: save chart to db
    }

    private double initY(double x, Equation equation) {
        return x * x * equation.getParamA() + x * equation.getParamB() + equation.getParamC();
    }
}
