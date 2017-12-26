package layer.repository.equation;

import layer.repository.AbstractBaseEntityRepository;
import model.Equation;
import org.springframework.stereotype.Repository;

@Repository
class EquationRepository extends AbstractBaseEntityRepository<Equation> {

    protected Equation uncheckedGet(Equation entity) {
        return entityManager
                .createQuery("SELECT e FROM Equation e WHERE e.paramA=:a AND e.paramB=:b AND e.paramC=:c", Equation.class)
                .setParameter("a", entity.getParamA())
                .setParameter("b", entity.getParamB())
                .setParameter("c", entity.getParamC())
                .getSingleResult();
    }
}
