package layer.service.instance;

import layer.repository.BaseEntityRepository;
import layer.service.ChartService;
import model.Chart;
import model.Equation;
import model.Point;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class ChartServiceInstance implements ChartService {

    @Autowired
    private BaseEntityRepository<Chart> chartRepository;

    @Override
    public Chart buildChartFor(Equation equation) {
        Chart chart = chartRepository.check(null);

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

        chart.setPoints(new Point[] {
                new Point(x8, y4),
                new Point(x6, y3),
                new Point(x4, y2),
                new Point(x2, y1),
                new Point(x0, y0),
                new Point(x1, y1),
                new Point(x3, y2),
                new Point(x5, y3),
                new Point(x7, y4)
        });

        chart.setSuggestedMinX(x8 - 1);
        chart.setSuggestedMaxX(x7 + 1);

        chart.setSuggestedMinY( (y0 < y4 ? y0 : y4) - 1);
        chart.setSuggestedMaxY( (y0 > y4 ? y0 : y4) + 1);

        return chart;
    }

    private double initY(double x, Equation equation) {
        return x * x * equation.getParamA() + x * equation.getParamB() + equation.getParamC();
    }
}
