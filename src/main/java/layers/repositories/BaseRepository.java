package layers.repositories;

import model.BaseEntity;

import java.util.List;

public interface BaseRepository<E extends BaseEntity> {
    List<E> getAll();
    E save(E entity);
    E get(E entity);

    boolean contains(E entity);
}
