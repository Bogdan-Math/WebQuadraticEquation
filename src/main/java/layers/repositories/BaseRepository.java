package layers.repositories;

import model.BaseEntity;

import java.util.List;

public interface BaseRepository<E extends BaseEntity> {
    List<E> getAll();
    E save(E entity);
    E get(int entityId);
    E get(E entity);
    void delete(int entityId);

    boolean contains(E entity);
}
