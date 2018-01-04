package layer.repository.jpa;

import layer.repository.BaseEntityRepository;
import model.BaseEntity;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

abstract class AbstractBaseEntityRepository<E extends BaseEntity> implements BaseEntityRepository<E> {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public E check(E entity) {
        try {
            return uncheckedGet(entity);
        } catch (NoResultException e) {
            return entity;
        }
    }


    abstract E uncheckedGet(E entity);

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
