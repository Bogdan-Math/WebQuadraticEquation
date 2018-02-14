package layer.service;

import model.Chart;
import model.Equation;

public interface ChartService {
    Chart buildChartFor(Equation equation);
}
