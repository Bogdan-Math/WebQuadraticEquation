package layers.repository;

import model.BaseEntity;

import java.util.List;

public interface BaseRepository<E extends BaseEntity> {
    List<E> getAll();
    E save(E entity);
    E get(int entityId);
    void delete(int entityId);
}
