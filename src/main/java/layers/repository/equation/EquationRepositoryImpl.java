package layers.repository.equation;

import model.Equation;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class EquationRepositoryImpl implements EquationRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Equation> getAll() {
        return entityManager.createQuery("SELECT e FROM Equation e", Equation.class).getResultList();
    }

    @Override
    public Equation get(int entityId) {
        return entityManager.find(Equation.class, entityId);
    }

/*
    @Override
    public boolean checkExists(Equation equation) {
        try {
            return entityManager
                    .createQuery("SELECT e FROM Equation e WHERE e.paramA=:a AND e.paramB=:b AND e.paramC=:c", Equation.class)
                    .setParameter("a", a)
                    .setParameter("b", b)
                    .setParameter("c", c)
                    .getSingleResult();
        }
        catch (NoResultException e) {
            return null;
        }
    }
*/

    @Override
    public Equation save(Equation entity) {
        if (entity.isNew()) {
            entityManager.persist(entity);
            return entity;
        }
        else {
            return entityManager.merge(entity);
        }
    }

    @Override
    public void delete(int entityId) {
        entityManager.createQuery("DELETE FROM Equation e WHERE e.id=:id").setParameter("id", entityId).executeUpdate();
    }
}
