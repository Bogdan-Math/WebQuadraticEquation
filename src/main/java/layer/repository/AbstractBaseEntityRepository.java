package layer.repository;

import model.BaseEntity;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

public abstract class AbstractBaseEntityRepository<E extends BaseEntity> implements BaseEntityRepository<E> {

    @PersistenceContext
    protected EntityManager entityManager;

    @Override
    public E get(E entity) {
        try {
            return uncheckedGet(entity);
        } catch (NoResultException e) {
            return null;
        }
    }


    protected abstract E uncheckedGet(E entity);

    @Override
    public boolean contains(E entity) {
        return null != this.get(entity);
    }

    @Override
    public E save(E entity) {
        if (entity.isNew()) {
            entityManager.persist(entity);
            return entity;
        }
        else {
            return entityManager.merge(entity);
        }

    }
}
