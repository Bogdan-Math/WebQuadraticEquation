package layers.repository.solution;

import model.Solution;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class SolutionRepositoryImpl implements SolutionRepository{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public boolean checkExists(Solution solution) {
        return false;
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
    public void delete(int entityId) {
        entityManager.createQuery("DELETE FROM Solution s WHERE s.id=:id").setParameter("id", entityId).executeUpdate();
    }
}
