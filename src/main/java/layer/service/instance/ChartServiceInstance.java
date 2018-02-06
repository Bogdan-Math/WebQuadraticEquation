package layer.service.instance;

import layer.service.ChartService;
import model.Chart;
import model.Point;
import org.springframework.stereotype.Service;

@Service
class ChartServiceInstance implements ChartService {

    @Override
    public Chart getChart() {
        //TODO: move to repository
        return new Chart(new Point[] {
                new Point(-4,16),
                new Point(-3,9),
                new Point(-2,4),
                new Point(-1,1),
                new Point(0,0),
                new Point(1,1),
                new Point(2,4),
                new Point(3,9),
                new Point(4,16)
        },
                -4,
                4,
                -1,
                16
        );
    }
}
