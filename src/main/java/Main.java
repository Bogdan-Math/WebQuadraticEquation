import model.BaseEntity;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        BaseEntity e = new BaseEntity(31.543f, 4322.65f, 76.990f);
        System.out.println(e);

        ClassPathXmlApplicationContext appCtx = new ClassPathXmlApplicationContext("spring/spring.xml");
        for (String bean : appCtx.getBeanDefinitionNames())
        System.out.println(bean);

        EntityManagerFactory emf = appCtx.getBean(EntityManagerFactory.class);
        EntityManager em = emf.createEntityManager();

        List<BaseEntity> bes = em.createQuery("SELECT be FROM BaseEntity be", BaseEntity.class).getResultList();
        for (BaseEntity be : bes) System.out.println(be);
    }
}
