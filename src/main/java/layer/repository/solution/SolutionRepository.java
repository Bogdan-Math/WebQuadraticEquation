package layer.repository.solution;

import layer.repository.AbstractBaseEntityRepository;
import model.Solution;
import org.springframework.stereotype.Repository;

@Repository
public class SolutionRepository extends AbstractBaseEntityRepository<Solution> {

    protected Solution uncheckedGet(Solution entity) {
        return entityManager
                .createQuery("SELECT s FROM Solution s WHERE s.x1 = :x1 AND s.x2 = :x2", Solution.class)
                .setParameter("x1", entity.getX1())
                .setParameter("x2", entity.getX2())
                .getSingleResult();
    }

}
