package layer.repository;

import model.BaseEntity;

public interface ChartRepository<E extends BaseEntity> {
    E check(E entity);
    E save(E entity);
}
