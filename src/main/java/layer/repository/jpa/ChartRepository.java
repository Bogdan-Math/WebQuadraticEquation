package layer.repository.jpa;

import model.Chart;
import model.Point;
import org.springframework.stereotype.Repository;

@Repository
public class ChartRepository extends AbstractBaseEntityRepository<Chart> {

    @Override
    Chart uncheckedGet(Chart entity) {
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
