import layers.repositories.equation.EquationRepository;
import layers.repositories.solution.SolutionRepository;
import layers.services.EquationHandler;
import model.Equation;
import model.Solution;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        new Main().methods();
    }

    public void methods() {

        ClassPathXmlApplicationContext appCtx = new ClassPathXmlApplicationContext("spring/spring.xml");
        for (String bean : appCtx.getBeanDefinitionNames())
            System.out.println(bean);

        EquationHandler bean = appCtx.getBean(EquationHandler.class);
        Equation equation = new Equation(1.111222, 54.1311, 62);

/*
        bean.process(equation);
        bean.smartSave(equation, equation.getSolution());
*/

        EquationRepository equationRepository = appCtx.getBean(EquationRepository.class);
        SolutionRepository solutionRepository = appCtx.getBean(SolutionRepository.class);

        for (Equation eq : equationRepository.getAll()) System.out.println(eq);
        for (Solution s : solutionRepository.getAll()) System.out.println(s);

    }
}
