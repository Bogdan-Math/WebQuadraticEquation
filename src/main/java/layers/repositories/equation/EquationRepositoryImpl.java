package layers.repositories.equation;

import model.Equation;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

@Repository
@Transactional
public class EquationRepositoryImpl implements EquationRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Equation get(Equation entity) {
        try {
            return entityManager
                    .createQuery("SELECT e FROM Equation e WHERE e.paramA=:a AND e.paramB=:b AND e.paramC=:c", Equation.class)
                    .setParameter("a", entity.getParamA())
                    .setParameter("b", entity.getParamB())
                    .setParameter("c", entity.getParamC())
                    .getSingleResult();
        }
        catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public boolean contains(Equation entity) {
        return null != this.get(entity);
    }

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

}
