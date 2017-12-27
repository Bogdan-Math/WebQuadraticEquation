package layer.repository.solution;

import layer.repository.AbstractBaseEntityRepository;
import model.Solution;
import org.springframework.stereotype.Repository;

@Repository
class SolutionRepository extends AbstractBaseEntityRepository<Solution> {

    protected Solution uncheckedGet(Solution entity) {
        Solution solution = entityManager
                .createQuery("SELECT s FROM Solution s WHERE s.x = :x", Solution.class)
                .setParameter("x", entity.getX())
                .getSingleResult();
        return solution != null ? solution : new Solution();
    }

}
