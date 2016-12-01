package layers.repositories;

import model.BaseEntity;

public interface BaseRepository<E extends BaseEntity> {
    E save(E entity);
    E get(E entity);

    boolean contains(E entity);
}
