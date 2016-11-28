import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        Entity e = new Entity(31.543f, 4322.65f, 76.990f);
        System.out.println(e);

        ClassPathXmlApplicationContext appCtx = new ClassPathXmlApplicationContext("spring/spring.xml");
        for (String bean : appCtx.getBeanDefinitionNames())
        System.out.println(bean);
    }
}
