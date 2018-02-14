package layer.repository.jpa;

import model.Point;
import org.springframework.stereotype.Repository;

@Repository
public class PointRepository extends AbstractBaseEntityRepository<Point> {

    @Override
    Point uncheckedGet(Point entity) {
        return entity;
    }
}
