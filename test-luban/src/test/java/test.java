import com.weiyq.config.MainConfig;
import com.weiyq.entity.Person;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class test {
	@Test
    public static void main(String[] args) {

        /**
         * xml 配置方法
         */
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
////        获取bean
//        Person person = (Person) applicationContext.getBean("Person");
//        System.out.println(person);
        /**
         * 配置类配置
         */
        ApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
//        使用类型获取
		Person bean = context.getBean(Person.class);
        System.out.println(bean);


//        id的名字
        String[] namesFortype = context.getBeanNamesForType(Person.class);
        for(String name:namesFortype){
            System.out.println(name);
        }

//        改名字
    }

}
