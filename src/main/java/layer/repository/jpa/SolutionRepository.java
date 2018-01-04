package layer.repository.jpa;

import model.Solution;
import org.springframework.stereotype.Repository;

@Repository
class SolutionRepository extends AbstractBaseEntityRepository<Solution> {

    Solution uncheckedGet(Solution entity) {
        return entityManager
                .createQuery("SELECT s FROM Solution s WHERE s.x = :x", Solution.class)
                .setParameter("x", entity.getX())
                .getSingleResult();
    }

}
