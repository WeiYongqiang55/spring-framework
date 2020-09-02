import com.weiyq.config.MainConfig;
import com.weiyq.config.MainConfig2;
import com.weiyq.entity.Person;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

import java.util.Map;

public class iocTest {

    @Test
    public void test01(){
        ApplicationContext context  = new AnnotationConfigApplicationContext(MainConfig.class);
//        获取容器中定义了的类的名字
        String[] definitionNames = context.getBeanDefinitionNames();
        for (String definitionName : definitionNames){
            System.out.println(definitionName);
        }
//        Person person = (Person) context.getBean("person");
//        Person person2 = (Person) context.getBean("person");
////        检查是不是获取到的是同一个对象
//        System.out.println(person == person2); //默认是true,设置scope为多实例的之后就是false了

    }

    @Test
    public void test02(){
        ApplicationContext context  = new AnnotationConfigApplicationContext(MainConfig2.class);
//        获取容器中定义了的类的名字
        String[] definitionNames = context.getBeanDefinitionNames();
        for (String definitionName : definitionNames){
            System.out.println(definitionName);
        }
        Person person = (Person) context.getBean("person");
        System.out.println(person);
    }


    @Test
    public void test04(){
        ApplicationContext context  = new AnnotationConfigApplicationContext(MainConfig.class);
//        获取容器中定义了的类的名字
        String[] definitionNames = context.getBeanDefinitionNames();
        for (String definitionName : definitionNames){
            System.out.println(definitionName);
        }


//        获取到所有beans
        Map<String, Person> beans = context.getBeansOfType(Person.class);
        for(String name:beans.keySet()){
            System.out.println(beans.get(name));
        }


        Environment environment = context.getEnvironment();
//        获取操作系统类型
        String osName = environment.getProperty("os.name");
        System.out.println(osName);


    }

    @Test
    public void testImport(){
        ApplicationContext context  = new AnnotationConfigApplicationContext(MainConfig.class);
        printbeans((AnnotationConfigApplicationContext) context);
    }

    public void printbeans(AnnotationConfigApplicationContext context){

//        获取容器中定义了的类的名字
        String[] definitionNames = context.getBeanDefinitionNames();
        for (String definitionName : definitionNames){
            System.out.println(definitionName);
        }
    }


    @Test
    public void testFactoryBean(){
        ApplicationContext context  = new AnnotationConfigApplicationContext(MainConfig.class);
//        注入的是COlolr类
        Object bean = context.getBean("ColorFactoryBean");
//        注入的是工厂bean
//        Object bean = context.getBean("&ColorFactoryBean");
        System.out.println("bean类民 "+bean.getClass());

        printbeans((AnnotationConfigApplicationContext) context);
    }
}
