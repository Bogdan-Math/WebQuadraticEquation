package layers.repository.solution;

import model.Solution;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class SolutionRepositoryImpl implements SolutionRepository{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public boolean contains(Solution entity) {
        return null != this.get(entity);
    }

    @Override
    public List<Solution> getAll() {
        return entityManager.createQuery("SELECT s FROM Solution s", Solution.class).getResultList();
    }

    @Override
    public Solution save(Solution entity) {
        if (entity.isNew()) {
            entityManager.persist(entity);
            return entity;
        }
        else {
            return entityManager.merge(entity);
        }
    }

    @Override
    public Solution get(int entityId) {
        return entityManager.find(Solution.class, entityId);
    }

    @Override
    public Solution get(Solution entity) {
        try {
            return entityManager
                    .createQuery("SELECT s FROM Solution s WHERE s.x1=:x1 AND s.x2=:x2", Solution.class)
                    .setParameter("x1", entity.getX1())
                    .setParameter("x2", entity.getX2())
                    .getSingleResult();
        }
        catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public void delete(int entityId) {
        entityManager.createQuery("DELETE FROM Solution s WHERE s.id=:id").setParameter("id", entityId).executeUpdate();
    }
}
