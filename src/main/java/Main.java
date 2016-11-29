import layers.repository.EquationRepository;
import layers.repository.EquationRepositoryImpl;
import model.Equation;
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

        EquationRepository equationRepository = appCtx.getBean(EquationRepository.class);

        //bd.delete(1000004);
        Equation newE = new Equation(3.7760001, 2.222, 3.333);
        Equation dbE = equationRepository.getByParams(newE.getParamA(), newE.getParamB(), newE.getParamC());
        if (null == dbE) {
            System.out.println(equationRepository.save(newE));
        }
        for (Equation eq : equationRepository.getAll()) System.out.println(eq);

    }
}
