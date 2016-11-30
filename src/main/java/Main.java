import layers.repository.equation.EquationRepository;
import layers.repository.solution.SolutionRepository;
import layers.service.solver.DiscriminantException;
import layers.service.solver.EquationSolver;
import model.Equation;
import model.Solution;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {

        //getById one
//        System.out.println(em.find(Equation.class, 1000005));

        //getById all
//        List<Equation> bes = em.createQuery("SELECT be FROM Equation be", Equation.class).getResultList();
//        for (Equation be : bes) System.out.println(be);

        //

        new Main().methods();
    }

    public void methods() {

        ClassPathXmlApplicationContext appCtx = new ClassPathXmlApplicationContext("spring/spring.xml");
        for (String bean : appCtx.getBeanDefinitionNames())
            System.out.println(bean);


        EquationSolver equationSolverService = appCtx.getBean(EquationSolver.class);
        try {
            System.out.println(equationSolverService.solve(new Equation(1, 5.31, 2.1119)));
        } catch (DiscriminantException e) {
            System.out.println(e.getMessage());
        }

        EquationRepository equationRepository = appCtx.getBean(EquationRepository.class);
        SolutionRepository solutionRepository = appCtx.getBean(SolutionRepository.class);

        for (Equation eq : equationRepository.getAll()) System.out.println(eq);
        for (Solution s : solutionRepository.getAll()) System.out.println(s);

/*
        Equation newE = new Equation(41, 41, 41);
        Solution newS = new Solution(41, 41);

        newE.setSolution(newS);

        solutionRepository.save(newS);
        equationRepository.save(newE);
*/
        //bd.delete(1000004);
/*
        Equation newE = new Equation(3.7760001, 2.222, 3.333);
        Equation dbE = equationRepository.contains(newE.getParamA(), newE.getParamB(), newE.getParamC());
        if (null == dbE) {
            System.out.println(equationRepository.save(newE));
        }
        for (Equation eq : equationRepository.getAll()) System.out.println(eq);
*/

    }
}
