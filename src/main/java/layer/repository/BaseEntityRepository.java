package layer.repository;

import model.BaseEntity;

public interface BaseEntityRepository<E extends BaseEntity> {

    E check(E entity);

    E save(E entity);
}
