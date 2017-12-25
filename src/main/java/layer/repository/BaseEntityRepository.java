package layer.repository;

import model.BaseEntity;

public interface BaseEntityRepository<E extends BaseEntity> {

    E get(E entity);

    boolean contains(E entity);
    E save(E entity);
}
